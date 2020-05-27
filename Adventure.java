/*
* Adventure.java
* Author: JiaoAng Dong
* Submission Date: 11/08/19
*
* Purpose: The adventure class is the main 
* method that the user plays for the game.
* The user inputs keyword/phrase and the interactive
* game will return actions with the main objective
* to reach the chest and unlock it. Actions can navigate the 
* player as well as give them hints on where to navigate.
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
import java.util.Scanner;


public class Adventure {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// creating instance variables for adventure class
		// created a new Player, Map, Lamp, Key and Chest for the actual gameplay.
		Player gameplayer = new Player();
		Map gamemap = new Map();
		Lamp playerLamp;
		Key gameKey;
		Chest gameChest;
		
		// setting the initial position of the player to be (0,0)
		
		gameplayer.setX(0);
		gameplayer.setY(0);
		
		// created a boolean "continueOrNot" to decide when the while loop ends
		boolean continueOrNot = true;
		
		// creating a string variable the user's input, and set it to empty
		String input = "";

		// first statement to print out when the game starts
		
		System.out.println("Welcome to UGA Adventures: Episode 1\r\n" + 
				"The adventure of the Cave of Redundancy Adventure\r\n" + 
				"By: Bracken\n");

		// print out the description of the room
		// map class -> getRoom method -> getDescription method (in room class)
		
		System.out.println(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getDescription());

		// the while loop for each inputs
		
		while (continueOrNot) {

			// taking in the user input using scanner
			input = keyboard.nextLine();
			
			// GET LAMP METHOD, If the lamp is present in the current room, it transfers the lamp from 
			// the room to the player. Clearing the lamp from the room afterwards. "No lamp present" if not.
			
			if (input.equalsIgnoreCase("GET LAMP")) {
				
					if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getLamp() == null) {
						System.out.println("No lamp present");
					}
					else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getLamp() != null) {
						playerLamp = gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getLamp();
						System.out.println("OK");
						gameplayer.setLamp(playerLamp);
						gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).clearLamp();
					}

				}
			

			// LIGHT LAMP METHOD, If the player has the lamp, this sets it to lit. 
			// or “You don't have the lamp to light” if the player doesn't have the lamp.
			
			else if (input.equalsIgnoreCase("LIGHT LAMP")) {
				if (gameplayer.getLamp() == null) {
					System.out.println("You don't have the lamp to light");
				}
				if (gameplayer.getLamp() != null) {
					System.out.println("OK");
					gameplayer.getLamp().setIsLit(true);
				}
			}
			
			// NORTH METHOD, If the current room is dark, and the player doesn't have the lamp OR they have the lamp but the
			// lamp is not lit, the player is eaten by a grue and the game is over. 
			// Otherwise, move the user North one square
			// If the exit is not possible , print (“Can't go that way”). 
			// If the room is dark and the player does not have the lamp OR the lamp is not lit,
			// print "It is pitch black, you can't see anything. You
			// may be eaten by a grue!"
			
			else if (input.equalsIgnoreCase("NORTH")) {
				if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
						(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
						continueOrNot = false;
						System.out.println("You have stumbled into a passing grue, and have been eaten");
					
				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoNorth() == true) {
					gameplayer.setX(gameplayer.getX()-1);
					if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
							(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
						
					
					else {
						System.out.println(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getDescription());
					}
				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoNorth() == false) {
					System.out.println("Can't go that way");
				}


			} 
			
			// SOUTH METHOD, If the current room is dark, and the player doesn't have the lamp OR they have the lamp but the
			// lamp is not lit, the player is eaten by a grue and the game is over. 
			// Otherwise, move the user south one square
			// If the exit is not possible , print (“Can't go that way”). 
			// If the room is dark and the player does not have the lamp OR the lamp is not lit,
			// print "It is pitch black, you can't see anything. You
			// may be eaten by a grue!"
			
			else if (input.equalsIgnoreCase("SOUTH")) {
				if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
						(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
						continueOrNot = false;
						System.out.println("You have stumbled into a passing grue, and have been eaten");
					
				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoSouth() == true) {
					gameplayer.setX(gameplayer.getX()+1);
					if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
							(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						
						
					}
					else {
						System.out.println(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getDescription());
					}
				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoSouth() == false) {
					System.out.println("Can't go that way");
				}


			} 
			
			// EAST METHOD, If the current room is dark, and the player doesn't have the lamp OR they have the lamp but the
			// lamp is not lit, the player is eaten by a grue and the game is over. 
			// Otherwise, move the user east one square
			// If the exit is not possible , print (“Can't go that way”). 
			// If the room is dark and the player does not have the lamp OR the lamp is not lit,
			// print "It is pitch black, you can't see anything. You
			// may be eaten by a grue!"
			
			else if (input.equalsIgnoreCase("EAST")) {
				if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
						(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
						continueOrNot = false;
						System.out.println("You have stumbled into a passing grue, and have been eaten");
					
				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoEast() == true) {
					gameplayer.setY(gameplayer.getY()+1);
					if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
							(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						
					}
					else {
						System.out.println(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getDescription());
					}
				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoEast() == false) {
					System.out.println("Can't go that way");
				}

			} 
			
			// WEST METHOD, If the current room is dark, and the player doesn't have the lamp OR they have the lamp but the
			// lamp is not lit, the player is eaten by a grue and the game is over. 
			// Otherwise, move the user west one square
			// If the exit is not possible , print (“Can't go that way”). 
			// If the room is dark and the player does not have the lamp OR the lamp is not lit,
			// print "It is pitch black, you can't see anything. You
			// may be eaten by a grue!"
			
			else if (input.equalsIgnoreCase("WEST")) {
				if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
						(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
						continueOrNot = false;
						System.out.println("You have stumbled into a passing grue, and have been eaten");
					}
				
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoWest() == true) {
					gameplayer.setY(gameplayer.getY()-1);
					if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
							(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						
						
						}
					else {
						System.out.println(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getDescription());
					}
				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoWest() == false) {
					System.out.println("Can't go that way");
				}


			} 
			
			// LOOK METHOD, If the room is Dark and the player does not have the lamp or the lamp is
			// not lit, print "It is pitch black, you can't see anything. You may be eaten by a grue!"
			// Otherwise, this prints the description of the current room object, as well as any
			// objects that are in the room. then print which exits from the room are valid.
			
			else if (input.equalsIgnoreCase("LOOK")) {
				if(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).isDark() == true && 
					(gameplayer.getLamp() == null || gameplayer.getLamp().getIsLit() == false)) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");    			 
					
				}
				else {
					System.out.println(gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getDescription());
					if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getLamp() != null ) {
						System.out.println("There is an old oil lamp here that was made long ago");
					}
					else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getKey() != null) {
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					}
					else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getChest() != null) {
						System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it"); 
					}

				}
				System.out.print("Exits are: ");
				if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoNorth() == true) {
					System.out.println("north");
				}
				if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoSouth() == true) {
					System.out.println("south");
				}
				if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoEast() == true) {
					System.out.println("east");
				}
				if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).canGoWest() == true) {
					System.out.println("west");
				}

			}
			
			// GET KEY METHOD, If the key is present in the room, this transfers the key to the player
			// clear the key from the room afterwards.  “No key present” if no key.
			
			else if (input.equalsIgnoreCase("GET KEY")) {
				if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getKey() != null) {
					System.out.println("OK");
					gameKey = gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getKey();
					gameplayer.setKey(gameKey);
					gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).clearKey();
				}
				else {
					System.out.println("No key present");
				}
			}
			
			// OPEN CHEST METHOD, If the chest is present in the room and is unlocked, then 
			// print out the chest's contents and end the game. 
			// If the chest is locked, print "The chest is locked". If the chest is not present in the room, 
			// print “No chest present”.
			
			else if  (input.equalsIgnoreCase("OPEN CHEST")) {
				if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getChest() == null) {
					System.out.println("No chest present");
				}
				if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getChest() != null) {
					gameChest = gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getChest();
					if (gameChest.isLocked() == false) {
						System.out.println(gameChest.getContents());
						continueOrNot = false;

					}
					if (gameChest.isLocked() == true) {
						System.out.println("The chest is locked");
					}
				}
			}

			// UNLOCK CHEST METHOD, If the user has the key, unlock chest. 
			// If the user doesn't have the key, print “Need a key to do any unlocking!”. 
			// If the chest is not present, print “No chest to unlock”.
			
			else if (input.equalsIgnoreCase("UNLOCK CHEST")) {
				
				if (gameplayer.getKey() == null) {
					System.out.println("Need key to do any unlocking!");

				}
				else if (gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getChest() == null) {
					System.out.println("No chest to unlock");

				}
				else if (gameplayer.getKey() != null) {
					gameChest = gamemap.getRoom(gameplayer.getX(),gameplayer.getY()).getChest();
					gameKey = gameplayer.getKey();

					gameKey.use(gameChest);
					System.out.println("OK");

				}
			}

			// unreadable input METHOD, print "I'm sorry I don't know how to do that" if the user inputs a 
			// word that does not match with the keywords/key phrases 
			else {
				System.out.println("I'm sorry I don't know how to do that");
			}

		} //while
	}
}
