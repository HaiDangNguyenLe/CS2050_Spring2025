import java.util.Scanner;

public class HaiDangLeGE012DArray {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Declare a 2D array of objects 
		int ROW = 2;
		int COL = 3;
		Car cars[][] = new Car [ROW][COL];
		//Fill the array with car objects 
		for (int row = 0; row < cars.length; row++) {
			for(int col = 0; col < cars[row].length; col++) {
				//enter model for car object
				System.out.print("Enter car make of row " + (row + 1) + " colume " + (col +1) +" : ");
				String model = keyboard.nextLine();
				//construct car object with specific model
				Car aCar = new Car(model);
				//add car object to array cars
				cars[row][col] = aCar;
			
			}
		}
		//print array
		for (int row = 0; row < cars.length; row++) {
			for(int col = 0; col < cars[row].length; col++) {
				cars[row][col].printMake();
			}
			System.out.println();
		}
		
		keyboard.close();
	}//end main
		
}//end HaiDangLeGE022DArray
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
} // Car

