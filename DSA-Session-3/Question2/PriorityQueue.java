package Session3.PriorityQueue;

import java.util.Scanner;

public class PriorityQueue {

	static int [] intArray = new int[50];
	static int itemCount;

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the no. of values you want to enter in the queue : ");
		int number = input.nextInt();
		while(number >= 1)
		{
			System.out.println("Enter the data : ");
			int data = input.nextInt();
			insert(data);
			number--;
		}
		removeDataOfLowPriority();
		show();
	}


	public static void show()
	{
		for(int i = 0; i < itemCount ; i++)
		{
			System.out.print(intArray[i] + "  ");
		}
	}
	
	public static int peek(){
		return intArray[itemCount - 1];
	}

	public static boolean isEmpty(){
		return itemCount == 0;
	}

	public static boolean isFull(){
		return itemCount == 50;
	}

	public static int size(){
		return itemCount;
	}  

	public static void insert(int data)
	{
		int i = 0;
		if(!isFull())
		{
			if(itemCount == 0)
			{
				intArray[itemCount++] = data;        
			}
			else
			{
				for(i = itemCount - 1; i >= 0; i-- )
				{
					if(data > intArray[i])
					{
						intArray[i+1] = intArray[i];
					}
					else
					{
						break;
					}            
				}  
				intArray[i+1] = data;
				itemCount++;
			}
		}
	}

	public static int removeDataOfLowPriority(){
		return intArray[--itemCount]; 
	}


}
