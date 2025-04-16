
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class L16ArrayListBird {

	public static void main(String[] args) {
		try {
			// Stores the bird objects in an ArrayList
			ArrayList<Birds> birds = birdSetup("birds.txt");
			
			//Displays all bird details, including an interesting fact for each bird type
			displayAllBirds(birds);
			//Displays a table of birdst that can swim
			displaySwimmer(birds);
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}

//Array list of intergers
ArrayList<Integer> myList = new ArrayList<>();

	}//end main

	// Reads bird data from a file  
	public static ArrayList<Birds> birdSetup(String filename) throws FileNotFoundException {
		
		//Create ArrayList of bird objects
		ArrayList<Birds> birds = new ArrayList<>();
		
		Scanner fileScanner = new Scanner(new File(filename));
		
		while (fileScanner.hasNext()) {
			//take first line in file
			fileScanner.nextLine();
			//Read data from file
			String type = fileScanner.next();
			String name = fileScanner.next();
			int swimSpeed = 0;
			if (fileScanner.hasNextInt()) {
				swimSpeed = fileScanner.nextInt();
			}

			// Using dynamic object creation based on type with read data
			if (type.equalsIgnoreCase("penguin")){
				birds.add(new Penguin(name, swimSpeed));
			} else if (type.equalsIgnoreCase("duck")){
				birds.add(new Duck(name, swimSpeed));
			} else if (type.equalsIgnoreCase("ostrich")){
				birds.add(new Ostrich(name));
			} else if (type.equalsIgnoreCase("sootytern")){
				birds.add(new SootyTern(name));
			}else{
				System.out.println(" Unknown type: " + type);
			}
		}//end while
		fileScanner.close();

		return birds;
	}


	//Display type
	public static String getType(Birds bird) {
		String type = "unknown";
				if (bird instanceof Penguin) {
            type = "Penguin";
        } else if (bird instanceof Duck) {
            type = "Duck";
        } else if (bird instanceof Ostrich) {
            type = "Ostrich";
        } else if (bird instanceof SootyTern) {
            type = "Sooty Tern";
        } else {
            type = "Unknown";
        }
		return type;
	}
	//Display all birds 
	public static void displayAllBirds(ArrayList<Birds> birds) {
		System.out.println("\nBirds and Their Abilities");
		System.out.println("----------------------------");
		for (Birds bird : birds) {
			System.out.println(bird.getName() + " is a " + getType(bird));
			System.out.println("" + bird.interestingFact());
		}
	}

	// Method to find all swimming birds
	public static ArrayList<Swimmer> findSwimmers(ArrayList<Birds> birds){
		ArrayList<Swimmer> swimmers = new ArrayList<>();
		
		for (Birds bird : birds){
			if (bird instanceof Swimmer){
				swimmers.add((Swimmer) bird);
			}
		}
		return swimmers;
	}
	//Displays a table of birdst that can swim
	public static void displaySwimmer(ArrayList<Birds> birds) {
		ArrayList<Swimmer> swimmers = findSwimmers(birds);
		System.out.println("\nBIRDS THAT CAN SWIM");
		System.out.println("----------------------------");
		System.out.println("Bird	Type	Swim Speed");
		System.out.println("----------------------------");
		for  (Swimmer swimmer : swimmers) {
	        Birds bird = (Birds) swimmer;  // cast to access getName() and getType()
	        System.out.println(bird.getName() + "	" + getType(bird) + "	   " + swimmer.swim());
	    }
	}
	
}//endL16ArrayListBird


//Abstract class
abstract class Birds {
	private String name;
	public Birds(String name) {
		this.name = name;
	}
	//getName
	public String getName() {
		return name;
	}

	//interestingFact abstract method
	public abstract String interestingFact() ;

}//end Birds abstract class

//Interface
interface Swimmer{
	int swim();
}

//Penguin
class Penguin extends Birds implements Swimmer{
	private int swimSpeed;

	//Constructor
	public Penguin(String name, int swimSpeed) {
		super(name);
		this.swimSpeed = swimSpeed;
	}

	@Override
	public String interestingFact() {
		return "I can't fly but I'm the fastest swimmer and deepest diver.";
	}

	@Override
	public int swim() {
		return swimSpeed;
	}

}
//Duck
class Duck extends Birds implements Swimmer{
	private int swimSpeed;

	//Constructor
	public Duck(String name, int swimSpeed) {
		super(name);
		this.swimSpeed = swimSpeed;
	}

	@Override
	public String interestingFact() {
		return "A duck's highest documented flight was at 21,000 feet!";
	}

	@Override
	public int swim() {
		return swimSpeed;
	}

}

//Ostrich
class Ostrich extends Birds{
	//Constructor
	public Ostrich(String name) {
		super(name);
	}

	@Override
	public String interestingFact() {
		return "Who needs flying when you're the biggest bird on earth!";
	}
}

//SootyTern
class SootyTern extends Birds{
	//Constructor
	public SootyTern(String name) {
		super(name);
	}

	@Override
	public String interestingFact() {
		return "I spend most of my life at sea but can't swim!";
	}
}	
