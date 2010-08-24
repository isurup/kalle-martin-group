package turtlekit2.kernel.creators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import madkit.kernel.AbstractAgent;
import madkit.kernel.Agent;

import org.w3c.dom.Element;

import turtlekit2.kernel.UI.LauncherGui;
import turtlekit2.kernel.agents.Turtle;
import turtlekit2.kernel.editors.PythonCommandCenter;
import turtlekit2.kernel.environment.PatchVariable;
import turtlekit2.kernel.observers.Observer;
import turtlekit2.kernel.observers.TurtleEnvironment;
import turtlekit2.kernel.observers.TurtleScheduler;
import turtlekit2.kernel.observers.Viewer;
import turtlekit2.kernel.tools.TopMessage;

public class SimulationLauncher extends Agent{
	private static final long serialVersionUID = 1L;
	
	public String simulationGroup;
	Element simuDescription;
	
	public TurtleEnvironment environment;
	public TurtleScheduler sch;
	Collection<Turtle> turtles;
	Collection<Observer> observers;
	Collection<Viewer> viewers;
	ArrayList<PatchVariable> flavors;


	
	public boolean start = false;
	public boolean run = false;
	public boolean geneticMode = false;

	public SimulationLauncher(Element simuDescription, String simulationName) {
		this.simuDescription = simuDescription;
		this.simulationGroup = simulationName;
	}

	private void launchFlavors( Collection<PatchVariable> flavors ){
		for (Iterator<PatchVariable> iterator = flavors.iterator(); iterator.hasNext();) {
			PatchVariable patchVariable = (PatchVariable) iterator.next();
			environment.addGridVariable(patchVariable);
		} 
	}


	private void launchTurtles(Collection<Turtle> turtles){
		for (Iterator<Turtle> iterator = turtles.iterator(); iterator.hasNext();) {
			Turtle turtle = (Turtle) iterator.next();
			if(turtle.getAttributes().containsKey("x") || turtle.getAttributes().containsKey("y"))
				environment.addAgent(turtle, turtle.getAttributes().getInt("x"), turtle.getAttributes().getInt("y"));
			else
				environment.addAgent(turtle);
		}
	}


	private void launchViewers(Collection<Viewer> viewers) {
		int i = 0;
		for (Iterator<Viewer> iterator = viewers.iterator(); iterator.hasNext();) {
			Viewer viewer = (Viewer) iterator.next();
			viewer.cellSize = viewer.getAttrib().getInt("CellSize");
			viewer.simulationGroup = simulationGroup;
			viewer.envWidth = environment.x;
			viewer.envHeight = environment.y;
			viewer.setFlavors(flavors);
//			viewer.patchGrid = environment.grid;
			launchAgent(viewer, "viewer" + i++, true);
			viewer.disposeMyGUI();
			
		}
	}


