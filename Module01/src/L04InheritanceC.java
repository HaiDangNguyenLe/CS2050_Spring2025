
public class L04InheritanceC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class AnimalC {
	private String name;
	
	public AnimalC() {
		System.out.println("Animal Default Constructor");
		this.name = "";
	}

	public String getName() {
		return name;
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

   class LionC extends AnimalC {

	public LionC() {
		System.out.println("Lion Default Constructor");
	}

	// Make lion eat - override the animal eat method
	@Override
	public void eat() {
		System.out.println("IN LION CLASS!");
		System.out.println("Lion is eating");
		System.out.println("Lion eating is different from Animal eating");
	}
	
	public void doLionStuff () {
		// Call the Lion eat method
		eat();	
		
		for (int hour=0; hour < 20	; hour++) {
		   sleep();
		}
		roam();

		// Call the Animal eat method		
		super.eat();			
	}
   } // Lion
