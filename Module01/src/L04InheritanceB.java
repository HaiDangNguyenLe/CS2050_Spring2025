
public class L04InheritanceB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class AnimalB {
	private String name;
	private double weight;
	private String food;
	private String location;

	public AnimalB() {
		System.out.println("Animal Default Constructor");
	}

	public AnimalB(String name, double weight, String food, String location ) {
		System.out.println("Animal Constructor - name, weight, food, location"); 
		this.name = name;
		this.weight = weight;
		this.food = food;
		this.location = location;
	}	

	// Make animal eat
	public void eat() {
		System.out.println("Animal is eating");
	}

	// Make animal sleep
	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}

	// Make animal roam
	public void roam() {
		System.out.println("Animal is roaming");
	}

   } // Animal


   class LionB extends AnimalB {

	public LionB() {
		System.out.println("Lion Default Constructor");
	}


	public LionB (String name, double weight, String food, String location) {
		//super(); // This call is not written in the code, but it does get called
		System.out.println("Lion Constructor - name, weight, food, location");
	}


   } // Lion
