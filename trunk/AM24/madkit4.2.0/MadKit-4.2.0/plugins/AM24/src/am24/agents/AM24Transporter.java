package am24.agents;

import java.awt.Color;

import turtlekit.kernel.Turtle;

public class AM24Transporter extends Turtle {
	
	int count=10;
	
	public AM24Transporter() {}
	
	public AM24Transporter(String s) {
		super(s);
	}
	
	public void setup() {
	  	randomHeading();
	  	setColor(Color.BLUE);
	  	playRole("Transporter");
	}

	 public String walk(){
			fd(1);
		   	if (count < 0) {
		      count = (int) (Math.random()*90);
		      return("change");
		    }
		   	else {
		  	  count--;
		 	  return ("walk");
		   	}
		}  
		
		 public String change(){
			  randomHeading();
			  /*if (getHeading() > South) setColor(Color.red);
			  else if (getHeading() > West) setColor(Color.blue);
			    else if (getHeading() > North) setColor(Color.green);
			      else setColor(Color.yellow);*/
			  return("walk");
	  }
}
