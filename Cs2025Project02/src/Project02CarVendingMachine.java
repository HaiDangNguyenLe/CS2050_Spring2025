

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Project02CarVendingMachine {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int choiceOption = 0;
		//A vending machine with defined rows and columns entered by the dealer
		System.out.print("Enter the number of floors for the car tower: ");
		int floors = keyboard.nextInt();
		System.out.print("Enter the number of spaces for the car tower: ");
		int spaces = keyboard.nextInt();
		System.out.println();
		CarVendingMachine vendingMachine = new CarVendingMachine(floors, spaces);

		do {
			//Show a menu driven system to select an action
			vendingMachine.displayMenu();
			//Enter option then process
			System.out.print("Enter your choice: ");
			choiceOption = keyboard.nextInt();

			switch  (choiceOption) {
			case 1: //Load Car Data from File
				System.out.print("Enter the file name: ");
				String fileName = keyboard.next();
				vendingMachine.setCarVendingMachineFromFile(fileName);
				break;
			case 2: //Display Vending Machine
				System.out.println("Inventory Location");
				vendingMachine.displayVendingMachine();
				break;	
			case 3: //Retrieve a Car by Location (Floor & Space)
				System.out.print("Enter floor: ");
				int retrieveFloor = keyboard.nextInt();
				System.out.print("Enter space: ");
				int retrieveSpace = keyboard.nextInt();
				vendingMachine.retrieveCarByLocation(retrieveFloor,retrieveSpace);
				break;
			case 4://Print Sorted Inventory (Price)
				vendingMachine.sortByPriceOrYear("price");
				break;
			case 5://Print Sorted Inventory (Year)
				vendingMachine.sortByPriceOrYear("year");
				break;
			case 6://Search for Cars (Manufacturer & Type)
				System.out.print("Enter manufacturer: ");
				String brand = keyboard.next();
				System.out.print("Enter car type (Basic/Premium): ");
				String type = keyboard.next();
				vendingMachine.searchCarByManufactureAndType(brand, type);
				break;
			case 7: //Add Car to Wash Queue
				System.out.print("Enter floor: ");
				int carWashFloor = keyboard.nextInt();
				System.out.print("Enter space: ");
				int carWashSpace = keyboard.nextInt();
				vendingMachine.addCarToWashQueue(carWashFloor, carWashSpace);
				break;
			case 8: //Process Car Wash Queue
				vendingMachine.processCarWashQueue();
				break;
			case 9: //Sell a Car
				System.out.print("Enter floor of the car to sell: ");
				int carSellFloor = keyboard.nextInt();
				System.out.print("Enter space of the car to sell: ");
				int carSellSpace = keyboard.nextInt();
				vendingMachine.sellACar(carSellFloor, carSellSpace);
				break;
			case 10:
				System.out.println("Exiting program. Goodbye!");
				break;
			default:
				System.out.println("Error! Please enter an option from 1 to 10");
			}//end switch
			System.out.println();
		}while (choiceOption != 10);


		keyboard.close();//close scanner keyboard 
	}//end main

}//end Project02CarVendingMachine
abstract class Car{
	private char carType;
	private int floor, space, carYear;
	private double carPrice;
	private String carBrand, carModel;

	/**Car constructor
	 * @param type
	 * @param floor
	 * @param space
	 * @param year
	 * @param price
	 * @param brand
	 * @param model
	 */
	public Car(int floor, int space, int year, double price, String brand, String model) {
		this.floor = floor;
		this.space = space;
		this.carYear = year;
		this.carPrice = price;
		this.carBrand = brand;
		this.carModel = model;

	}

	//Getter methods
	public char getType() {
		return carType;
	}

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

	public int getFloor() {
		return floor;
	}

	public int getSpace() {
		return space;
	}

	@Override
	public String toString() {
		return carBrand + " " + carModel + carYear + " - $" + carPrice + "( Floor: " + floor + ", Space: " + space + ")";
	}
}//end Car

//Subclass Basic Car
class BasicCar extends Car{

