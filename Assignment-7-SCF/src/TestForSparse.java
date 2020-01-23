import static org.junit.Assert.*;

import org.junit.Test;
public class TestForSparse 
{

	@Test
	public void testForTranspose()
	{
		SparseMatrix obj = new SparseMatrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
		int expected[][] = new int[][]{{1,0,0},{0,2,0},{0,0,1}};
		int result[][] = obj.getTranspose();
		assertArrayEquals(expected, result);
	}
	
	
	@Test
	public void testForSymmetry()
	{
		SparseMatrix obj = new SparseMatrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
		boolean result = obj.isSymmetrical();
		assertEquals(true, result);
	}
	
	@Test
	public void testForAdd()
	{
		SparseMatrix obj = new SparseMatrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
		SparseMatrix obj1 = new SparseMatrix(new int[][] {{3,0,5},{0,2,0},{0,0,1}});
		int [][] addExpected = new int[][]{{4,0,5},{0,4,0},{0,0,2}};
		int[][] result = obj1.add(obj);
		assertArrayEquals(addExpected, result);
	}
	
	@Test
	public void testForMulti()
	{
		SparseMatrix obj = new SparseMatrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
		SparseMatrix obj1 = new SparseMatrix(new int[][] {{3,0,5},{0,2,0},{0,0,1}});
		int [][] multiExpected = new int[][]{{3,0,5},{0,4,0},{0,0,1}};
		int[][] result = obj1.multiply(obj);
		assertArrayEquals(multiExpected, result);
	}
}
