import static org.junit.Assert.*;

import org.junit.Test;
public class TestNQueens
{
	/**
	 * This method is used to test the nQueen function of NQueens Class.
	 */
	@Test
	public void testForNQueens()
	{
		NQueens obj = new NQueens();
		boolean result = obj.nOueen(new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},0,4);
		if(result)
		{
			obj.print(4);
		}
		assertEquals(true, result);
		
	}
	
	@Test
	public void testForNQueens1()
	{
		NQueens obj = new NQueens();
		boolean result = obj.nOueen(new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}},0,8);
		if(result)
		{
			obj.print(8);
		}
		assertEquals(true, result);
		
	}
	
	

}