	private void launchObservers(Collection<Observer> observers) {
		int i = 0;
		for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.simulationGroup = simulationGroup;
			observer.envWidth = environment.x;
			observer.envHeight = environment.y;
//			observer.patchGrid = environment.grid;
			launchAgent(observer, "Observer" + i++, true);
			observer.disposeMyGUI();
		}
	}


    public void launchPython() throws Exception {
        AbstractAgent a = new PythonCommandCenter(simulationGroup);
        launchAgent(a, "Python command center", true);
        a.disposeMyGUI();
    }

	/////////////////////////////////////////// Activation and running methods
	/** MadKit usage */
	public void activate() {
		
		
		//Phase 1: MAS organization
//		createGroup(false, Tk2Launcher.COMMUNITY, simulationName, null, null);
		requestRole(Tk2Launcher.COMMUNITY, simulationGroup, "launcher", null);
		
		//Phase 3: Simulation initialization
		sch = new TurtleScheduler(simulationGroup);
		sch.group = simulationGroup;
		sch.delay =  Instancier.getIntFromNode(simuDescription, "CyclePause", 1);
		launchAgent(sch, simulationGroup + " scheduler", false);
		waitNextMessage();

		environment = Instancier.getEnvironment(simuDescription);
		launchAgent(environment, simulationGroup + " world", false);
		
		flavors = Instancier.getFlavors(simuDescription);
		this.launchFlavors(flavors);
		environment.initNeighborhood();

		//        if(geneticMode) initializeGenetic();

		turtles = Instancier.getTurtles(simuDescription);
		this.launchTurtles(turtles);
		
		viewers = Instancier.getViewers(simuDescription);
		this.launchViewers(viewers);
		
		observers = Instancier.getObservers(simuDescription);
		this.launchObservers(observers);
		

		//Phase 2 GUI init
		LauncherGui onScreen = new LauncherGui(this);
		onScreen.initialisation();
		
		try {
			launchPython();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		println("Simulation is initialized !!");
		println("Click to begin...");
		while (true) {
			pause(50);
			if (start) {
				break;
			}
			if (nextMessage() != null) {
				onScreen.startStop.doClick();
			}
		}

		//phase 3: launching simulation
		start = true;
		run = true;
		sendMessage(sch.getAddress(), new TopMessage(TurtleScheduler.RUNNING));
		
		
//		disposeMyGUI();
	}




	/** MadKit kernel usage */
	public final void live() {
		int i = -1;
		while (true) {
			pause(sch.delay);
			if (sch != null && start && i != sch.iteration) {
				i = sch.iteration;
				println("step " + i);
			}
		}

	}

	/** MadKit kernel usage. No redefinition. Closing the simulation. */
	public final void end() {
		println("Closing simulation");
		println("Please wait...");
		sendMessage(sch.getAddress(), new TopMessage(-1));
		killAgent(sch);
		if (environment != null)
			killAgent(environment);
		
		for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			killAgent(observer);
		}
		for (Iterator<Viewer> iterator = viewers.iterator(); iterator.hasNext();) {
			Viewer viewer = (Viewer) iterator.next();
			killAgent(viewer);
		}
//		leaveGroup(simulationGroup);
		System.gc();
		System.runFinalization();
	}



	/** reseting the simulation. Unstable in genetic Mode*/
	final public void setReset() {
		sendMessage(sch.getAddress(), new TopMessage(TurtleScheduler.STOPPED));
		start = false;
		println("Reseting: Please wait ...");
		run = false;
		environment.clearAllTurtles();
		environment.initGrid();
		
		flavors = Instancier.getFlavors(simuDescription);
		this.launchFlavors(flavors);
		environment.initNeighborhood();

		//        if(geneticMode) initializeGenetic();

		turtles = Instancier.getTurtles(simuDescription);
		this.launchTurtles(turtles);
		
		
		for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.reset();
		}
		for (Iterator<Viewer> iterator = viewers.iterator(); iterator.hasNext();) {
			Viewer viewer = (Viewer) iterator.next();
			viewer.reset();
		}


		start=true;
		run=true;
		sendMessage(sch.getAddress(), new TopMessage(TurtleScheduler.RUNNING));
	}



	/** setter for toroidal world usage */
	final public void setWrapModeOn(boolean b) {
		if(run)
			pauseSimulation();
		if (environment != null){
			environment.wrap = b;
			environment.initNeighborhood();
		}
		if(run)
			sendMessage(sch.getAddress(), new TopMessage(TurtleScheduler.RUNNING));
	}

	public void setStop() {
		if (run) {
			run = false;
			pauseSimulation();
			println("Simulation paused");
		} else {
			sendMessage(sch.getAddress(), new TopMessage(TurtleScheduler.RUNNING));
			println("Simulation running");
			run = true;
		}
	}

	final public void stepByStep() {
		sendMessage(sch.getAddress(), new TopMessage(TurtleScheduler.STEP));
		run=false;
	}
	
    
    public void pauseSimulation(){
    	sendMessage(sch.getAddress(), new TopMessage(TurtleScheduler.PAUSED));
        waitNextMessage();
    }
}
