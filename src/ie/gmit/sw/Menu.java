//Designed By Aaron Healy - G00333148
package ie.gmit.sw;

import java.util.Scanner;

public class Menu {

	//Show Method
	public void show() throws InterruptedException {	
		String fileNameA; //file 1
		String fileNameB; //file 2
		int shingles; //
		
		Scanner console = new Scanner(System.in);
		
		//Take in the names of the two files to be compared
		System.out.print("\nEnter File Name A: ");
		fileNameA = console.nextLine();
		
		System.out.print("\nEnter File Name B: ");
		fileNameB = console.nextLine();
		
		//Take in amount of shingles user wants to use.
		System.out.print("\nEnter Number of Shingles: ");
		shingles = console.nextInt();
		
		//Call Launcher
		new Launcher(fileNameA,fileNameB,100,shingles);
		console.close();
	}//Show
}//Menu