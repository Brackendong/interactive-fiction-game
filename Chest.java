/*
* Chest.java
* Author: JiaoAng Dong
* Submission Date: 11/08/19
*
* Purpose: The chest method contains multiple methods
* that helps with the checking and opening the chest.
* It can check if the chest is locked or unlocked, and 
* unlock or lock the chest by using the object key from 
* the Key class
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
public class Chest {

	
	// creating instance variables of 
	// "rightkey" from the Key.java class (used to unlock chest later)
	//  boolean "lock" (whether the chest is locked or not)
	//  String contents (what is inside the chest)
	
	private Key rightkey;
	private boolean lock = true;
	private String contents;
	

	// void method "lock"
	// set the chest to be locked status
	
	public void lock(Key theKey) {
		
		this.rightkey = theKey;
		lock = true;
	}
	
	
	// void method "unlock"
	// set the chest to be unlocked status
	
	public void unLock(Key theKey) {
		if(this.rightkey.equals(theKey))
			lock = false;
	}
	
	// isLocked method that returns boolean 
	// of whether the chest is locked or unlocked
	
	public boolean isLocked() {
		if(lock == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// getContents method, returns a string
	// of what is inside the chest
	// getter method
	
	public String getContents() {
		return contents;
	}
	
	// void setContents method, sets the contents in the chest
	// set method
	
	public void setContents(String contents) {
		this.contents = contents;
		 
	}
	
	
	
}