	/**BasicCar constructor
	 * @param floor
	 * @param space
	 * @param year
	 * @param price
	 * @param brand
	 * @param model
	 */
	public BasicCar(int floor, int space, int year, double price, String brand, String model) {
		super(floor, space, year, price, brand, model);
	}


	@Override
	public String toString() {
		return "Basic Car: " + getBrand() + " " + getModel() +" "+ getYear()+ " - $" + getPrice() + "( Floor: " + getFloor() + ", Space: " + getSpace() + ")";
	}
}//end BasicCar

//Subclass Premium Car
class PremiumCar extends Car{

	/**PremiumCar constructor
	 * @param floor
	 * @param space
	 * @param year
	 * @param price
	 * @param brand
	 * @param model
	 */
	public PremiumCar(int floor, int space, int year, double price, String brand, String model) {
		super(floor, space, year, price, brand, model);
	}

	@Override
	public String toString() {
		return "PremiumCar: " + getBrand() + " " + getModel() +" "+ getYear()+ " - $" + getPrice() + "( Floor: " + getFloor() + ", Space: " + getSpace() + ")";
	}
}//end PremiumCar

class CarVendingMachine{
	private  int maxFloor;
	private  int maxSpace;
	private LinkedList<Car> carsTower;
	private Queue<Car> carToWashQueue;

	/**CarVendingMachine constructor
	 * @param maxFloor
	 * @param maxSpace
	 */
	public CarVendingMachine(int maxFloor,int maxSpace) {
		this.maxFloor = maxFloor;
		this.maxSpace = maxSpace;
		carsTower = new LinkedList<>();
		carToWashQueue = new LinkedList<>();
	}//end CarVendingMachine constructor

	//--------------------------------------------------------------------------------------	
	//Show a menu driven system to select an action
	//-------------------------------------------------------------------------------------

	public void displayMenu() {
		System.out.println("=== Car Vending Machine Menu ===");
		System.out.println("1.Load Car Data From File");
		System.out.println("2.Display Vending Machine");
		System.out.println("3.Retrieve a Car by Location (Floor & Space)");
		System.out.println("4.Print Sorted Inventory (Price)");
		System.out.println("5.Print Sorted Inventory (Year)");
		System.out.println("6.Search for Cars (Manufacturer & Type)");
		System.out.println("7.Add Car to Wash Queue");
		System.out.println("8.Process Car Wash Queue");
		System.out.println("9.Sell a Car");
		System.out.println("10.Exit");
		System.out.println();
	}//end displayMenu	

	//--------------------------------------------------------------------------------------	
	//1. Load Car Data from File
	//-------------------------------------------------------------------------------------

	/**add car to valid position in carstower of car vending machine
	 * @param carToAdd
	 */
	public boolean checkIfAPositionHadCar(int floor, int space) {
		boolean occupiedPosition = false;
		for(Car aCar: carsTower) {
			if(aCar.getFloor() == floor && aCar.getSpace() == space) {
				occupiedPosition = true;
			}
		}
		return occupiedPosition;
	}

	public void addCar(Car carToAdd) {
		int carToAddFloor = carToAdd.getFloor();
		int carToAddSpace = carToAdd.getSpace();
		//check and inform if the position invalid
		if((carToAddFloor < 1 || carToAddFloor >= maxFloor) || ( carToAddSpace < 1 || carToAddSpace >= maxSpace)) {
			System.out.println("Error: Invalid position at Floor: " + carToAddSpace + " Space: " + carToAddSpace);
			System.out.println("Can not add " + carToAdd);
		}
		//check inform if the position (floor + space) has already had a car
		else if (checkIfAPositionHadCar(carToAddFloor,carToAddSpace)) {
			System.out.println("Error: Slot at Floor: " + carToAddSpace + " Space: " + carToAddSpace + " is already occupied.");
			System.out.println("Can not add " + carToAdd);
		}
		//Add car to carsTower
		else {
			carsTower.add(carToAdd) ;
		}

	}//end addCar

