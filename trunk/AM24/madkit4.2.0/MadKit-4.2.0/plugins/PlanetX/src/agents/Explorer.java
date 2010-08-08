package agents;

import java.awt.Color;

import turtlekit.kernel.Turtle;
import madkit.kernel.Message;



public class Explorer extends Turtle {

	public Explorer() {
		super("searchForOre");
	}

	public void setup() {
		playRole("explorer");
		setColor(Color.RED);
		setHeading(West);
	}

	void wiggle() {
		fd(1);
		turnRight(Math.random() * 45);
		turnLeft(Math.random() * 45);
	}
	
	public String searchForOre() {
		wiggle();
	      if (getPatchColor() == Color.yellow)
		   {
	    	  //TODO: send info to Transporter
		       return("findNewOre");
		   }
	       else {
			return ("searchForOre");
	       }
	}
	
	 public String findNewOre()
	 {
		 if (getPatchColor() == Color.yellow)
			 return("sendCoordinatesToTransporter");
		 else
		 {
			 wiggle();
			 return("findNewOre");
		 }
	 }
	 
	 public String sendCoordinatesToTransporter() {
		 println("Wuhu Wee are sending or something");
		
		 return("searchForOre"); 
	 }

}