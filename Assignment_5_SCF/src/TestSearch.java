import static org.junit.Assert.*;

import org.junit.Test;
public class TestSearch 
{

	/**
	 * This method is used to test the linearSearch method of Search class.
	 */
	@Test
	public void testLinearSearch()
	{
		Search obj = new Search();  

		int resultIndex  =  obj.linearSearch(new int[]{4, 6, 1, 45, 87, 23, 67}, 45);
		assertEquals(3, resultIndex);

		int resultIndex1  =  obj.linearSearch(new int[]{23, 65, 12, 89, 2, 6, 76, 29}, 12);
		assertEquals(2, resultIndex1);

		int resultIndex3  =  obj.linearSearch(new int[]{4, 6, 1, 45, 98, 23, 67}, 98);
		assertEquals(4, resultIndex3);

		int resultIndex2  =  obj.linearSearch(new int[]{2, 3, 4, 5 ,6 ,7 }, 2);
		assertEquals(0, resultIndex2);
		

		resultIndex2  =  obj.linearSearch(new int[0], 2);
		assertEquals(-1, resultIndex2);

	}

	/**
	 * This method is used to test the binarySearch method of Search class.
	 */
	@Test 
	public void testBinarySearch()
	{
		Search obj = new Search(); 

		int resultIndex  =  obj.binarySearch(new int[]{1, 4, 6, 23, 45, 67, 87}, 45);
		assertEquals(4, resultIndex);

		resultIndex  =  obj.binarySearch(new int[]{2, 6, 12, 34, 45, 56, 76, 89}, 76);
		assertEquals(6, resultIndex);

		resultIndex  =  obj.binarySearch(new int[]{2, 3, 4, 5 ,6 ,7 }, 2);
		assertEquals(0, resultIndex);

		resultIndex  =  obj.binarySearch(new int[]{4, 8, 12, 34, 45, 56, 78, 98, 108}, 44);
		assertEquals(-1, resultIndex);
	}
}