	/**Set up car tower by read data from file
	 * @param filename
	 */
	public void setCarVendingMachineFromFile(String filename ) {
		try {
			Scanner fileScanner = new Scanner(new File(filename));
			//read data form file
			while(fileScanner.hasNext()) {
				char type = fileScanner.next().charAt(0);
				int floor = fileScanner.nextInt();
				int space = fileScanner.nextInt();
				int year = fileScanner.nextInt();
				double price = fileScanner.nextDouble();
				String brand = fileScanner.next();
				String model = fileScanner.next();

				//Create car object for correct type Premium or Basic
				Car currentCar = null;
				if( type =='B' )
					currentCar = new BasicCar(floor,space,year,price, brand, model);
				else if( type =='P' )	
					currentCar = new PremiumCar(floor,space,year,price, brand, model);
				else
					System.out.println(" Unknown car's type: " + type );

				//call addCar to add current car into carsTower
				addCar(currentCar);
			}
			fileScanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("File " + filename + " was not found");
		}		

	}//end setCarTower

	//--------------------------------------------------------------------------------------
	//2. Display Vending Machine
	//--------------------------------------------------------------------------------------

	/**Display cars in vending machine
	 *
	 */
	public void displayVendingMachine () {
		for ( Car currentCar: carsTower) {
			System.out.println(currentCar.toString());
		}
	}//end displayVendingMachine

	//--------------------------------------------------------------------------------------
	//3. Use a HashMap Map<String, Car>  to retrieve a car by floor and space
	//--------------------------------------------------------------------------------------

	/**convert linkedlist to HashMap
	 * @return a HashMap<String, Car> 
	 */
	public HashMap<String, Car> convertLinkedListToHashMap(){
		HashMap<String, Car> hashMapOfCars = new HashMap<>();
		for(Car currentCar : carsTower ) { //iterate through each floor
			if(currentCar != null) { //take the present car
				String key = currentCar.getFloor() +"-" + currentCar.getSpace();
				hashMapOfCars.put(key,currentCar);//add the present car to HashMap
			}
		}
		return hashMapOfCars;
	}//end convertLinkedListToHashMap()

	/**retrieve a Car by floor and space
	 * @param floor
	 * @param space
	 */
	public void retrieveCarByLocation(int floor, int space) {
		String key = floor + "-" + space;
		//convert linkedlist carsTower into HashMap
		HashMap<String, Car> searchCarList = convertLinkedListToHashMap();
		//finding car by key (floor and space)
		if((floor < 1 || floor >= maxFloor) || ( space < 1 || space >= maxSpace)) {
			System.out.println("Error: Invalid position at Floor: " + space + " Space: " + space);
		}
		else if(searchCarList.containsKey(key)) { //return true if key exist
			Car retrievedCar = searchCarList.get(key); //return value at key
			System.out.println("Car retrieved: " + retrievedCar );
		}else {
			System.out.println("No car at Floor "+ floor +" Space "+ space);
		}
	}

	//--------------------------------------------------------------------------------------
	//4. Print Sorted Inventory by Price or Year (convert it into an ArrayList before sorting )
	//5. Print Sorted Inventory by Price or Year (convert it into an ArrayList before sorting )
	//--------------------------------------------------------------------------------------

	/**convert linkedlist carstower into an arraylist of cars
	 * @return an ArrayList<Car>
	 */
	public ArrayList<Car> convertLinkedListToArrayList(){
		ArrayList<Car> arrayListOfCars = new ArrayList<>();
		for ( Car currentCar: carsTower) { //iterate through each car
			if(currentCar != null) //take the present car
				arrayListOfCars.add(currentCar); //add the present car to arraylist
		}
		return arrayListOfCars;
	}

