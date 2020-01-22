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


	public float evalauate(float varValue)
	{
		float evaluateResult = 0;
		for(int i = 0; i < cofficient.length ;i++)
		{
			evaluateResult =evaluateResult + (float) (cofficient[i] * (Math.pow(varValue, power[i])));
		}
		return evaluateResult;
	}


	public int degree()
	{
		int maxDegree = 0;
		Arrays.sort(power);
		return power[power.length-1];
	}


	public static Poly addPoly(Poly p1, Poly p2)
	{
		int [] powerArray = new int[Math.max(p1.power.length , p2.power.length)];
		int [] coffArray = new int[Math.max(p1.cofficient.length , p2.cofficient.length)];
		int index = -1;
		int index1 = -1;
		for ( int i = 0; i < p1.power.length; i++)
		{
			for(int j = 0; j < p2.power.length; j++)
			{
				if(p1.power[i] == p2.power[j])
				{
					coffArray[++index] = p1.cofficient[i] + p2.cofficient[j];
					powerArray[++index1] = p1.power[i];
					p1.cofficient[i] = -1;
					p2.cofficient[j] = -1;
					p1.power[i] = -1;
					break;
				}
			}
		}
		for ( int i = 0; i < p1.power.length; i++)
		{
			if(p1.cofficient[i] != -1)
			{
				coffArray[++index] = p1.cofficient[i];
				powerArray[++index] = p1.power[i];
			}
		}
		for ( int i = 0; i < p2.power.length; i++)
		{
			if(p2.cofficient[i] != -1)
			{
				coffArray[++index] = p2.cofficient[i];
				powerArray[++index] = p2.power[i];
			}
		}
		Poly obj = new Poly(powerArray , coffArray);
		return obj;
	}

	public static void main(String[] args) 
	{
		Poly obj = new Poly(new int[]{2,1,0} , new int[]{2,1,5});
		Poly obj1 = new Poly(new int[]{2,1,0} , new int[]{5,7,2});
		float answer = obj.evalauate((float) 1.2);
		System.out.println(answer);
		int degree = obj.degree();
		System.out.println(degree);
		Poly obj3 = addPoly(obj , obj1);
		System.out.println("length "+ obj3.power.length);
		for( int i = 0; i < obj3.cofficient.length ; i++)
		{
			System.out.println(obj3.power[i]);
		}
		for( int i = 0; i < obj3.cofficient.length ; i++)
		{
			System.out.println(obj3.cofficient[i]);
		}

	}

}
