import java.util.Arrays;

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
		
		// Update the new array by calling method to update with random numbers		
		//call method to display the array				
		// call arrays class method to sort				
		// call method to display the array		
		// Prompt and read from keyboard what to search for		
		//call arrays class binary search method		
		//display whether the value was found or not


	}//end main
	public void displayArray(int[] array) {
		for ( int i = 0; i < array.length; i++ ) {
			//System.out.println("number [" + i + "] = "+ );
		}
	}

}
