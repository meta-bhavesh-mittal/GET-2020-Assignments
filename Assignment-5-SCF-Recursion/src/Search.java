import java.util.Arrays;

/**
 * 
 * @author Bhavesh
 *
 */
public class Search {

	/**
	 * This function is used to find out the index of element if found in linear search.
	 * @param array all the elements are stored in array.
	 * @param element
	 * @return it returns the index of element if found otherwise returns -1.
	 */
	public static int linearSearch(int[] array,int element)
	{
		int length=array.length;
		if(array.length <= 0)
		{
			return -1;
		}
		else if(array[length-1]==element)
		{ 
			return length-1;
		}
		int[] array2 = Arrays.copyOfRange(array, 0, length-1);
		return linearSearch(array2,element);
	}


	/**
	 * This function is used to calculate the index by binary search technique. 
	 * and it implicitly calls the another method.
	 * @param inputArray all the elements are stored in array.
	 * @param element
	 * @return it returns the index if element found.
	 */
	public int binarySearch(int inputArray[],int element)
	{
		int start=0;
		int end=inputArray.length;
		int index=binarySearchRecursive(inputArray,start,end,element);
		return index;
	}
		 
	/**
	 * This is recursive approach for finding the index of element in an array by binary search technique.
	 * @param inputArray all the elements are stored in array.
	 * @param startIndex 
	 * @param arrayLength
	 * @param element
	 * @return it returns the index if element found.
	 */
	public static int binarySearchRecursive(int inputArray[], int startIndex, int arrayLength, int element) 
	    { 
	        if (arrayLength >= startIndex)
	        { 
	            int mid = startIndex + (arrayLength - startIndex) / 2;
	            if (inputArray[mid] == element) 
	                return mid; 
	            if (inputArray[mid] > element) 
	                return binarySearchRecursive(inputArray, startIndex, mid - 1, element); 
	  
	             return binarySearchRecursive(inputArray, mid + 1, arrayLength, element); 
	        } 
	  
	        return -1; 
	    } 


}
