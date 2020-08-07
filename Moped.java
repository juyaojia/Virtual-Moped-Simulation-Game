/**
 * A program that allows a user to drive a virtual Moped around the virtual streets of Manhattan.
 * 
 * @author Yaojia Ju
 * @version 1.0
 *
 */

import java.lang.System;

//creat a new Moped class
public class Moped {
	//declare instance and static properties
	private int x = 5;
	private int y = 10;
	// 1: south, 2: west, 3: north, 4: east
	private int direction = 1;
	private double gas = 1;
	private static final double CONSUME = 0.05;
	private boolean backUp = false;
	private boolean straightOn = false;
	private boolean autoDrive = false;
	private boolean check = true;
	private String name;
	
	/**
	* no-args constructor. All Moped Porperties remain with their default value
	*/
	public Moped() {	
	}
	
	/**
	* Constructor that the name of a Moped
	* @param name the name given to the Moped
	*/
	public Moped(String name) {
		this.name = name;
	}
	
	/**
	* 
	* Getter method for the x coordinate property
	* @return the x coordinate of this Moped
	*/
	public int getX() {
		return x;
	}
	
	/**
	* 
	* Getter method for the y coordinate property
	* @return the y coordinate of this Moped
	*/
	public int getY() {
		return y;
	}


	/**
	* 
	* Getter method for the orientation property
	* @return the current direction of this Moped
	*/
	public int getDirection() {
		return direction;
	}
	
	/**
	* 
	* Setter method for the direction property
	* @param direction the new driection that the Moped faces represented by number from 0 to 4
	*/
	public void setDirection(int direction) {
		if (direction==1 || direction==2 || direction==3 || direction==4) {
			this.direction = direction;
		}
	}

	/**
	* 
	* Format the street or Avenue number of the location
	* @param coordinate take the x coordinate or y coordinate of the Moped location
	* @return the formated street or Avenue number
	*/
	public String locationFormat(int coordinate) {
		
		String formated;
		switch(coordinate) {
			case 1:
				formated = "1st";
				break;
			case 2:
				formated = "2nd";
				break;
			case 3:
				formated = "3rd";
			default:
				formated = coordinate + "th";
		}
		return formated;
	}
		
	/**
	* 
	* Format the direction of the Moped
	* @param directoin take the current direction of the Moped location that is represented in integer from 0 to 4
	* @return the formated direction of the Moped
	*/
	public String directionFormat(int direction) {
		String formated = null;
		
		switch(direction) {
			case 1:
				formated = "South";
				break;
			case 2:
				formated = "West";
				break;
			case 3:
				formated = "North";
				break;
			case 4:
				formated = "East";
				break;
		}
		
		return formated;
	}
	

	/**
	* 
	* Print out the formated location and direction information
	* @return a string that contain the formated location and direction of this Moped
	*/
	public String getLocation() {
		String xFormated = locationFormat(this.getX());
		String yFormated = locationFormat(this.getY());
		String directionFormated = directionFormat(this.getDirection());
		
		String ads = advertising(); 
		String print = "Now " + this.name + " at " + yFormated + " St. and " + xFormated + " Ave, facing " + directionFormated + ".    " + ads;
		
		return print;	
	}

	
	/**
	* 
	* Getter method for the gas property
	* @return the gas property of this Moped
	*/
	public double getGas() {
		return gas;
	}
	

	/**
	* Setter method for the gas property, keep track of the gas consumed, the gas remains, and print out messages when running out of gas
	*/
	public void setGas() {
		if (getGas()-CONSUME>=0) gas = getGas()-CONSUME;
		else {
			if (!autoDrive) {
				System.out.println("The Moped has run out of gas and no longer drives! Bye!");
				System.exit(0);
			}
		}
	}
	
	/**
	* Format the gas properties of this Moped, formated and report it to the user
	*/
	public void gasFormated() {
		int remain = (int)(getGas()*100+0.5);
		String gasFormat = remain + "%";
		String answer = "The gas tank is currently " + gasFormat + " full.";
		System.out.println(answer);
	}
	
	/**
	* 
	* Setter method for the x Coordinate property
	* @param x moving forward or backward x unit
	* @return return whether the x coordinate has been set, serving as a way to help verify if the Moped has gone off the grid
	*/
	public boolean setX(int x) {
		boolean sign = false;
		if ((this.getX() + x) >= 1 && (this.getX() + x) <= 10) {
			this.x += x;
			sign = true;
		}
		return sign;
	}
	
