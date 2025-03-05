
public class L04InheritanceA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class AnimalA {
	private String name;
	private double weight;
	private String food;
	private String location;

	public AnimalA() {
		System.out.println("Animal Constructor - name, weight, food, location"); 
		this.name = "";
		this.weight = 0;
		this.food = "";
		this.location = "";
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


   class LionA extends AnimalA {

	public LionA () {
		//super(); // This call is not written in the code, but it does get called
		System.out.println("Lion Constructor");
	}

   } // Lion

