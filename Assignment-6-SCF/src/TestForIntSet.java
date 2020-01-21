import static org.junit.Assert.*;
import org.junit.Test;
public class TestForIntSet 
{
	@Test
	public void testForIsMember()
	{
		IntSet obj = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,15,17,19});  
		
		boolean result = obj.isMember(15);
		boolean result1 = obj.isMember(10);
		boolean result2 = obj.isMember(128);
		
		assertEquals(true, result);
		assertEquals(true, result1);
		assertEquals(false, result2);
	}
	
	
	@Test
	public void testForSize()
	{
		IntSet obj = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,15,17,19});
		int resultSize = obj.size();
		assertEquals(13, resultSize); 
		
		IntSet obj1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		int resultSize1 = obj1.size();
		assertEquals(7, resultSize1);
		
		IntSet obj2 = new IntSet(new int[]{8,9,10,15,17,19});
		int resultSize2 = obj2.size();
		assertEquals(6, resultSize2);
		
		IntSet obj3 = new IntSet(new int[0]);
		int resultSize3 = obj3.size();
		assertEquals(0, resultSize3);
		
	}
	
	@Test
	public void testForIsSubset()
	{
		IntSet obj = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,15,17,19});
		IntSet obj1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		IntSet obj2 = new IntSet(new int[]{5,6,7});
		IntSet obj3 = new IntSet(new int[]{11,12,13});

		boolean result = obj.isSubset(obj1);
		boolean result1 = obj1.isSubset(obj2);
		boolean result2 = obj2.isSubset(obj3);
		
		assertEquals(true, result);
		assertEquals(true, result1);
		assertEquals(false, result2);		
	}
	
	@Test
	public void testForUnion()
	{
		IntSet obj = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,15,17,19});
		IntSet obj1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		IntSet obj2 = new IntSet(new int[]{5,6,7});
		IntSet obj3 = new IntSet(new int[]{11,12,13});
		
		int [] result1 = obj.union(obj , obj1);
		int [] result2 = obj1.union(obj1 , obj2);
		int [] result3 = obj2.union(obj2 , obj3);
		
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,15,17,19}, result1);
		assertArrayEquals(new int[]{1,2,3,4,5,6,7}, result2);
		assertArrayEquals(new int[]{5,6,7,11,12,13}, result3);	
	}
	
	@Test
	public void testForGetComplement()
	{
		IntSet obj1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		int [] expected = new int[993];
		int index =0 ;
		for(int i = 8; i<=1000; i++)
		{
			expected[index] = i;
			index++;
		}
		int []result = obj1.getComplement();
		assertArrayEquals(expected, result);
	}
}