	/**
	* 
	* Setter method for the y Coordinate property
	* @param y moving forward or backward y unit
	* @return return whether the y coordinate has been set, serving as a way to help verify if the Moped has gone off the grid
	*/
	public boolean setY(int y) {
		boolean sign = false;
		if ((this.getY() + y) >= 1 && (this.getY() + y) <= 200) {
			this.y += y;
			sign = true;
		}
		return sign;
	}
	
	
	/**
	* Fill up the gas tank
	*/
	public void fillUpGas() {
		this.gas = 1.0;
	}
	

	/**
	* Park the Moped on the sidewalk, display the message, and exit the program
	*/
	public void park() {
		System.out.println("The Moped has been parked on the sidewalk. Bye!");
		System.exit(0);
	}
	
	/**
	* Back up method that allow this Moped to go back up a unit
	* @return whether the move is able to be made, serving as a way to help with checking whether the Moped has gone off the grid
	*/
	public boolean backUp() {
		setGas();
		backUp = true;
		straightOn = false;
		switch(this.getDirection()) {
			case 1:
				check = this.setY(1);
				break;
			case 2:
				check = this.setX(-1);
				break;
			case 3:
				check = this.setY(-1);
				break;
			case 4:
				check = this.setX(1);
				break;	
		}
		System.out.println(getLocation());
		return check;
		
	}
	

	/**
	* Straight on method that allow this Moped to go forward a unit
	* @return whether the move is able to be made, serving as a way to help with checking whether the Moped has gone off the grid
	*/
	public boolean straightOn() {
		setGas();
		backUp = false;
		straightOn = true;
		switch(this.getDirection()) {
			case 1:
				check = this.setY(-1);
				break;
			case 2:
				check = this.setX(1);
				break;
			case 3:
				check = this.setY(1);
				break;
			case 4:
				check = this.setX(-1);
				break;
		}
		System.out.println(getLocation());
		return check;
		
	}
	

	/**
	* Go left method that allow this Moped to turn left and move one unit
	*/
	public void goLeft() {
		if (backUp) {
			this.setDirection((this.getDirection()+1)%4);
			backUp();
		}
		else {
			int newDirection = ((this.getDirection()-1)==0) ? 4 : -(this.getDirection()-1);
			this.setDirection(newDirection);
			straightOn();
		}
	}
	

   /**
	* Go right method that allow this Moped to turn right and move one unit
	*/
	public void goRight() {
		if (backUp) {
			int newDirection = ((this.getDirection()-1)==0) ? 4 : -(this.getDirection()-1);
			this.setDirection(newDirection);
			backUp();
		}
		else {
			this.setDirection((this.getDirection()+1)%4);
			straightOn();
		}
	}


	/**
	* homing method that allow this Moped to automatically drive to Bluestone Lane
	*/
	public void homing() {
		autoDrive = true;
		int destinationX = 4;
		int destinationY = 8;
		int moveX = (getX()- destinationX >=0) ? (getX() - destinationX) : (destinationX - getX());
		int moveY = (getY()- destinationY >=0) ? (getY() - destinationY) : (destinationY - getX());
		switch (getDirection()) {
			case 1:
				if (getY()- destinationY >=0) {
					for (int i=0; i<moveY; i++) straightOn();
					if (getX()- destinationX >=0) goLeft();
					else goRight();
					for (int i=0; i<moveX-1; i++) straightOn();
					}
				else {
					for (int i=0; i<moveY; i++) backUp();
					if (getX()- destinationX >=0) goRight();
					else goLeft();
					for (int i=0; i<moveX+1; i++) straightOn();	
				}
				break;
				
			case 2:
				if (getY()- destinationY >=0) {
					if (getX()- destinationX < 0) {
						for (int i=0; i<moveX; i++) straightOn();
						goLeft();
						for (int i=0; i<moveY-1; i++) straightOn();
					}
					else {
						for (int i=0; i<moveX; i++) backUp();
						goRight();
						for (int i=0; i<moveY+1; i++) straightOn();
					}
				}
				else {
					if (getX()- destinationX < 0) {
						for (int i=0; i<moveX; i++) straightOn();
						goRight();
						for (int i=0; i<moveY-1; i++) straightOn();
					}
					else {
						for (int i=0; i<moveX; i++) backUp();
						goLeft();
						for (int i=0; i<moveY+1; i++) straightOn();
					}
				}
				break;
				
			case 3:
				if (getY()- destinationY >=0) {
					for (int i=0; i<moveY; i++) backUp();
					if (getX()- destinationX >=0) goLeft();
					else goRight();
					for (int i=0; i<moveX+1; i++) straightOn();
				}
				else {
					for (int i=0; i<moveY; i++) straightOn();
					if (getX()- destinationX >=0) goRight();
					else goLeft();
					for (int i=0; i<moveX-1; i++) straightOn();
				}
				break;
				
			case 4:
				if (getY()- destinationY >=0) {
					if (getX()- destinationX < 0) {
						for (int i=0; i<moveX; i++) backUp();
						goLeft();
						for (int i=0; i<moveY+1; i++) straightOn();
					}
					else {
						for (int i=0; i<moveX; i++) straightOn();
						goRight();
						for (int i=0; i<moveY-1; i++) straightOn();
					}
				}
				else {
					if (getX()- destinationX < 0) {
						for (int i=0; i<moveX; i++) backUp();
						goRight();
						for (int i=0; i<moveY+1; i++) straightOn();
					}
					else {
						for (int i=0; i<moveX; i++) straightOn();
						goLeft();
						for (int i=0; i<moveY-1; i++) straightOn();
					}		
				}
				break;
		}
		fillUpGas();
		System.out.println("We have reached the Bluestone Lane.  Enjoy your cappuccino.");
	}

