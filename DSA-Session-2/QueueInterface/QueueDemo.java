package Session2.QueueInterface;

import java.util.Scanner;

public class QueueDemo {
	
	public static void main(String args[]) {
		QueueImpl<Integer> queue = new QueueImpl<Integer>(6);
		Scanner sc = new Scanner(System.in);
		int choice = 0;   
	    while(choice != 6)   
	    {     
	        System.out.println("\n*************************Main Menu*****************************");  
	        System.out.println("1.insert an element\n2.Delete an element\n3.Display the queue\n"
	        		+ "4.Is Queue Full\n5.Is queue Empty\n6.Exit");  
	        System.out.println("\nEnter your choice ?");  
	        choice = sc.nextInt();
	        switch(choice)  
	        {  
	            case 1: System.out.println("Enter Data : ");
	            		int data = sc.nextInt();
	            		queue.enqueue(data);
	    	            break;  
	        
	            case 2:  System.out.println("Deleted : "+queue.dequeue());
		            	break;  
		           
	            case 3: System.out.println("Queue is : ");
	            		queue.display();
	            		break;
	            case 4: System.out.println(queue.isFull());
	            		break;
	            case 5: System.out.println(queue.isEmpty());
        				break;
	            case 6: sc.close();
	            		break;
	            default:   
	            	System.out.println("\nEnter valid choice??\n");  
	        }
	    }
		
	}

}
