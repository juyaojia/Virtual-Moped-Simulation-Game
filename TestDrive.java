/**
 * A program that allows a user to drive a virtual Moped around the virtual streets of Manhattan.
 * 
 * @author Yaojia Ju
 * @version 1.0
 *
 */

import java.util.Scanner;

public class TestDrive {
	// the main method used to test the Moped class
	public static void main(String[] args) {
		//display message to the user
		System.out.println("Thanks for jumping on the moped.  We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave, facing South.  May I say your teeth look very clean.");
		//create the user's Moped using the constructor
		Moped m1 = new Moped("m1");
		//create two drunk drivers' Mopeds using the constructor
		Moped crazyMoped1 = new Moped("crazyMoped1");
		Moped crazyMoped2 = new Moped("crazyMoped2");
		//let two drunk drivers' Mopeds to start to randomly move on the street
		crazyMoped1.randomStart();
		crazyMoped2.randomStart();
		Scanner scn = new Scanner(System.in);
		//ask the user for a command
		System.out.println("What would you like to do?  At any time, say \"help\" for assistance.");
		while (true) {
			String response = scn.nextLine();
			//let the user's Moped move based on the user's command
			m1.operationTable(response,m1);
			crazyMoped1.randomMove();
			crazyMoped2.randomMove();
			//check if the two drunk drivers Mopeds crushed into the user's Moped
			if (m1.crush(m1,crazyMoped1,crazyMoped2)) {
				m1.crush(m1, crazyMoped1, crazyMoped2);
				System.exit(0);
			}
		}	
	}
}