	/**
	* advertising method that allow this Moped to display advertisement at certain loactions
	* @return the ads according to the location that the Moped is at
	*/
	public String advertising() {
		int xCoordinate = getX();
		int yCoordinate = getY();
		
		if (xCoordinate==8 && yCoordinate==79) return "The American Museum of Natural History is one of the world's preeminient scientific and cultural institutions.";
		else if (xCoordinate==1 && yCoordinate==74) return "Memorial Sloan Kettering Cancer Center — the world’s oldest and largest private cancer center.";
		else if (xCoordinate==4 && yCoordinate==12) return "Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?";
		else if (xCoordinate==6 && yCoordinate==3) return "Nowadays, Fay Da Bakery still remains a small family-owned business, with several stores throughout Manhattan and Queens.";
		else return "";
	}
	
	/**
	* Display all the commands that the program can accept
	*/
	public void help() {
		System.out.println("The program accepts the following commands:");
		System.out.println("\"go left\"");
		System.out.println("\"go right\"");
		System.out.println("\"straight on\"");
		System.out.println("\"back up\"");
		System.out.println("\"how we doin'?\"");
		System.out.println("\"fill 'er up\"");
		System.out.println("\"park\"");
		System.out.println("\"go to Bluestone Lane\"");
		System.out.println("\"help\"");	
	}

	/**
	* check if a move is validate or not and display the message to the user
	*/	
	public void moveValidation() {
		if (!check) System.out.println("You can't drive your Moped off the grid! Please try again. ");
	}
	
	/**
	* set the initial random cooridnates of the drunk driver Mopeds
	*/
	public void randomStart() {
		int x = (int)(Math.random()*10+1);
		int y = (int)(Math.random()*200+1);
		this.x = x;
		this.y = y;
	}

	/**
	* let the drunk driver Mopeds move randomly
	*/
	public void randomMove() {
		autoDrive=true;
		int dice = (int)(Math.random()*4+1);
		switch(dice) {
			case 1:
				goLeft();
				break;
			case 2:
				goRight();
				break;
			case 3:
				straightOn();
				break;
			case 4:
				backUp();
				break;
		}
		
	}
	
	/**
	* Check if the drunk driver Mopeds crush the user's Moped and display the message
	* @param m1 passing the user's Moped as an object to the function
	* @param m2 passing the first drunk driver's Moped as an object to the function
	* @param m3 passing the second drunk driver's Moped as an object to the function
	* @return whether the drunk driver Mopeds crush the user's Moped
	*/
	public boolean crush(Moped m1, Moped m2, Moped m3) {
		boolean crush = false;
		if ((m1.getX()==m2.getX()) && (m1.getY()==m2.getY()) || ((m1.getX()==m3.getX()) && (m1.getY()==m3.getY()))) {
			crush = true;
			System.out.println("Oops! A drunk driver Moped crushed into your Moped! Sorry! Bye!");
		}
		return crush;
	}
	
	/**
	* operate the move of the user's Moped based on the command user input and display a message to prompt the user to enter again if its't an invalid command
	* @param response the command user input
	* @param m1 passing the user's Moped as an object to the function
	*/
	public void operationTable(String response, Moped m1) {
		switch (response) {
		case "go left":
			m1.goLeft();
			m1.moveValidation();
			break;
		case "go right":
			m1.goRight();
			m1.moveValidation();
			break;
		case "straight on":
			m1.straightOn();
			m1.moveValidation();
			break;
		case "back up":
			m1.backUp();
			m1.moveValidation();
			break;
		case "how we doin'?":
			m1.gasFormated();
			m1.moveValidation();
			break;
		case "fill 'er up":
			m1.fillUpGas();
			break;
		case "park":
			m1.park();
			break;
		case "go to Bluestone Lane":
			m1.homing();
			break;
		case "help":
			m1.help();
			break;
		default:
			System.out.println("Invalid command! Please try again. (enter \"help\" to check the commands you can use)");
		}
	
	}
	
}