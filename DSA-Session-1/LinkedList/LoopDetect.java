package LinkedList;

import java.util.Scanner;

/**
 * THis class is used to create a singly linked list.
 * which has a function to detect the loop in the linked list.
 * @author Bhavesh
 *
 */
public class LoopDetect {

	static Node header = null;
	/**
	 * This is the main function of the program. 
	 * @param args
	 */
	public static void main(String[] args)
	{
		LoopDetect list = new LoopDetect();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of nodes which you want to enter in the list");
		int num = input.nextInt();
		int i = 0;
		while(i < num)
		{
			System.out.println("Enter the value of the node :");
			int value = input.nextInt();
			list.insertLast(value);
			i++;
		}
		System.out.println("The list is as follows : ");
		list.show();
		System.out.println();
		boolean result = list.isLoopExist();
		if(result)
		{
			System.out.println("LOOP EXISTS IN THIS LIST");
		}
		else
		{
			System.out.println("LOOP DOESN'T EXISTS IN THIS LIST");
		}
		
		
		LoopDetect list1 = new LoopDetect();
		System.out.println("Enter the number of nodes which you want to enter in the list");
		int num1 = input.nextInt();
		int j = 0;
		while(j < num1)
		{
			System.out.println("Enter the value of the node :");
			int value = input.nextInt();
			list1.insertLast(value);
			j++;
		}
		System.out.println("After adding the loop node in the linked list.");
		// This is the loop node in the list.
		list1.header.next.next.next.next = list1.header.next;
		boolean result1 = list1.isLoopExist();
		if(result1)
		{
			System.out.println("LOOP EXISTS IN THIS LIST-1");
		}
		else
		{
			System.out.println("LOOP DOESN'T EXISTS IN THIS LIST-1");
		}
		

	}

	/**
	 * This function is used to insert the item at last of the list.
	 * @param data
	 */
	public static void insertLast(int data)
	{
		Node temp = new Node();
		temp.data = data;
		temp.next = null;
		if(header == null)
		{
			header = temp;
		}
		else
		{
			Node current = header;
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = temp;
		}
	}

	/**
	 * This function is used to print the linked list.
	 */
	public static void show()
	{
		Node current = header;
		while(current != null)
		{
			System.out.print(current.data + "--->");
			current = current.next;
		}
	}

	/**
	 * This function is used to detect the loop in the linked list.
	 * @return it returns the boolean value true if loop present and false if loop absent. 
	 */
	public static boolean isLoopExist()
	{
		Node fastPtr = header;
		Node slowPtr = header;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr)
				return true;

		}
		return false;

	}

}
