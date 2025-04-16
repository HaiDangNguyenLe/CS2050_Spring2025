/*
 Name: HAIDANG LE
 Class: CS2050 CS 2 With Java
 Metropolitan State University of Denver
 Spring 2025 
 Instructor: Deb Harding (she/her/hers)    Email: dhardi11@msudenver.edu  Office: EAS 200BB

 Description: Car Vending Machine Project Iteration 01
	●	Show a menu driven system to select an action then process
	●	Load car's information from file then add car to a car tower from vending machine 
	●	Display vending machine's information: floor, space, and car details at this location which has a car in
	●	Show an inventory report sorted by car price or by year 
	●	Retrieve cars from a location for clients to test drive
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SubmittedProject01CarVendingMachine {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int choiceOption = 0;

		//A vending machine with defined rows and columns entered by the dealer
		System.out.print("Enter the number of floors for the car vending machine: ");
		int floor = keyboard.nextInt();
		System.out.print("Enter the number of spaces for the car vending machine: ");
		int space = keyboard.nextInt();
		System.out.println();

		VendingMachine vendingMachine = new VendingMachine(floor,space);
		Car[][] carTower = new Car[floor][space];

		do {
			//Show a menu driven system to select an action
			vendingMachine.displayMenu();
			//Enter option then process
			System.out.print("Enter your choice: ");
			choiceOption = keyboard.nextInt();

			switch  (choiceOption) {
			case 1:
				System.out.print("Enter the file name: ");
				String fileName = keyboard.next();
				vendingMachine.loadCarDataFromFile(carTower,fileName);
				break;
			case 2:
				System.out.println("Inventory Location");
				vendingMachine.displayVendingMachine(carTower);
				break;	
			case 3:
				System.out.print("Enter floor to retrieve car: ");
				int retrieveFloor = keyboard.nextInt();
				System.out.print("Enter location to retrieve car: ");
				int retrieveSpace = keyboard.nextInt();
				vendingMachine.retrieveCars(retrieveFloor, retrieveSpace, carTower );
				break;
			case 4:
				vendingMachine.sortByPrice(carTower);
				break;
			case 5:
				vendingMachine.sortByYear(carTower);
				break;
			case 6:
				System.out.println("Exiting program. Goodbye!");
				break;
			default:
				System.out.println("Error! Please enter an option from 1 to 6");
			}//end switch
			System.out.println();
		}while (choiceOption != 6);


		keyboard.close();
	}//end main

}//end project

class Car {
	private String carBrand;
	private String carModel;
	private double carPrice;
	private int carYear;

	/**
	 * Car Constructor
	 * @param carBrand
	 * @param carModel
	 * @param carYear
	 * @param carPrice
	 */
	public Car(String carBrand,String carModel,int carYear, double carPrice) {
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carPrice = carPrice;
	}

	//Getter methods
	public String getBrand() {
		return carBrand;
	}
	public String getModel() {
		return carModel;
	}
	public double getPrice() {
		return carPrice;
	}
	public int getYear() {
		return carYear;
	}

}//end car class

class VendingMachine {
	private int floor;
	private int space;

	/**
	 * Vending Machine Constructor
	 * @param floor
	 * @param space
	 */
	public VendingMachine(int floor, int space) {
		this.floor = floor;
		this.space = space;
	}

	/**
	 * add a car to carTower at given floor and space   
	 * @param carTower
	 * @param floor
	 * @param space
	 * @param carToAdd
	 */
	public static void addCar(Car[][] carTower, int floor, int space, Car carToAdd) {
		if((floor < 0 || floor >= carTower.length) || (space < 0 || space >= carTower[0].length)) {
			System.out.println("Error: Invalid position at Floor: " + (floor + 1) + " Space: " + (space + 1));
			System.out.println("Can not place Car " 
					+ carToAdd.getBrand() + " "
					+ carToAdd.getModel() + " "
					+ carToAdd.getYear() + " - $"
					+ carToAdd.getPrice());
		}
		else if(carTower[floor][space]!= null) {
			System.out.println("Error: Slot at Floor: " + (floor + 1) + " Space: " + (space + 1)+ " is already occupied.");
			System.out.println("Car " + carToAdd.getBrand() + " "
					+ carToAdd.getModel() + " "
					+ carToAdd.getYear() + " - $"
					+ carToAdd.getPrice() + " cannot be placed.");
		}

		else {
			carTower[floor][space] = carToAdd;
		}
	}//end addCar

	/**
	 * Loading car data from a file to car tower
	 * @param carTower
	 * @param filename
	 */
	public void loadCarDataFromFile(Car[][] carTower, String filename ) {
		try {
			Scanner fileScanner = new Scanner(new File(filename));
			while(fileScanner.hasNext()) {
				int floor = fileScanner.nextInt();
				int space = fileScanner.nextInt();
				int year = fileScanner.nextInt();
				double price = fileScanner.nextDouble();
				String brand = fileScanner.next();
				String model = fileScanner.next();
				Car aCar = new Car(brand, model, year,price);
				addCar(carTower, floor, space, aCar);
			}
			fileScanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("File " + filename + " was not found");
		}

	}//end loadCarDataFromFile

