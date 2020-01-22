
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;



public class TestForPoly {
	Poly p1;
	Poly p2;
	Poly p3;
	Poly p4;
	
	@Before
	public void beforeTest()
	{
		p1 = new Poly(new int[]{4,2,1}, new int[]{3,2,1});
		p2 = new Poly(new int[]{4,2,1}, new int[]{3,2,1});
		p3 = new Poly(new int[]{2,1}, new int[]{2,1});
		p4 = new Poly(new int[]{1,1}, new int[]{2,1});
	}
	
	@Test
	public void testForSolve()
	{
		float result=p3.evalauate(4);
		assertEquals(36.00, result,2);
		
		result=p3.evalauate(5);
		assertEquals(55, result,2);


	}
	@Test
	public void testForDegree()
	{
		int result ;
		result =  p1.degree();
		
		assertEquals(3,result,5);
		
	}
	
	@Test
	public void testForaddPoly()
	{
		Poly result;
	
		result = Poly.addPoly(p1, p2);
		//System.out.println(result.getCofficient()[]);
		assertArrayEquals(new int[]{1,2,4},result.getExponent());
		assertArrayEquals(new int[]{2,4,6},result.getCofficient());
		
	}
//	@Test
//	public void testForMul()
//	{
//		Poly result;
//	
//		result = Poly.multiply(p3, p4)	;
//		assertArrayEquals(new int[]{2,2,1,1},result.getCofficient(),5);
//		assertArrayEquals(new int[]{4,3,3,2},result.getexponent(),5);
//		
//	}


}
