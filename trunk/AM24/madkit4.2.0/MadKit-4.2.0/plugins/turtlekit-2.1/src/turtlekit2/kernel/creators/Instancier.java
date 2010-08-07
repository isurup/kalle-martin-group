package turtlekit2.kernel.creators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import madkit.boot.Madkit;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import turtlekit2.kernel.agents.Turtle;
import turtlekit2.kernel.environment.PatchVariable;
import turtlekit2.kernel.observers.Observer;
import turtlekit2.kernel.observers.TurtleEnvironment;
import turtlekit2.kernel.observers.Viewer;
import turtlekit2.kernel.tools.XMLAttributes;

public class Instancier {
	private static final long serialVersionUID = 1L;
	final public static String COMMUNITY="Turtlekit";


	@SuppressWarnings("unchecked")
	public static Collection<Viewer> getViewers(Element e){
		ArrayList<Element> obsDesc = getSons(e, "Viewer");
		ArrayList<Viewer> observers = new ArrayList<Viewer>();
		for (Iterator<Element> iterator = obsDesc.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			NamedNodeMap attributeList = element.getAttributes();
			int listLength = attributeList.getLength();
			XMLAttributes observerTable = new XMLAttributes();
			for(int k = 0 ; k < listLength ; k++) {
				observerTable.put(
						attributeList.item(k).getNodeName(),
						element.getAttribute(attributeList.item(k).getNodeName()));
			}
			try{
				String observerType = observerTable.getString("ViewerClass");
				Class observerClass = Madkit.getClassLoader().loadClass(observerType);
				Viewer newObserver = (Viewer)(observerClass.newInstance());
				newObserver.setAttrib(observerTable);
				observers.add(newObserver);
			}catch(Exception ex){
				System.err.println("Viewer Initialisation problem: "+ observerTable + "\n" + ex);
				ex.printStackTrace();
			}
		}
		return observers;
	}




	@SuppressWarnings("unchecked")
	public static Collection<Observer> getObservers(Element e){
		ArrayList<Element> obsDesc = getSons(e, "Observer");
		ArrayList<Observer> observers = new ArrayList<Observer>();
		for (Iterator<Element> iterator = obsDesc.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			NamedNodeMap attributeList = element.getAttributes();
			int listLength = attributeList.getLength();
			XMLAttributes observerTable = new XMLAttributes();
			for(int k = 0 ; k < listLength ; k++) {
				observerTable.put(
						attributeList.item(k).getNodeName(),
						element.getAttribute(attributeList.item(k).getNodeName()));
			}
			try{
				String observerType = observerTable.getString("ObserverClass");
				Class observerClass = Madkit.getClassLoader().loadClass(observerType);
				Observer newObserver = (Observer)(observerClass.newInstance());
				newObserver.setAttrib(observerTable);
				observers.add(newObserver);
			}catch(Exception ex){
				System.err.println("Observer Initialisation problem: "+ observerTable + "\n" + ex);
				ex.printStackTrace();
			}
		}
		return observers;
	}

