/*
 Name: HAIDANG LE
 Class: CS2050 CS 2 With Java
 Metropolitan State University of Denver
 Spring 2025 
 Instructor: Deb Harding (she/her/hers)    Email: dhardi11@msudenver.edu  Office: EAS 200BB
 
 Description: Guide Exploration 01 - Polymorphism
	●	Create Animal super class (data field name, food, weight,sleep, location), constructor, getter methods, and addition methods (eat, sleep, swim)
	●	Create Bear, Elephant, Monkey, Sloth Sub classes extend from Animal class. Overriding eat, sleep, swim and toString methods
	●	Read data from file to Create polymophic array of animal objects (type: Bear, Elephant, Monkey, Sloth)
	●	Display type, name, weight, sleep and location of animal objects
	●	Call method eat, sleep, swim
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class HaiDangLeGE01Polymorphism {

	public static void main(String[] args) {
		 
		try {
			Scanner fileScanner = new Scanner(new File("Animals.txt"));
						
			//Creates a polymorphic array to store the animals.
			int animalSize = fileScanner.nextInt();//1st value in the file which indicates how big to make the array
			Animal[] polyAnimals = new Animal[animalSize];
			int animalPosition = 0;//position of animal object in polyAnimal array
			
			//Uses a loop to fill the array with each animal’s information read from a file 
			while (fileScanner.hasNextLine() && animalPosition < animalSize ) {
				fileScanner.nextLine(); //skip first line in Animals.txt file 1st value in the file which indicates how big to make the array
				String type = fileScanner.next().trim();
				String name = fileScanner.next().trim();
				String food = fileScanner.next().trim();
				int weight = fileScanner.nextInt();
				int sleep = fileScanner.nextInt();
				String location = fileScanner.next() + " " + fileScanner.next().trim();

				//construct Animals object by type
				Animal currentAnimal; 
				if (type.equalsIgnoreCase("Bear")) {
					currentAnimal = new Bear(name, food, weight, sleep, location);
				} else if (type.equalsIgnoreCase("Elephant")) {
					currentAnimal = new Elephant(name, food, weight, sleep, location);
				} else if (type.equalsIgnoreCase("Monkey")) {
					currentAnimal = new Monkey(name, food, weight, sleep, location);
				} else if (type.equalsIgnoreCase("Sloth")) {
					currentAnimal = new Sloth(name, food, weight, sleep, location);
				}
				else {
					currentAnimal= new Animal(name, food, weight, sleep, location); 
				}
				
				//Add animal object to polyAnimals array
				polyAnimals[animalPosition] = currentAnimal;
				animalPosition++; //control variable for while loop
				
			}//end while loop
			
			//Create a 2nd loop to iterate through the array and: 
			for (int i=0; i< animalSize; i++ ) {
				System.out.println();
				//1.Display type (Bear, Elephant, etc.) of animal 
				System.out.print("Animal [" + i + "] is a ");
				if (polyAnimals[i] instanceof Bear){
					System.out.print("Bear\n");
				}
				else if (polyAnimals[i] instanceof Elephant){
					System.out.print("Elephant\n");
				}
				else if (polyAnimals[i] instanceof Monkey){
					System.out.print("Monkey\n");
				}
				else if(polyAnimals[i] instanceof Sloth) {
					System.out.print("Sloth\n");
				}
				else{
					System.out.print("Undifined animal");
				}
				
				//2.Display name, weight, sleep and location of animal by toString 
				System.out.println(polyAnimals[i].toString());
				
				//3.Call the following methods eat,sleep, swim
				polyAnimals[i].eat();
				polyAnimals[i].sleep();
				polyAnimals[i].swim();

			}//end for loop
			
			fileScanner.close();

		}//End try
		
		catch(FileNotFoundException e) {
			System.out.println("File not found. No animals's information to up load" + e.getMessage());
		}//end catch


	}//end main

}//end HaiDangLeGE01Polymorphism

class Animal {
	private	String name;
	private	String food;
	private	int weight;
	private	int sleep;
	private	String location;

	//constructor with specific parameters
	public Animal(String name, String food, int weight, int sleep, String location) {
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	//Getter for each instance variable - name, food, weight, sleep, and location
	public String getName() {
		return name;
	}
	public String getFood() {
		return food;
	}
	public int getWeight() {
		return weight;
	}
	public int getSleep() {
		return sleep;
	}
	public String getLocation() {
		return location;
	}
	
	//Additional public methods
	public void eat() {
		System.out.println("Animal is eating");
	}

	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}

	public void swim() {
		System.out.println("Animal is swimming");
	}
	
}//end Animal

class Bear extends Animal {
	//o	Constructor with specific parameters
	public Bear(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	
	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood());
	}
	@Override
	public void sleep() {
		System.out.println("Bear is sleeping " + getSleep() +" hours");
	}
	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}
	@Override
	public String toString() {
		return "Bear : Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
				+ " -Sleep: " + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Bear

class Elephant extends Animal {
	//o	Constructor with specific parameters
	public Elephant(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	@Override
	public void sleep() {
		System.out.println("Elephant is sleeping" + getSleep()+ " hours");
	}
	@Override
	public String toString() {
		return "Elephant: Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
				+ " -Sleep :" + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Elephant

class Monkey extends Animal {
	//o	Constructor with specific parameters
	public Monkey(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	@Override
	public void eat() {
		System.out.println("Monkey eating " + getFood() );
	}

	@Override
	public void swim() {
		System.out.println("Monkey is swimming");
	}
	@Override
	public String toString() {
		return "Monkey: Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
				+ " -Sleep :" + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Monkey

class Sloth extends Animal {
	//o	Constructor with specific parameters
	public Sloth(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	@Override
	public String toString() {
		return "Sloth: Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
				+ " -Sleep: " + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Sloth

