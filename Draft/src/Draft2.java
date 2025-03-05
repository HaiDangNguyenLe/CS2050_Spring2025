
public class Draft2 {
	static int numGlo = 1;
	public static void main(String[] args) {
		//test();
		System.out.println(test());
		
		test2();
			
		System.out.println(numGlo);
		
	}
public static int test() {
	numGlo +=10;
	return numGlo;
}
public static void test2() {
	numGlo =20;
}
}
