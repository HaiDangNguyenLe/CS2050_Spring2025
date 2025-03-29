/*
 Name: HAIDANG LE
 Class: CS2050 CS 2 With Java
 Metropolitan State University of Denver
 Spring 2025 
 Instructor: Deb Harding (she/her/hers)    Email: dhardi11@msudenver.edu  Office: EAS 200BB
 
 Description: Guide Exploration 01 - 2D array: explore a 2-dimensional array of objects
	● Declare a 2D array of objects 
	● Fill the array with car objects 
	● Print array
 */
import java.util.Scanner;

public class HaiDangLeGE012DArray {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Declare a 2D array of objects 
		final int ROW = 2;
		final int COL = 3;
		Car cars[][] = new Car [ROW][COL];
		//Fill the array with car objects 
		cars[0][0]= new Car("Ford");
		cars[0][1]= new Car("Dodge");
		cars[0][2]= new Car("Toyota");
		cars[1][0]= new Car("Huynhdai");
		cars[1][1]= new Car("Chevrolet");
		cars[1][2]= new Car("Subaru");
		
		/*for (int row = 0; row < cars.length; row++) {
			for(int col = 0; col < cars[row].length; col++) {
				//enter model for car object
				System.out.print("Enter car model of row " + (row + 1) 
									+ " colume " + (col +1) +" : ");
				String model = keyboard.nextLine();
				//construct car object with specific model
				Car aCar = new Car(model);
				//add car object to array cars
				cars[row][col] = aCar;
			
			}
		}*/
				
		//print array
		for (int row = 0; row < cars.length; row++) {
			for(int col = 0; col < cars[row].length; col++) {
				cars[row][col].printMake();
			}
			System.out.println();
		}
		
		keyboard.close();
	}//end main
		
}//end HaiDangLeGE012DArray
class Car{
	private String make;

	public Car() { 
   this.make = "Unknown"; 
}
	
public Car(String make) {
 	   this.make = make;
}

public void printMake() {
   System.out.print(this.make + " ");
}
} // end Car

