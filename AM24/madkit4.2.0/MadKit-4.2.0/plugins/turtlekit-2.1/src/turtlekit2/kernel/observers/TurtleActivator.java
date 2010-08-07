/*
* TurtleActivator.java -TurtleKit - A 'star logo' in MadKit
* Copyright (C) 2000-2007 Fabien Michel
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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import madkit.kernel.AbstractAgent;
import madkit.kernel.Activator;
import turtlekit2.kernel.agents.Turtle;
import turtlekit2.kernel.creators.Tk2Launcher;

/** The TurtleActivator invoke and set the turtles nextAction variable 

  @author Fabien MICHEL
  @version 4.0 24/02/2007 */

final class TurtleActivator extends Activator<Turtle>
{     
	Map<Class<Turtle>,Map<String,Method>> methodTable;

    public TurtleActivator(String group)
    {
	super(Tk2Launcher.COMMUNITY,group, "turtle");
	methodTable=new HashMap<Class<Turtle>,Map<String,Method>>();
    }

@SuppressWarnings("unchecked")
public void initialize()
{
	for(AbstractAgent t : getCurrentAgentsList())
	{
			methodTable.put((Class<Turtle>) t.getClass(),new HashMap<String,Method>());
	}
}    

@SuppressWarnings("unchecked")
public void update(AbstractAgent theAgent, boolean added)
{
	Class<Turtle> c = (Class<Turtle>) theAgent.getClass();
	if (added && ! methodTable.containsKey(c))
		methodTable.put(c,new HashMap<String,Method>());
}    

synchronized public void execute()
{
	for(Turtle t : getCurrentAgentsList())
	{
		String nextMethod=null; 
		try
		{	
		   nextMethod = (String) t.nextAction.invoke(t);
		   if (nextMethod != null)
		   {
			if (! methodTable.get(t.getClass()).containsKey(nextMethod))
			{
			try {
				methodTable.get(t.getClass()).put(nextMethod, t.getClass().getMethod(nextMethod));
			}
			catch (NoSuchMethodException e) {System.err.println("Can't find method: "+nextMethod);e.printStackTrace();}
			catch (SecurityException e) {System.err.println("problem with method: "+nextMethod);e.printStackTrace();}
			}
		    t.setNextAction(methodTable.get(t.getClass()).get(nextMethod) );
		    }
		   else
		   	t.setNextAction(null);
		}
		catch (Exception e) {System.err.println("Can't invoke:"+e+" "+(t.nextAction).toString()+"\n");e.printStackTrace();}
	}
}

final synchronized Turtle[] getTurtles()
{
	return getCurrentAgentsList().toArray(new Turtle[numberOfAgents()]);
}
	

}

