import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * This class is used to perform various operations on set.
 * @author Bhavesh
 *
 */
public final class IntSet 
{
	private final static int size =1000;
	private static final int[] universalSet = new int[size];
	private final int set[];
	static
	{
		for(int i = 0; i < universalSet.length ; i++)
		{
			universalSet[i] =i+1;
		}
	}
	/**
	 * This is the constructor of IntSet Class.
	 * @param inputSet
	 */
	public IntSet(int[] inputSet)
	{
		if(inputSet.length == 0)
		{
			System.out.println("Array is empty.");
		}
		set = inputSet;
	}
 
	/**
	 * This method is used to find that a particular element is part of particular set or not.
	 * @param element
	 * @return It returns the boolean value.
	 */
	public boolean isMember(int element)
	{
		for(int i = 0;i < set.length; i++)
		{
			if(set[i] == element)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used to calculate the size of set.
	 * @return
	 */
	int size()
	{
		int count = set.length;
		return count;
	}

	/**
	 * This method is used to find that a particular set is subset of another set or not.
	 * @param subSet
	 * @return it returns the boolean value.
	 */
	boolean isSubset(IntSet subSet) 
	{
		int value = 0;
		for (int count = 0; count < subSet.set.length; count++)
		{
			if (isMember(subSet.set[count]))
			{
				value++;
			}
		}
		if (value == subSet.set.length)
		{
			return true;
		}
		return false;
	} 

	/**
	 * This method is used to find the complement of a set from universal set.
	 * @return it returns an array.
	 */
	public int[] getComplement()
	{
		int sizeComp = universalSet.length - set.length;
		int [] compArray = new int[sizeComp];
		int count=-1;
		boolean flag = false;
		for(int i = 0;(i < universalSet.length) ;i++)
		{
			flag=false;
			for( int j = 0;j < set.length; j++)
			{
				if(universalSet[i] != set[j])
				{
					flag = true;
				}
				else
				{
					flag= false;
					break;
				}

			}
			if(flag)
			{
				compArray[++count] = universalSet[i];
			}
		}
		return compArray;
	}

	/**
	 * This method is used to calculate the union of two sets.
	 * @param set1
	 * @param set2
	 * @return it returs the union set.
	 */
	public int [] union(IntSet set1, IntSet set2) 
	{
		int set1Length = set1.set.length;
		int set2Length = set2.set.length;
		int unionLength = set1Length + set2Length;
		int[] unionArray = new int [unionLength];
		int indexUnionArray = 0;
		int num1 = 0;
		int noOfCommon = 0;
		for(int i = 0 ; i < set2Length; i++)
		{
			num1 = set2.set[i];
			if(this.isMember(num1) == false)
			{
				unionArray[indexUnionArray]=num1;
				indexUnionArray++;
			}
			else 
			{
				noOfCommon++;
			}
		}

		for(int i = 0;i < this.size();i++)
		{
			unionArray[indexUnionArray] = this.set[i];
			indexUnionArray++;
		}

		int unionLengthWOC = unionLength - noOfCommon;
		int unionArray1[]  = new int [unionLengthWOC];
		for(int i =0; i < unionLengthWOC; i++ )
		{
			unionArray1[i] = unionArray[i];
		}
		Arrays.sort(unionArray1);
		return  unionArray1;
	}

	public static void main(String[] args)
	{
		IntSet obj1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,15,17,19});
		IntSet obj2 = new IntSet(new int[]{1,2,3});
		boolean resultIsMember = obj1.isMember(6);
		int resultSize = obj1.size();
		boolean resultIsSubset = obj1.isSubset(obj2);
		int [] resultComp = obj1.getComplement();
		int [] resultUnion = obj1.union(obj1 , obj2);
		System.out.println(resultIsSubset);
		System.out.println(resultIsMember);
		System.out.println(resultSize);
		for(int i = 0; i<resultComp.length ;i++)
		{
			System.out.println(resultComp[i]);	
		}

		for(int i = 0; i<resultUnion.length ;i++)
		{
			System.out.println(resultUnion[i]);	
		}
	}

}
