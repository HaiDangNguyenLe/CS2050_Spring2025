
public class SelectionBubleInsertSortTDD
{
	public static void main(String[] args)
	{
		
		int[][] testCases = { 
				{ 4, 2, 7, 1, 5 }, // Regular case
				{}, // Empty array
				{ 5 }, // Single element
				{ 1, 2, 3, 4, 5 }, // Already sorted
				{ 9, 7, 5, 3, 1 }, // Reverse sorted
				{ 4, 2, 7, 2, 5 } // Array with duplicates
		};
		/*//selection sort
		System.out.println("Testing Selection Sort");
		for (int i = 0; i < testCases.length; i++)
		{
			System.out.println("Test Case " + (i + 1) + ": Before Selection Sorting:");
			printArray(testCases[i]); 
			selectionSort(testCases[i]);
			System.out.println("After selection Sorting:");
			printArray(testCases[i]);
			System.out.println();
		}*/
		
		/*//bubble sort
		System.out.println("Testing Bubble Sort");
		for (int i = 0; i < testCases.length; i++)
		{
			System.out.println("Test Case " + (i + 1) + ": Before bubble Sorting:");
			printArray(testCases[i]); 
			bubbleSort(testCases[i]);
			System.out.println("After bubble Sorting:");
			printArray(testCases[i]);
			System.out.println();
		}*/
		
		//insert sort
		System.out.println("Testing Insert Sort");
		for (int i = 0; i < testCases.length; i++)
		{
			System.out.println("Test Case " + (i + 1) + ": Before insert Sorting:");
			printArray(testCases[i]); 
			insertSort(testCases[i]);
			System.out.println("After insert Sorting:");
			printArray(testCases[i]);
			System.out.println();
		}
		
	}
	

	/**
	 * selection sort
	 * @param array
	 */
	public static void selectionSort(int [] array)
	{
		for (int i = 0; i < array.length; i++  ) {
			int currentMin = array[i];
			int currentMinIndex = i;
			//Find smallest element in the list
			for ( int j = i + 1; j < array.length; j++) {
				//compare currentMin to another element to find smaller element and its index
				if (currentMin > array[j]) { 
					currentMin = array[j];
					currentMinIndex = j; //
				}
			}//end inner for loop
			//swap if new minimum was found
			if ( currentMinIndex != i) {
				int temp = array[i];
				array[i] = array[currentMinIndex];
				array[currentMinIndex] = temp;
			}
		}//end outer for loop
	}

	public static void bubbleSort(int [] array)
	{
		//2 Nested for loop to repeats this process until the array is sorted
		for (int i = 0; i < array.length -1; i++  ) {
			for (int j = 0; j < array.length -1; j++ ) {
				//Compare successive neighboring pairs. 
				//If the pair is not in order, its values are swapped
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}//end inner for loop
		}//end outer for loop
	
	}//End bubleSort method
	
	//insertSort
	public static void insertSort(int [] array)	{
		for( int i = 1; i < array.length; i++) {
			int key = array[i]; 
			int j= i;
			//compare each array[j-1] to key, if array[j-1] larger than key, assign array[j] = array[j-1] 
			while (j > 0 && array[j-1]> key) {
				array[j] = array[j-1];
				j--; //update control variable for while loop
			}//end while
			array[j] = key; //update value key to array[j], j when while stop
		}//end for loop
	}
	
	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}//end printArray


}//end SelectionSortTDD