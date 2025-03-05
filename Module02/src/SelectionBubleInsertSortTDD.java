
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
		//selection sort
		System.out.println("Testing Selection Sort");
		for (int i = 0; i < testCases.length; i++)
		{
			System.out.println("Test Case " + (i + 1) + ": Before Sorting:");
			printArray(testCases[i]); 
			selectionSort(testCases[i]);
			System.out.println("After Sorting:");
			printArray(testCases[i]);
			System.out.println();
		}
		
		//buble sort
		System.out.println("Testing Buble Sort");
		for (int i = 0; i < testCases.length; i++)
		{
			System.out.println("Test Case " + (i + 1) + ": Before buble Sorting:");
			printArray(testCases[i]); 
			bubleSort(testCases[i]);
			System.out.println("After buble Sorting:");
			printArray(testCases[i]);
			System.out.println();
		}
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
			for ( int j = i + 1; j < array.length; j++) {
				if (currentMin > array[j]) {
					currentMin = array[j];
					currentMinIndex = j;
				}
			}//end for 2
			//swap if new minimum was found
			if ( currentMinIndex != i) {
				int temp = array[i];
				array[i] = array[currentMinIndex];
				array[currentMinIndex] = temp;
			}
		}//end for 1
	}

	public static void bubleSort(int [] array)
	{
		for (int i = 0; i < array.length -1; i++  ) {
			for (int j = 0; j < array.length -1; j++ ) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	
	}//End bubleSort method
	
	//insertSort
	public static void insertSort(int [] array)	{
		for( int i = 1; i < array.length; i++) {
			int key = array[i];
			int j= i;
			while (j > 0 && array[j-1]> key) {
				array[j] = array[j-1];
				j--;
			}//end while
			array[j] = key;
			
			
		}
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