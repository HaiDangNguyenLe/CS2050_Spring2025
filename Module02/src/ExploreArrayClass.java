import java.util.Arrays;
import java.util.Scanner;
public class ExploreArrayClass {

	public static void main(String[] args) {
		//create new array with 10 integers
		int[] numberArray = new int [10];
		int length = numberArray.length;
		for (int i = 0; i < length; i++) {
			numberArray[i] = (int)(Math.random()*10);
		}
		//call arrays class method to fill with 13 for each element
		Arrays.fill(numberArray, 13);
		//call method to display the array	
		displayArray(numberArray);
		// Update the new array by calling method to update with random numbers	
		randomValue(numberArray);
		//call method to display the array	
		System.out.println("Array with random numbers:");
		displayArray(numberArray);
		// call arrays class method to sort	
		Arrays.sort(numberArray);
		// call method to display the array	
		System.out.println("Array after sort:");
		displayArray(numberArray);
		// Prompt and read from keyboard what to search for	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an integer value to search: ");
		int key = keyboard.nextInt();
		//call arrays class binary search method
		int index = Arrays.binarySearch(numberArray, key);
		//display whether the value was found or not
		System.out.println("Index : "+ index);

	}//end main
	public static void displayArray(int[] array) {
		for ( int i = 0; i < array.length; i++ ) {
			System.out.println("number [" + (i+1)  + "] = "+ array[i]);
		}
	}
	//method to update with random numbers
	public static void randomValue(int[] array) {
		for ( int i = 0; i < array.length; i++ ) {
			array[i] = (int)(Math.random()*100);
		}
	}

}
