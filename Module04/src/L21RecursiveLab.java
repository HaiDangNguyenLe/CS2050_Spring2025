
public class L21RecursiveLab {

	public static void main(String[] args) {
		badRecursion(2);
		
	
	}
	public static int badRecursion(int n) {
		   if (n <= 1) return 1;
		   return n * badRecursion(n - 2);
		}
	
	
	
}


