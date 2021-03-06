/*
* Lamp.java
* Author: JiaoAng Dong
* Submission Date: 11/08/19
*
* Purpose: The lamp class contains methods that 
* checks whether the light is on or not (getter method)
* and turns light of the lamp on or off (setter method)
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/
public class Lamp {

	// instance boolean variable. light on or not
	
	private boolean isLit;
	
	// Method that returns whether the light is on or not
	// getter method
	public boolean getIsLit() {
		return isLit;
	}
	
	// void method that set the boolean "isLit" to be on or off
	// setter method
	public void setIsLit(boolean isLit) {
		 this.isLit = isLit;
	}

	
}