/*
 * TurtleScheduler.java -TurtleKit - A 'star logo' in MadKit
 * Copyright (C) 2000-2005 Fabien Michel
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package turtlekit2.kernel.observers;

import madkit.kernel.Message;
import madkit.simulation.activators.TurboMethodActivator;
import turtlekit2.kernel.creators.Tk2Launcher;
import turtlekit2.kernel.tools.TopMessage;

/** The TurtleKit scheduler
 *
 * @author Fabien MICHEL
 * @version 3.0 20/05/2005
 *
 */

public class TurtleScheduler extends madkit.kernel.Scheduler {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final public static int RUNNING=1;
    final public static int PAUSED=2;
    final public static int STOPPED=3;
    final public static int STEP=4;
    
    public int schedulingState;
    public String group;
    TurtleActivator turtleDoIt;
    TurboMethodActivator oberserversDoIt,viewersDoIt,displayAllWorld,updateDisplay,evaporation,diffusion;
    
    public int iteration = 0;
    public int delay = 100;
    
    public TurtleScheduler(String group) {
        this.group=group;
        schedulingState=PAUSED;
    }
    
    public void activate() {
        requestRole(Tk2Launcher.COMMUNITY,group,"scheduler",null);
        
        turtleDoIt = new TurtleActivator(group);
        addActivator(turtleDoIt);
        oberserversDoIt = new TurboMethodActivator("watch",Tk2Launcher.COMMUNITY,group,"observer");
        addActivator(oberserversDoIt);
        viewersDoIt = new TurboMethodActivator("display",Tk2Launcher.COMMUNITY,group,"viewer");
        addActivator(viewersDoIt );
        diffusion= new TurboMethodActivator("diffusion",Tk2Launcher.COMMUNITY,group,"world");
        addActivator(diffusion);
        evaporation = new TurboMethodActivator("evaporation",Tk2Launcher.COMMUNITY,group,"world");
        addActivator(evaporation);
        displayAllWorld = new TurboMethodActivator("displayOn",Tk2Launcher.COMMUNITY,group,"world");
        addActivator(displayAllWorld);
        updateDisplay = new TurboMethodActivator("displayOff",Tk2Launcher.COMMUNITY,group,"world");
        addActivator(updateDisplay);
        
        sendMessage(Tk2Launcher.COMMUNITY,group,"launcher",new TopMessage(-1));
        
        //oberserversDoIt.execute();
    }
    
    public void live() {
        while(true) {
            exitImmediatlyOnKill();
            if (delay == 0)
                Thread.yield();
            else
                pause(delay);
            checkMail();
            switch(schedulingState){
                case(RUNNING):running();break;
                case(PAUSED):paused();break;
                case(STEP):schedulingState=PAUSED;running();break;
                case(STOPPED):stoped();break;
                default:return;
            }
        }
    }
    
    public void running(){
        scheduleWorld();
        iteration++;
    }
    
    public void paused(){
        pause(50);
        displayAllWorld.execute();
        viewersDoIt.execute();
    }
    
    public void stoped(){
        iteration=0;
        pause(300);
    }
    
    public void end() {
        println("ending");
        schedulingState=STOPPED;
        removeAllActivators();
        sendMessage(Tk2Launcher.COMMUNITY,group,"launcher",new TopMessage(0));
        leaveGroup(group);
    }
    
    final private void checkMail() {
        Message m = nextMessage();
        if (m != null && m instanceof TopMessage){
            schedulingState = ((TopMessage)m).getValue();
            if(schedulingState==PAUSED || schedulingState==STOPPED){
                sendMessage(m.getSender(),new TopMessage(0));
            }
        }
    }
    
    final protected void executeTurtles() {
        turtleDoIt.execute();
    }
    
    final protected void executeDiffusion() {
        diffusion.execute();
    }
    
    final protected void executeEvaporation() {
        evaporation.execute();
    }
    
    final protected void executeObservers() {
        oberserversDoIt.execute();
    }
    
    final protected void executeDisplay() {
        viewersDoIt.execute();
        updateDisplay.execute();
    }
    
    final protected void incrementeIteration() {
        iteration++;
    }
    
    /** This method can be overriden to define a special kind of schedule
     * Default schedule is :
     * <p>
     * <code>public void scheduleWorld()
     * {
     * executeTurtles();
     * executeDiffusion();
     * executeEvaporation();
     * executeObservers();
     * executeDisplay();
     * }</code>
     */
    public void scheduleWorld() {
        executeTurtles();
        executeDiffusion();
        executeEvaporation();
        executeObservers();
        executeDisplay();
    }
    
}