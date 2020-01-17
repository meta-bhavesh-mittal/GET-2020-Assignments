import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrOperation
{

	/**
	 * This method is used to test the code of count the clumps in an array.
	 */
	@Test
	public void testForClump()
	{
		try
		{
			ArrOperation obj1 = new ArrOperation();
			int resultClump = obj1.countOfClumps(new int[]{1, 2 ,2, 3, 4, 4});
			assertEquals( 2 , resultClump);

			resultClump = obj1.countOfClumps(new int[]{1,1,2,1,1});
			assertEquals( 2 , resultClump);

			resultClump = obj1.countOfClumps(new int[]{1,1,1,1,1});
			assertEquals(1 , resultClump);

			resultClump = obj1.countOfClumps(new int[]{0,0,0,0,0});
			assertEquals(1 , resultClump);
		}

		catch(AssertionError ex) 
		{
			System.out.println("Your array is empty in test for clumps.");
		}


	}

	/**
	 * This method is used to test the code of Split Array Index which means position at which array can
	 * be split.
	 */
	@Test
	public void testForSplitArray()
	{
		try
		{
			ArrOperation obj2 = new ArrOperation();
			int resultSplitIndex = obj2.splitArrayIndex(new int[]{1, 1 , 1, 2, 1});
			assertEquals(3 , resultSplitIndex);

			resultSplitIndex = obj2.splitArrayIndex(new int[]{2, 1, 1, 2, 1});
			assertEquals(-1 , resultSplitIndex );

			resultSplitIndex = obj2.splitArrayIndex(new int[]{10, 10});
			assertEquals(1 , resultSplitIndex );
			
			resultSplitIndex = obj2.splitArrayIndex(new int[0]);
			assertEquals(1 , resultSplitIndex );
			
		}
		catch(AssertionError ex)
		{
			System.out.println("Array is empty.");
		}

	}


	/**
	 * This method is used to test the code of FixXY problem.
	 */
	@Test
	public void testForFixXY() 
	{

		ArrOperation obj3 = new ArrOperation();
		try
		{
			int []resultFixXY = obj3.fixXY(new int[]{5, 4, 9, 4, 9, 5} , 4 , 5);
			int []expectedResult = new int []{9,4,5,4,5,9};
			assertArrayEquals( expectedResult , resultFixXY);


			resultFixXY = obj3.fixXY(new int[]{1, 4, 1, 5} , 4 , 5);
			expectedResult = new int []{1, 4, 5, 1};
			assertArrayEquals( expectedResult , resultFixXY);


			resultFixXY = obj3.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1} , 4 , 5);
			expectedResult = new int []{1, 4, 5, 1, 1, 4, 5};
			assertArrayEquals( expectedResult , resultFixXY);

		}
		catch(AssertionError ex)
		{
			System.out.println("Enter the correct information.");
		}
	}


	/**
	 * This method is used to test the code of count of largest mirror in an array.
	 */
	@Test
	public void testlargestMirror()
	{
		try
		{
			ArrOperation obj4 = new ArrOperation();
			int resultLargestMirror = obj4.largestMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
			assertEquals(3 , resultLargestMirror);

			resultLargestMirror = obj4.largestMirror(new int[]{1, 2, 1, 4});
			assertEquals(3 , resultLargestMirror );

			resultLargestMirror = obj4.largestMirror(new int[]{1, 4, 5, 3, 5, 4, 1});
			assertEquals(7 , resultLargestMirror );

			resultLargestMirror = obj4.largestMirror(new int[]{7, 1, 4, 9, 7, 4, 1});
			assertEquals(2 , resultLargestMirror );
		}

		catch(AssertionError ex)
		{
			System.out.println("Enter the correct input");
		}
	}
}
