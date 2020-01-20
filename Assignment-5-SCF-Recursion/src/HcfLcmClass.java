import java.util.Scanner;

/**
 * This class is used to calculate HCF and LCM of two numbers.
 * @author Bhavesh
 *
 */
public class HcfLcmClass { 

	private int lcm=1;
	/**
	 * This method is used to calculate lcm of two numbers.
	 * @param a first number
	 * @param b second number
	 * @return it returns lcm of two numbers.
	 */
	public int findLcm(int a , int b)

	{
		int c = a + b;
		if( c < 0)
		{ 
			return -1;
		}
		if( lcm % a == 0 &&  lcm % b == 0)
		{
			return lcm;
		}
		lcm++;
		return findLcm(a, b); 
	}

	/**
	 * This method is used to calculate the HCF of two numbers.
	 * @param a first numbers
	 * @param b second numbers
	 * @return It returns the HCF of two numbers.
	 */
	public int findHcf(int a , int b)
	{
		if( a == 0)
		{
			return b;
		}
		else
		{
			return findHcf( b % a , a); 
		}

	}

}
