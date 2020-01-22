import java.util.Arrays;


public final class Poly
{
	private final int power[];
	private final int cofficient[];

	public Poly(int[] power, int[] cofficient)
	{
		this.power = power;
		this.cofficient = cofficient;
	}

	/**
	 * This method is used to evaluate the expression for some particular value.
	 * @param varValue
	 * @return it returns the answer in float value.
	 */
	public float evalauate(float varValue)
	{
		float evaluateResult = 0;
		for(int i = 0; i < cofficient.length ;i++)
		{
			evaluateResult =evaluateResult + (float) (cofficient[i] * (Math.pow(varValue, power[i])));
		}
		return evaluateResult;
	}

	/**
	 * This method is used to calculate degrre.
	 * @return
	 */
	public int degree()
	{
		int maxDegree = 0;
		Arrays.sort(power);
		return power[power.length-1];
	}

	
	/**
	 * This method is used to calculate the addition of two polynomial.
	 * @param p1
	 * @param p2
	 * @return it returns the poly class object.
	 */
	public static Poly addPoly(Poly p1 , Poly p2)
	{
		int count = 0;
		for( int  i = 0 ; i < p1.power.length ; i++)
		{
			for( int  j = 0 ; j < p2.power.length ; j++)
			{
				if(p1.power[i] == p2.power[j])
				{
					count++;
					break;
				}
			}
		}
		int size  = p1.power.length + p2.power.length - count;
		int [] powerArray = new int[size];
		int [] coffArray = new int[size];
		for(int i = 0; i < p1.power.length-1 ; i++ )
		{
			for(int j = i+1; j < p1.power.length ; j++ )
			{
				if(p1.power[i] > p1.power[j])
				{
					int temp;
					temp = p1.power[i];
					p1.power[i] = p1.power[j];
					p1.power[j]= temp;
					int temp1;
					temp1 = p1.cofficient[i];
					p1.cofficient[i] = p1.cofficient[j];
					p1.cofficient[j] = temp1;
				}
			}
		}
		for(int i = 0; i < p2.power.length-1 ; i++ )
		{
			for(int j = i+1; j < p2.power.length ; j++ )
			{
				if(p2.power[i] > p2.power[j])
				{
					int temp;
					temp = p2.power[i];
					p2.power[i] = p2.power[j];
					p2.power[j]= temp;
					int temp1;
					temp1 = p2.cofficient[i];
					p2.cofficient[i] = p2.cofficient[j];
					p2.cofficient[j] = temp1;
				}
			}
		}
		int index = -1;
		int index1 = -1;
		int i=0,j=0,count_i=0,count_j=0;
		while(i<p1.power.length && j<p2.power.length){
			if(p1.power[i]==p2.power[j]){
				powerArray[++index] = p1.power[i];
				coffArray[++index1] = p1.cofficient[i]+p2.cofficient[j];
				i++;
				j++;
				count_i++;
				count_j++;
				
			}
			else if(p1.power[i]<p2.power[j]){
				System.out.println(p1.power[i]+"<"+p2.power[j]);

				powerArray[++index] = p1.power[i];
				coffArray[++index1] = p1.cofficient[i];
				i++;
				count_i++;
			}
			else{
				System.out.println(p1.power[i]+">"+p2.power[j]);

				powerArray[++index] = p2.power[j];
				coffArray[++index1] = p2.cofficient[j];
				j++;
				count_j++;
			}
		
		}
		
		System.out.println("count"+count);

			for(int t=count_i;t<p1.power.length;t++){
				powerArray[++index] = p1.power[t];
				coffArray[++index1] = p1.cofficient[t];
			}
		
		
		
			for(int t=count_j;t<p2.power.length;t++){
				powerArray[++index] = p2.power[t];
				coffArray[++index1] = p2.cofficient[t];
			}
				for(i= 0; i< powerArray.length; i++)
		{
			System.out.println(powerArray[i]+"="+coffArray[i]);
			
		}
				return new Poly(powerArray,coffArray);
	}
	
	
	/**
	 * This method is used to return the cofficient array.
	 * @return it returns an array.
	 */
	public int[] getCofficient()
	{

		return cofficient;
	}
	
	/**
	 * This method is used to return the power array.
	 * @return it returns an array.
	 */
	public int[] getExponent()
	{

		return power;
	}
	

}
