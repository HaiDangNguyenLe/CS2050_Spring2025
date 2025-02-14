
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class HaiDangLeGE01Polymorphism {

	public static void main(String[] args) {
		//Creates a polymorphic array to store the animals.
		final int ANIMAL_SIZE = 7;
		Animal[] PolyAnimal = new Animal[ANIMAL_SIZE];
		
		//Uses a loop to fill the array with each animal’s information read from a file  
		
		
		
	}//end main

}//end HaiDangLeGE01Polymorphism

class Animal {
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;
	
	//constructor
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
	//additional public methods
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
	//o	Constructor
	public Bear(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	@Override
	public void eat() {
		System.out.println("Bear is eating Honey");
	}
	@Override
	public void sleep() {
		System.out.println("Bear is sleeping 8 hours");
	}
	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}
	@Override
	public String toString() {
		return super.toString() + "Bear: Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
								+ " -Sleep:" + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Bear

class Elaphant extends Animal {
	//o	Constructor
	public Elaphant(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	@Override
	public void sleep() {
		System.out.println("Elephant is sleeping 8 hours");
	}
	@Override
	public String toString() {
		return super.toString() + "Elephant: Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
								+ " -Sleep:" + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Elephant

class Monkey extends Animal {
	//o	Constructor
	public Monkey(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	@Override
	public void eat() {
		System.out.println("Monkey eating Banana");
	}
	
	@Override
	public void swim() {
		System.out.println("Monkey is swimming");
	}
	@Override
	public String toString() {
		return super.toString() + "Monkey: Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
								+ " -Sleep:" + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Monkey

class Sloth extends Animal {
	//o	Constructor
	public Sloth(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	@Override
	public String toString() {
		return super.toString() + "Sloth: Name: " + getName() + " -Weight: " + getWeight() + " lbs" 
								+ " -Sleep:" + getSleep() + " hours" + " -Location: " + getLocation() ;
	}
}//end Sloth