	/**search cars by brand and type
	 * @param sortChoice
	 */
	public void  sortByPriceOrYear(String sortChoice){
		//Convert linkedList carTower into an arraylist
		ArrayList<Car> sortCarList = convertLinkedListToArrayList() ;

		//Sorting using Comparator
		switch  (sortChoice.toLowerCase()) {
		case "year":
			sortCarList.sort(Comparator.comparingDouble(Car::getYear));
			break;
		case "price":
			sortCarList.sort(Comparator.comparingDouble(Car::getPrice));	
			break;
		default:
			System.out.println("Invalid sort choice. Please choose 'year' or 'price'.");
		}//end switch

		//display sorted cars
		System.out.println("Sorted Car by " + sortChoice + ":");
		for (Car currentCar : sortCarList ) {
			System.out.println(currentCar);
		}
	}//end sortByPriceOrYear

	//--------------------------------------------------------------------------------------
	//6. Searching by manufacture and car type should iterate through the linked list and not use a hashmap
	//--------------------------------------------------------------------------------------

	/**search cars by brand and type
	 * @param brand
	 * @param type
	 */
	public void searchCarByManufactureAndType(String brand, String type) {
		//Convert linkedList carTower into an arraylist
		ArrayList<Car> searchCarList = convertLinkedListToArrayList() ;	

		//find cars have brand and type matching to require
		System.out.println("List of cars made by  " + brand +  "  and " + type + " type: " );
		for (Car currentCar : searchCarList)  {
			if (currentCar != null && currentCar.getBrand().equalsIgnoreCase(brand)) {
				if ((type.equalsIgnoreCase("Basic") && currentCar instanceof BasicCar) ||
						(type.equalsIgnoreCase("Premium") && currentCar instanceof PremiumCar)) 
				{

					System.out.println(currentCar);
				}
			}
		}//end for loop
	}//end searchCarByManufactureAndType

	//--------------------------------------------------------------------------------------
	//Use Queue<Car> carWashQueue for car wash
	//7. Add Car to Wash Queue
	//8. Process Car Wash Queue
	//--------------------------------------------------------------------------------------
	/**add a car to wash queue list
	 * @param floor
	 * @param space
	 */
	public void addCarToWashQueue(int floor, int space) {
		//check and inform if floor and space invalid
		if((floor < 1 || floor >= maxFloor) || ( space < 1 || space >= maxSpace)) {
			System.out.println("Floor " + floor + " and Space " + space + " INVALID");
		}
		//check inform if the given position (floor + space) has NOT had a car
		else if (!checkIfAPositionHadCar(floor,space)) {
			System.out.println("No car in floor " + floor + " space " + space);
		}
		//add car to queue list
		else {
			for(Car aCar: carsTower) {
				if(aCar.getFloor() == floor && aCar.getSpace() == space) {
					carToWashQueue.add(aCar);
					System.out.println("Car retrieved: " + aCar  );
					System.out.println("Car added to wash queue");
				}
			}
		}

	}//end addCarToWashQueue

	/**process car wash queue list
	 * @param carToWashQueue
	 */
	public void processCarWashQueue() {
		if(carToWashQueue.isEmpty()) {
			System.out.println("No cars in the wash queue");
		}
		else {
			while(!carToWashQueue.isEmpty()) {
				Car washedCar = carToWashQueue.remove();
				System.out.println("Washing: "+ washedCar);
			}
		}
		
	}//end processCarWashQueue

	//--------------------------------------------------------------------------------------
	//9.Sell a Car
	//--------------------------------------------------------------------------------------
	/**sell a car, delete car from carstower
	 * @param floor
	 * @param space
	 */
	public void sellACar(int floor, int space) {
		//check and inform if floor and space invalid
		if((floor < 1 || floor >= maxFloor) || ( space < 1 || space >= maxSpace)) {
			System.out.println("Floor " + floor + " and Space " + space + " INVALID");
		}
		//check inform if the given position (floor + space) has NOT had a car
		else if (!checkIfAPositionHadCar(floor,space)) {
			System.out.println("No car in floor " + floor + " space " + space);
		}
		//remove car from carsTower
		else {
			for(Car aCarInTower: carsTower) {
				if(aCarInTower.getFloor() == floor && aCarInTower.getSpace() == space) {
					System.out.println("Car Sold: " + aCarInTower);
					carsTower.remove(aCarInTower);
				}
			}
		}
	}//end sellACar
		
}//end Vending Machine

