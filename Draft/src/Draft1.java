
public class Draft1 {
	public static void main (String[] args ) {
		int number = 0;
		for (int i = 0; i <= 1000; i += 10 ) {
			System.out.print(""+ number + ", ");
			number += 10;
		}

		double Array[] [] = {{1,2,8,1,0,9},
				{2,8,4,8,9,5},
				{4,9,6,8,7,1},
				{7,8,6,3,5,7},
				{1,2,4,8,9,3}};
		double sum = 0;

		for (int row = 0; row < Array.length; row++) {
			sum += Array[row][1];

		}
		System.out.print("\nsum of colume is: "+ sum);	

		double sum2 = 0;

		for (int col = 0; col < Array[1].length; col++) {
			sum2 += Array[2][col];

		}
		System.out.print("\nsum of row is: "+ sum2);	

		int soGiaiThua = 100;
		System.out.println("\nGiai thừa của " + soGiaiThua + " là: " + factorial(soGiaiThua));

		int count = 1, total=0;
		while(count <=100) {
			total += count;
			count++;
		}

		display2DArray(Array);
		System.out.print("Sum of array is: "+ calculateArraySum(Array));


	}//end main
	public static double factorial(int n) {
		if (n == 0) {  // ✅ Điều kiện dừng
			return 1;
		}
		return n * factorial(n - 1);  // 🔄 Gọi đệ quy
	}

	//Write method to display2DArray
	public static void display2DArray(double[][] anArray ) {
		System.out.println("Display of array:");
		for (int row = 0; row < anArray.length; row++) {
			for(int col = 0; col < anArray[row].length; col++) {
				System.out.print(""+ anArray[row][col] + " ");
			}
			System.out.println();
		}
	}

	//write method calculateArraySum
	public static double calculateArraySum(double[][] anArray) {
		double sumOfArray = 0;
		for (int row = 0; row < anArray.length; row++) {
			for(int col = 0; col < anArray[row].length; col++) {
				sumOfArray += anArray[row][col];
			}
		}
		return sumOfArray;
	}	

}//end class