	@SuppressWarnings("unchecked")
	public static Collection<Turtle> getTurtles(Element e){
		ArrayList<Element> agentsDesc = getSons(e, "Agent");
		ArrayList<Turtle> agents = new ArrayList<Turtle>();
		for (Iterator<Element> iterator = agentsDesc.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			String type = getFromNode(element, "AgentClass", "turtlekit2.tools.RandomMovingTurtle");
			int nbAgents = getIntFromNode(element, "NbAgents", 1);
			Element parameters = (getSons(element, "Parameters").size() > 0) 
				? getSons(element, "Parameters").get(0)
					: null;

			XMLAttributes agentAttribute = new XMLAttributes();
			if(parameters != null){
				NamedNodeMap attributes = parameters.getAttributes();
				for (int j = 0; j < attributes.getLength(); j++) {
					agentAttribute.put(
							attributes.item(j).getNodeName(),
							parameters.getAttribute(attributes.item(j).getNodeName()));
				}

			}
			agentAttribute.put("Node" , new Integer(agentsDesc.size()).toString());
			agentAttribute.put("GroupNode", new Integer(agentsDesc.size()).toString());
			agentAttribute.put("AgentClass",type);
			try{
				Class<? extends Turtle> agentClass = (Class<? extends Turtle>) Madkit.getClassLoader().loadClass(type);
				for(int k = 0; k < nbAgents; k++) {
					Turtle newAgent = (Turtle)(agentClass.newInstance());
					newAgent.setAttributes(agentAttribute);
					agents.add(newAgent);
				}
			}catch(Exception ex){
				System.err.println("Agent Initialisation problem: "+ agentAttribute + "\n" + ex);
				ex.printStackTrace();
			}
		}
		return agents;
	}

	
	public static ArrayList<PatchVariable> getFlavors(Element e){
		ArrayList<PatchVariable> flavors = new ArrayList<PatchVariable>();
		ArrayList<Element> classicFlavors = getSons(e, "Flavor");
		int index = 0;
		for (Iterator<Element> iterator = classicFlavors.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			PatchVariable patch = new PatchVariable(getFromNode(element, "Name", "Flavor" + index++));
			patch.setDefaultValue(getDoubleFromNode(element, "Quantity", 1000));
			patch.setDiffuseCoef(getDoubleFromNode(element, "Diffusion", 0.5));
			patch.setEvapCoef(getDoubleFromNode(element, "Evaporation", 0.1));
			//			if(patchDescription.hasAttribute("Volatile")) volatileVariables.add(newPatch);
			flavors.add(patch);
		}

		ArrayList<Element> randomFlavors = getSons(e, "RandomFlavors");

		for (Iterator<Element> iterator = randomFlavors.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			String name = getFromNode(element, "Name", "RandomFlavor");
			int nbFlavors = getIntFromNode(element, "Number", 1);
			for (int i = 0; i < nbFlavors ; i++) {
				PatchVariable patch = new PatchVariable(name + i);
				patch.setDefaultValue(getDoubleFromNode(element, "Quantity", Math.random() * 10000));
				patch.setDiffuseCoef(getDoubleFromNode(element, "Diffusion",Math.random()));
				patch.setEvapCoef(getDoubleFromNode(element, "Evaporation", Math.random()));
				//				if(patchDescription.hasAttribute("Volatile")) volatileVariables.add(newPatch);
				flavors.add(patch);
			}
		}
		return flavors;
	}




	//SPECIAL CAR ROOT NODE (A CHANGER)
	public static TurtleEnvironment getEnvironment(Element s) {
		TurtleEnvironment env = new TurtleEnvironment(
				getIntFromNode(s, "Width", 100), 
				getIntFromNode(s, "Height", 100),
				getFromNode(s, "Name", "Tk2 Simulation"));
		env.wrap = getBooleanFromNode(s, "TorusMode", true);
		return env;
	}



	/******************** DOM PARSERS *************/



	public static ArrayList<Element> getSons(Element e, String name){
		ArrayList<Element> result = new ArrayList<Element>();
		NodeList choosen =  e.getElementsByTagName(name);
		for(int i = 0 ; i < choosen.getLength() ; i++){
			result.add((Element)choosen.item(i));
		}
		return result;
	}


	public static int getIntFromNode(Element e, String key, int defaultValue){
		return (e.hasAttribute(key)) 
		? Integer.parseInt(e.getAttribute(key))
				: defaultValue ;
	}

	public static String getFromNode(Element e, String key, String defaultValue){
		return (e.hasAttribute(key)) 
		? e.getAttribute(key)
				: defaultValue ;
	}

	public static double getDoubleFromNode(Element e, String key, double defaultValue){
		return (e.hasAttribute(key)) 
		? Double.parseDouble(e.getAttribute(key))
				: defaultValue ;
	}

	public static boolean getBooleanFromNode(Element e, String key, boolean defaultValue){
		return (e.hasAttribute(key)) 
		? Boolean.parseBoolean(e.getAttribute(key))
				: defaultValue ;
	}

}
