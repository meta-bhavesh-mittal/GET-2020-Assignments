import static org.junit.Assert.*;
import org.junit.Test; 

public class TestHcfLcm
{

	/**
	 * This method is used to test the findHcf method of HcfLcmClass.
	 */
	@Test 
	public void testForHcf()
	{
		HcfLcmClass obj =new HcfLcmClass();

		int resultHcf = obj.findHcf(12, 9); 
		assertEquals( 3, resultHcf);

		resultHcf = obj.findHcf(168 , 126);
		assertEquals( 42, resultHcf);

		resultHcf = obj.findHcf(24 , 36);
		assertEquals( 12, resultHcf);

		resultHcf = obj.findHcf(616 , 32);
		assertEquals( 8, resultHcf);
	}

	/**
	 * This method is used to test the findLcm method of HcfLcmClass.
	 */
	@Test
	public void testForLcm()
	{
		HcfLcmClass obj =new HcfLcmClass();

		int resultLcm = obj.findLcm(15, 6); 
		assertEquals( 30, resultLcm);
	}

	@Test 
	public void testForLcm1()
	{
		HcfLcmClass obj =new HcfLcmClass();

		int resultLcm = obj.findLcm(4, 5);
		assertEquals( 20, resultLcm);
	}
	
	@Test
	public void testForLcm2()
	{
		HcfLcmClass obj =new HcfLcmClass();

		int resultLcm = obj.findLcm(4 , 10);
		assertEquals( 20, resultLcm);

	}
	
	@Test
	public void testForLcm3()
	{
		HcfLcmClass obj =new HcfLcmClass();

		int resultLcm = obj.findLcm(0,-1); 
		assertEquals( -1, resultLcm);
	}
}
