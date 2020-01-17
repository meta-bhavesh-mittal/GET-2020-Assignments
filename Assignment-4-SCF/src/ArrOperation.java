import java.util.Scanner;

/**
 * This class is used to perform various operation on array.
 * @author Bhavesh
 *
 */
public class ArrOperation { 

	static Scanner input =new Scanner(System.in);

	/**
	 * This method is used to find the count of largest mirror elements in an array.
	 * @param arr In this Array is passed as an argument.
	 * @return It returns the count to maximum mirror elements.
	 */
	public static int largestMirror(int arr[])
	{
		int size = arr.length;
		if(size == 0)
		{
			throw new AssertionError();
		}
		int max =0;
		int [][]matrix=new int[size+1][size+1];
		for(int i=0;i<=size;i++)
		{
			for(int j=0;j<=size;j++)
			{
				if(i==0||j==0) 
				{
					matrix[i][j]=0;
				}
				else if(arr[i-1]==arr[size-j])
				{
					matrix[i][j]=matrix[i-1][j-1]+1;
				}
				else
				{
					matrix[i][j]=0;
				}
				if(max<matrix[i][j])
				{
					max=matrix[i][j];
				}

			}

		}
		return max;
	}


	/**
	 * This method is used to count the clumps in an array.
	 * @param arr1 In this array is passed as an argument.
	 * @return
	 */
	public static int countOfClumps(int arr1[])
	{
		int countClump=0;
		int num = arr1.length;
		if(num == 0)
		{
			throw new AssertionError();
		}
		int l = num;
		int current = -1;
		for(int i = 0; i < l - 1; i++) 
		{
			if(arr1[i] == arr1[i + 1] && arr1[i] != current) 
			{
				current = arr1[i];
				countClump++;
			} 
			else 
			{
				if(arr1[i] != current) 
				{
					current = -1;
				}
			}
		}
		return countClump;
	}


	/**
	 * This method is used to solve the FixXY problem. 
	 * @param arr Array of elements are passed as an argument.
	 * @param x The value of x is passed an argument.
	 * @param y The value of y is passed an argument.
	 * @return It return an array of solved solution.
	 */
	public static int [] fixXY(int arr[], int x , int y)
	{
	
		int num = arr.length;
		if(num == 0)
		{
			throw new AssertionError();
		}
		int xCount = 0 , yCount = 0;
		for(int i = 0;i < num; i++)
		{ 
			if(arr[i] == x)
			{
				xCount++;
			}
			else if(arr[i] == y)
			{
				yCount++;
			}
 
		}
		for( int i =0 ; i<num-1 ; i++)
		{
			if(arr[i] == x && arr[i+1] == x)
			{
				throw new AssertionError();
			}
		}
		if(arr[num-1]== x || xCount != yCount || xCount == 0 || yCount == 0)
		{
			throw new AssertionError();
		}

		for( int i = 0; i< num-1; i++)
		{
			if(arr[i] == x && arr[i+1] != y)
			{
				for( int  j = 0 ; j < num ; j++)
				{
					if(arr[j] == y)
					{
						if(j>0 && arr[j-1] == x)
						{
							continue;
						}
						int temp;
						temp = arr[i+1];
						arr[i+1] = arr[j];
						arr[j] = temp;
						break;
					}
				}
			}
		}
		return arr;

	}


	/**
	 * This method is used to give the index where array can be split where left array and 
	 * right array's elements sum is equal.
	 * @param arr Array of elements s passed as an argument.
	 * @return it return the index from where the array can be split.
	 */
	public static int splitArrayIndex(int arr[])
	{
		int splitIndex = -1;
		int num = arr.length;
		if(num == 0)
		{
			throw new AssertionError();
		}
		int arrL = arr[0] ,arrR = 0;

		for( int i = 0; i< num-1; i++)
		{
			arrR = 0;
			for(int j = i+1; j < num ; j++)
			{
				arrR = arrR + arr[j];
			}
			if(arrL == arrR)
			{
				splitIndex = i+1;
				return splitIndex;
			}
			else
			{
				arrL = arrL +arr[i+1];
			}
		}

		return splitIndex;
	}
}
