
import java.util.Scanner;

public class L14VehicleAbstractAndInterface {

	public static void main(String[] args) {
		//Create objects for different types of vehicle
		ElectricCar ioniq = new ElectricCar("Hyundai Ioniq5", 60);
        GasCar honda = new GasCar("Honda Civic", 50);
        HybridCar prius = new HybridCar("Toyota Prius", 55);
        //Test electric car
        ioniq.accelerate(10);
        ioniq.refuel();
        System.out.println();
        
        //Test GasCar
        honda.accelerate(15);
        honda.refuel();
        System.out.println();
        
        //Test HybridCar
        prius.accelerate(12);
        prius.refuel();
                
	}//end main

}//end L14VehicleAbstractAndInterface 

//Abstract class
abstract class Vehicle{
	private String brand;
	private int speed;

	public Vehicle (String brand, int speed) {
		this.brand = brand;
		this.speed = speed;
	}

	//getBrand
	public String getBrand() {
		return brand;
	}
	//getSpeed
	public int getSpeed()
	{
		return speed;
	}
	//method to accelerate
	public void accelerate(int increaseSpeed ) {
		speed = speed + increaseSpeed;
		System.out.println(brand + " accelerates to " + speed + " mph.");
	}
	//Abstract method to be implemented by subclasses
	public abstract void refuel();		

}//end Vehicle

//Interface for electric vehicle
interface Electric {
	void chargeBattery();
}
//interface for gas-powered vehicle
interface GasPowered {
	void refuelGas();
}

//Concrete class for electric car
class ElectricCar extends Vehicle implements Electric {
	public ElectricCar(String brand, int speed) {
		super(brand, speed);
	}
	
	@Override
	public void chargeBattery() {
        System.out.println("Charging battery for " + this.getBrand());
    }
	
	@Override
    public void refuel() {
        chargeBattery(); // Electric cars "refuel" by charging
    }
}//end ElectricCar

//Concrete class for gas-powered cars
class GasCar extends Vehicle implements GasPowered {
    public GasCar(String brand, int speed) {
        super(brand, speed);
    }
   
    @Override
    public void refuelGas() {
        System.out.println("Refueling gas tank for " + this.getBrand());
    }
   
    @Override
    public void refuel() {
        refuelGas();
    }
}//end GasCar

// Concrete class for hybrid cars
class HybridCar extends Vehicle implements Electric, GasPowered {
    public HybridCar(String brand, int speed) {
        super(brand, speed);
    }
    
    @Override
    public void chargeBattery() {
        System.out.println("Charging battery for " + this.getBrand());
    }
    
    @Override
    public void refuelGas() {
        System.out.println("Refueling gas tank for " + this.getBrand());
    }
    
    @Override
    public void refuel() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose refueling method for " + this.getBrand() + " (1: Charge Battery, 2: Refuel Gas): ");
        int choice = input.nextInt();
        if (choice == 1) {
            chargeBattery();
        } else if (choice == 2) {
            refuelGas();
        } else {
            System.out.println("Invalid choice, no refueling performed.");
        }
        input.close();
        
    }
}//end HybridCar


