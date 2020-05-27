/*
* Player.java
* Author: JiaoAng Dong
* Submission Date: 11/08/19
*
* Purpose: The Player class consists methods that
* the player in the adventure class will use. Methods 
* such as getX and getY used to navigate the player 
* in the game. set/get key or lamp also used by the 
* player in the interactive game.
* 
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
public class Player {
	
	// creating instance variables and setting the initial position to be (0,0)
	private int x = 0;
	private int y = 0;
	private Key Key;
	private Lamp Lamp;
	
	// void set method to relocate the x position
	public void setX(int x ) {
		this.x = x;
	}
	
	// getter method that returns the x position
	public int getX() {
		return x;
	}
	// void set method to relocate the y position
	public void setY(int y){
		this.y = y;
	}
	// getter method that returns the y position
	public int getY() {
		return y;
	}
	// getter method that returns the the object Key
	public Key getKey() {
		return Key;
	}
	// void set method to set the object key back to the instance variable
	public void setKey(Key Key) {
		this.Key = Key;
	}
	// getter method that returns the the object Lamp
	public Lamp getLamp(){
		return Lamp;
	}
	// void set method to set the object lamp back to the instance variable
	public void setLamp(Lamp Lamp) {
		this.Lamp = Lamp;
	}
}