	/**
	 * display VendingMachine include floor, space and car details
	 * @param carTower
	 */
	public void displayVendingMachine (Car[][] carTower) {
		for ( int row = 0 ; row < carTower.length; row ++) {
			System.out.println("Floor " + (row+1) + ":");
			for ( int col = 0 ; col < carTower[row].length; col ++) {
				if	(carTower[row][col] == null) {
					System.out.println("	Space " + (col+1) + " EMPTY");
				}
				else {
					System.out.println("	Space " + (col+1) + ": " 
							+ carTower[row][col].getBrand() + " "
							+ carTower[row][col].getModel() + " "
							+ carTower[row][col].getYear() + " - $"
							+ carTower[row][col].getPrice());
				}
			}//end inner for
		}//end outer for
	}//end displayVendingMachine

	/**
	 * Retrieve a car on a certain floor and at a certain space
	 * @param floor
	 * @param space
	 * @param carTower
	 */
	public void retrieveCars(int floor, int space, Car[][] carTower) {
		if	(carTower[(floor-1)][(space-1)] == null) {
			System.out.println("No car located at Floor " + floor + " Location " + space );
		}
		else {	
			System.out.println("Car retrieved from Floor " + floor + " Location " + space + ": "
					+ carTower[(floor-1)][(space-1)].getBrand() + " "
					+ carTower[(floor-1)][(space-1)].getModel() + " "
					+ carTower[(floor-1)][(space-1)].getYear() + " - $" 
					+ carTower[(floor-1)][(space-1)].getPrice());
		}

	}//end retrieveCars


	/**
	 * Display car details of 1 D Car array	 
	 * @param cars
	 */
	public void displaySorted1DArray(Car[] cars ) {
		for (int i = 0; i < cars.length; i++) {
			System.out.print( cars[i].getBrand() + " "
					+ cars[i].getModel() + " "	
					+ cars[i].getYear() + " - $"
					+ cars[i].getPrice());
			System.out.println();
		}
	}

	/**
	 * Display sorted by price list of a car vending machine
	 * @param carTower
	 */

	public void sortByPrice(Car[][] carTower) {
		//Extract all cars from the 2D array into a 1D list
		int numRow = carTower.length;
		int numCol = carTower[0].length;
		Car[] oneDCars = new Car[ numRow*numCol];
		int index = 0;
		for ( int row  = 0 ; row < carTower.length; row ++) {
			for ( int col = 0 ; col < carTower[row].length; col ++) {
				if(carTower[row][col] != null) {
					oneDCars[index] = carTower[row][col];
					index++;
				}
			}			
		}
		//Create a 1D array of non-null cars
		Car[] arrayToSort = new Car[index];
		int index1 = 0;
		for( int i = 0; i < oneDCars.length; i++) {
			if(oneDCars[i] != null) {
				arrayToSort[index1] = oneDCars[i];
				index1++;
			}
		}
		//Sort the 1D array using the insert sort
		for( int i = 1; i < arrayToSort.length; i++) {
			Car key = arrayToSort[i];
			int j = i;
			while (j > 0 && arrayToSort[j-1].getPrice() > key.getPrice()) {
				arrayToSort [j] = arrayToSort [j-1];
				j--;
			}
			arrayToSort[j] = key;
		}
		//Display sorted list
		System.out.println("Sorted Inventory by Price: ");  
		displaySorted1DArray(arrayToSort);
	}//end sortByPrice

	/**
	 * display sorted by year list of a car vending machine
	 * @param carTower
	 */
	public void sortByYear(Car[][] carTower) {
		//Extract all cars from the 2D array into a 1D list
		int numRow = carTower.length;
		int numCol = carTower[0].length;
		Car[] oneDCars = new Car[ numRow*numCol];
		int index = 0;
		for ( int row  = 0 ; row < carTower.length; row ++) {
			for ( int col = 0 ; col < carTower[row].length; col ++) {
				if(carTower[row][col] != null) {
					oneDCars[index] = carTower[row][col];
					index++; //size of 1D array of non-null cars
				}
			}			
		}
		//Create a 1D array of non-null cars
		Car[] arrayToSort = new Car[index];
		int index1 = 0;
		for( int i = 0; i < oneDCars.length; i++) {
			if(oneDCars[i] != null) {
				arrayToSort[index1] = oneDCars[i];
				index1++;
			}
		}
		//Sort the 1D array using the insert sort
		for( int i = 1; i < arrayToSort.length; i++) {
			Car key = arrayToSort[i];
			int j = i;
			while (j > 0 && arrayToSort[j-1].getYear() > key.getYear()) {
				arrayToSort [j] = arrayToSort [j-1];
				j--;
			}
			arrayToSort[j] = key;
		}
		//Display sorted list
		System.out.println("Sorted Inventory by Year: ");  
		displaySorted1DArray(arrayToSort);

	}//end sortByYear

	/**
	 * Show a menu driven system to select an action
	 */
	public void displayMenu() {
		System.out.println("=== Car Vending Machine Menu ===");
		System.out.println("1.Load Car Data");
		System.out.println("2.Display Vending Machine");
		System.out.println("3.Retrieve a Car");
		System.out.println("4.Print Sorted Inventory (Price)");
		System.out.println("5.Print Sorted Inventory (Year)");
		System.out.println("6.Exit");
		System.out.println();
	}//end displayMenu

}//end VM class
