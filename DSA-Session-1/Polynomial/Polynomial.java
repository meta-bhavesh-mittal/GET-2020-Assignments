package Polynomial;

import java.util.Scanner;

/**
 * This class is used to visualize the multivariate polynomial by using linked list.
 * which has a function to calculate degree of any polynomial.
 * @author Bhavesh
 *
 */
public class Polynomial {
	
	static Node header = null;
	
	/**
	 * This is the main function of this class.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Polynomial poly = new Polynomial();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of terms which you want to enter in the polynomial list");
		int num = input.nextInt();
		int i = 1;
		while(i <= num)
		{
			System.out.println("Enter the value of the coefficient " + i + " :");
			int coeff = input.nextInt();
			System.out.println("Enter the value of the variable " + i + " :");
			String var = input.next();
			System.out.println("Enter the value of the exponent " + i + " :");
			int exp = input.nextInt();
			poly.insert(coeff, var, exp);
			i++;
		}
		System.out.println("The list is as follows : ");
		poly.show();
		System.out.println();
		int deg = poly.degree();
		System.out.println("The Degree of this polynomial is : " + deg);

	}
	
	/**
	 * This function is used to add the terms in the polynomial linked list.
	 * @param coeff This represents the coefficient of any polynomial term. 
	 * @param var This represents the variable of any polynomial term.
	 * @param exp This represents the exponent of any polynomial term.
	 */
	public static void insert(int coeff , String var , int exp)
	{
		Node temp = new Node();
		temp.coeff = coeff;
		temp.exp = exp;
		temp.var = var;
		temp.next = null;
		if(header == null)
		{
			header = temp;
		}
		else
		{
			Node curr = header;
			while(curr.next != null)
			{
				curr = curr.next;
			}
			curr.next = temp;
		}
	}

	/**
	 * This function is used to print the polynomial linked list.
	 */
	public static void show()
	{
		Node curr = header;
		while(curr.next != null)
		{
			System.out.print(curr.coeff + curr.var + "^" + curr.exp + " + ");
			curr = curr.next;
		}
		System.out.print(curr.coeff + curr.var + "^" + curr.exp );
	}
	
	/**
	 * This function is used to calculate the degree of the polynomial.
	 * @return It returns an integer value which is the maximum exponent in any term of a polynomial.
	 */
	public static int degree()
	{
		Node curr = header;
		int deg = -1;
		while(curr != null)
		{
			if(curr.exp > deg)
			{
				deg = curr.exp;
			}
			curr = curr.next;
		}
		return deg;
		
	}

}
