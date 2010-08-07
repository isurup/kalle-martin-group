package turtlekit2.kernel.UI;

import madkit.kernel.ObjectMessage;

public class GUIMessage <T>  extends ObjectMessage<T> {
	static final long serialVersionUID = 1l;
	int location;
	String name;
	
	public GUIMessage(final T theContent, int location, String name){
		super(theContent);
		this.location = location;
		this.name = name;
	}
	
	public int getLocation(){
		return location;
	}
	
	public String getName(){
		return name;
	}
	
}
