import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class L15BirdArrayList {

	public static void main(String[] args) {
		try {
			//Stores the bird objects in an ArrayList
			ArrayList<Bird> ArrayListOfBirds = birdSetup("birds.txt");
			//Display all birds details
			displayBirdsDetail(ArrayListOfBirds);
			//Display table of bird that can swim
			displayBirdsCanSwim(ArrayListOfBirds);
		}catch (FileNotFoundException e) {
			System.out.println("File was not found");
		}


	}//end main
	//Reads bird data from a file (birds.txt)
	public static ArrayList<Bird> birdSetup(String filename) throws FileNotFoundException{
		Scanner fileScanner = new Scanner(new File(filename));
		ArrayList<Bird> birds = new ArrayList<>();
		while (fileScanner.hasNext()){
			fileScanner.nextLine(); //skip first line
			String type = fileScanner.next().trim();
			String name = fileScanner.next().trim();
			double swimSpeed = 0;
			if (fileScanner.hasNextDouble()) {
				swimSpeed = fileScanner.nextDouble();
			}

			// Using dynamic object creation based on type
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
		}
		fileScanner.close();
		return birds;
	}//end method
	//getBirdType
	public static String getBirdType(Bird bird) {
		String type = "unknown";

		if (bird instanceof Penguin) {
			type = "Penguin";
		}
		else if(bird instanceof Duck) {
			type = "Duck"; 

		}else if(bird instanceof Ostrich) {
			type = "Ostrich"; 
		}
		else if(bird instanceof SootyTern) {
			type = "Sooty Tern"; 
		}else {
			type = "unknown bird type";
		}
		return type;	
	}
	//Display all birds details method
	public static void displayBirdsDetail(ArrayList<Bird> birds) {
		System.out.println("\nBirds and Their Abilities");
		System.out.println("----------------------------");
		for (Bird bird : birds)
		{
			System.out.println(bird.getName() + " is a " + getBirdType(bird) );
			System.out.println(bird.displayInterestingFact());
		}


	}
	//Display table of bird that can swim method
	public static ArrayList<Swimmer> findSwimmer(ArrayList<Bird> birds) {
		ArrayList<Swimmer> swimmers = new ArrayList<>();
		for (Bird bird : birds){
			if (bird instanceof Swimmer){
				//Cast bird to a swimmer. By casting the Bird objects to Swimmer,
				//we ensure that all objects stored in swimmers have the swim() method
				swimmers.add((Swimmer) bird); 
			}
		}
		return swimmers;

	}
	//Display birds can swim
	public static void displayBirdsCanSwim(ArrayList<Bird> birds) {
		
		ArrayList<Swimmer> swimmers= findSwimmer(birds); //find birds that can swim
		
		System.out.println();
		System.out.println ("BIRDS THAT CAN SWIM");
		System.out.println("---------------------------");
		System.out.println("Bird	Type	Swim Speed");
		System.out.println("---------------------------");
		
		for (Swimmer swimmer : swimmers) { //for each swimmer
			//Casting swimmer object to bird because all objects store in bird have getName and getBirdType	
			Bird bird = (Bird)swimmer; 
			System.out.println( bird.getName()+ "	" + getBirdType(bird) + "	  " + swimmer.swim());
		}
	}
}//end L15BirdArrayList
interface Swimmer {
	double swim();
}

abstract class Bird{
	private String name;
	//constructor
	public Bird(String name) {
		this.name = name;
	}
	//getter
	public String getName() {
		return name;
	}
	
	//Abstract method
	abstract String displayInterestingFact();

}//end Bird class
class Penguin extends Bird implements Swimmer{
	private double swimSpeed;
	//constructor
	public Penguin(String name,double swimSpeed) {
		super(name);
		this.swimSpeed = swimSpeed;

	}
	@Override
	public double swim() {
		return swimSpeed;
	}
	@Override
	public String displayInterestingFact() {
		return "I can't fly but I'm the fastest swimmer and deepest diver";
	}
}//end Penguin

class Duck extends Bird implements Swimmer{
	private double swimSpeed;
	//constructor
	public Duck(String name,double swimSpeed) {
		super(name);
		this.swimSpeed = swimSpeed;
	}
	@Override
	public double swim() {
		return swimSpeed;
	}
	@Override
	public String displayInterestingFact() {
		return"My highest documented flight was at 21,000 feet";
	}
}//end Duck

class SootyTern extends Bird {
	//constructor
	public SootyTern(String name) {
		super(name);
	}

	@Override
	public String displayInterestingFact() {
		return "I spend most of my life at sea but can't swim";
	}
}//end sootyTern

class Ostrich extends Bird{
	//constructor
	public Ostrich(String name) {
		super(name);
	}
	@Override
	public String displayInterestingFact() {
		return "Who needs flying when you're the biggest bird on earth";
	}
}//end Ostrich

