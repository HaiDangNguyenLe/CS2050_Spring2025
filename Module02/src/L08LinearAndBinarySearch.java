import java.util.Arrays;

public class L08LinearAndBinarySearch {

	public static void main(String[] args) {
		int []list1 = {9,2,5,2,5,7};
		int []list2 = {1,2,3,3,4,4,6,7,8};
		//System.out.println("Linear search result:" +linearSearch(list1,2));
		System.out.println("Binary search result: "+binarySearch(list2,4));

	}//end main

	//linear search
	public static int linearSearch (int [] list, int key){
		//compare each element of array to key
		//if the same then return the position
		//if no element the same, return -1
		for( int i=0; i< list.length; i++) {
			if(key == list[i]) {
				return i;
			}
		}
		return -1;
	}//end linearSearch

	// Binary search
	//list must be sorted arrays
	public static int binarySearch (int [] list, int key)	{
		int low = 0;
		int high = list.length - 1;
		int index = -1; //If cannot found key, return -1
		while (high > low ) {
			int mid = (low + high)/2; //find mid
			//update high if list[mid] > key
			if (key < list[mid]) {
				high = mid-1;
			}
			//return position = mid if key = list[mid]
			else if (key == list[mid]) {
				//update index if key is found
				index = mid;
				//continue search more on left side to find first occurrence 
				high = mid-1;
			} 
			//update low if list[mid] < key
			else {
				low = mid +1;
			}

		}//end while
		return index; //no thing found
	}//end binary search



}