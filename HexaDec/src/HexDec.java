import java.util.Scanner;


public class HexDec {
	
	//method to convert hexadecimal to decimal
	public static int hexToDec(String hex)
	{
		int dec = Integer.parseInt(hex,16);
		return dec;

	}
	
	
	// method to convert decimal to hexadecimal
	public static String decToHex(int dec)
	{
		String hex = Integer.toHexString(dec);
		return hex;

	}

	public static void main(String[] args)
	{

		try
		{

			Scanner input=new Scanner(System.in);

			System.out.println("Please Enter Two Strings On which you want to do airthmatic operations\n");
			
			// scan the two hex string from user
			String hex1 = input.nextLine();
			String hex2 = input.nextLine();

			int dec1 = hexToDec(hex1);
			int dec2 = hexToDec(hex2);


			System.out.println("Choose the appropiate Option\n");
			System.out.println("1.  Add Two HexaDecimal Numbers\n");
			System.out.println("2.  Subtract Two HexaDecimal Numbers\n");
			System.out.println("3.  Multiply Two HexaDecimal Numbers\n");
			System.out.println("4.  Divide Two HexaDecimal Numbers\n");
			System.out.println("5.  Convert HexaDecimal Numbers to Decimal Numbers\n");
			System.out.println("6.  Convert Decimal NUmbers to HexaDecimal Numbers\n");
			System.out.println("7.  Compare these two hexaDecimal Numbers\n");

			int choice = input.nextInt();

			switch(choice)
			{
			case 1:	// add the two hexadecimal numbers

				int a = dec1 + dec2;
				String hexAdd= decToHex(a);

				System.out.println(hexAdd);
				break;


			case 2:	// subtract the two hexadecimal numbers
				int b = dec1 - dec2;
				String hexSub = decToHex(Math.abs(b));
				System.out.println(hexSub);
				break;

			case 3:   // multiply the two hexadecimal numbers
				int c = dec1 * dec2;
				String hexMul = decToHex(c);
				System.out.println(hexMul);
				break;


			case 4:		// divide the two hexadecimal numbers
				int d = dec1 / dec2;
				int rem = dec1 - (d*dec2);
				String hexDiv = decToHex(d);
				String hexRem = decToHex(rem);
				System.out.println("the quotient will be :  "+hexDiv);
				System.out.println("the remainder will be :  "+hexRem);
				break;

			case 5:	 // convert hexadecimal to decimal
				System.out.println("The Decimal representation of given numbers is :\t "+dec1+"\t\t"+dec2);
				break;


			case 6:  // convert decimal to hexadecimal
				System.out.println("Enter Any Decimal Value");
				int decVal = input.nextInt();
				String f = decToHex(decVal);
				System.out.println(f);
				break;


			case 7: // compare the two hex string
				int compare = hex1.compareTo(hex2);
				if(hex1.length() == hex2.length())
				{
					if(compare == 0)
					{
						System.out.println("The two HexaDecimal Numbers are equal");
					}
					else if(compare < 0) 
					{
						System.out.println("The first string is lesser than second");
					}
					else
					{
						System.out.println("the second string is lesser than first");
					}
				}
				else if(hex1.length() > hex2.length())
				{
					System.out.println("They first string is greater than second");
				}
				else
				{
					System.out.println("the second string is greater than first");
				}
				break;

			default:
				System.out.println("Plaese Enter the valid choice\n");

			}
		}
		catch(Exception ex)
		{
			System.out.println("Please enter only valid hexadecimal in number ");
		}

	}
}
