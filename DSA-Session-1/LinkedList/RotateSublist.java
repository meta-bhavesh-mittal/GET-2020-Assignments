package LinkedList;

import java.util.Scanner;

/**
 * This class is used to create a singly linked list.
 * in which there is a function which is used to rotate a sublist by some given parameters.  
 * @author Bhavesh
 *
 */
public class RotateSublist 
{
	static Node header = null;
	/**
	 * This is the main function of the program. 
	 * @param args
	 */
	public static void main(String[] args)
	{
		RotateSublist list = new RotateSublist();
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
		System.out.println("Enter the left position : ");
		int left = input.nextInt();
		System.out.println("Enter the rigth position : ");
		int right = input.nextInt();
		System.out.println("Enter the number of rotation  : ");
		int step = input.nextInt();
		System.out.println("After Rotation the linked list is as follows : ");
		list.rotateSubList(header,left, right, step);

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
	 * This function is used to rotate the sublist of a linked list with some given parameters.
	 * @param header This is the header which point the starting node the linked list.
	 * @param l This is the the position from where the sublist starts.
	 * @param r This is the the position from where the sublist ends.
	 * @param k This is the no. of rotation which we have to do in the sublist.
	 */
	public static void rotateSubList(Node header, int l, int r, int k) 
	{ 
		int size = r - l + 1; 
		if (k > size) { 
			k = k % size; 
		}  
		if (k == 0 || k == size) { 
			Node head = header; 
			while (head != null) {  
				System.out.print( head.data + "--->"); 
				head = head.next;  
			} 
			return; 
		} 

		Node link = null;  
		if (l == 1) { 
			link = header; 
		} 

		Node curr = header; 
		int count = 0;  
		Node end = null; 
		Node pre = null; 
		while (curr != null) { 
			count++; 
			if (count == l - 1) { 
				pre = curr; 
				link = curr.next; 
			} 
			if (count == r - k) { 
				if (l == 1) { 
					end = curr; 
					header = curr.next; 
				} 
				else { 
					end = curr; 
					pre.next = curr.next; 
				} 
			} 

			if (count == r) { 
				Node temp = curr.next; 
				curr.next = link; 
				end.next = temp; 
				Node head = header; 
				while (head != null) { 
					System.out.print( head.data+"--->"); 
					head = head.next; 
				} 
				return; 
			} 
			curr = curr.next; 
		} 
	} 

}
