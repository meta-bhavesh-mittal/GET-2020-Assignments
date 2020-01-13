import java.util.Scanner;
import java.util.InputMismatchException;

public class Home {
	public static void main(String[] args) {
		Item item = new Item();//It'll create the object of Item class
		Cart cart = new Cart();//It'll create the object of Cart class
		Scanner sc = new Scanner(System.in);
		int input=0;
		item.display();//Call the display() method of Item class

		do{
			System.out.println("\nSelect options:");
			System.out.println("1. Add Item in your cart");
			System.out.println("2. Update the Quantity of a Item in your cart");
			System.out.println("3. Delete Item from your cart");
			System.out.println("4. Display your Cart");
			System.out.println("5. Generate Bill");
			System.out.println("6. Exit");
			/*
			 * Using try catch block to handle exception
			 * it'll catch the wrong input type exception
			 * it'll help in not terminating the program incorrectly
			 */
			try{
				input = sc.nextInt();//it take the input from use to choose options
				switch (input) {
				case 1:
					//Add the products in Cart
					item.display();//Call the display() method of Item class
					cart.addProduct();//Call the addProduct() method of Cart class
					break;
				case 2:
					//Remove items from Cart
					if(cart.showCart())//It'll check the cart is empty or not
						cart.editQuantity();//Call the removeProduct() method of Cart class
					break;
				case 3:
					//Remove items from Cart
					if(cart.showCart())//It'll check the cart is empty or not
						cart.removeProduct();//Call the removeProduct() method of Cart class
					break;
				case 4:
					//Show the items of the Cart
					cart.showCart();//Call the showCart() method of Cart class
					break;
				case 5:
					//Generate the bill
					cart.generateBill();//Call the generateBill() method of Cart class
					break;
				case 6:
					System.exit(0);//Exit from the Current Execution
					break;
				default:
					//default message on choosing wrong choice
					System.out.println("Invalid choice. Please enter again !");
					break;
				}
			}
			catch(InputMismatchException e){
				//handle the exception on wrong type of data
				//Prints a message on entering wrong type of data
				System.out.println("You Have Entered Wrong Type of Data");
				sc.nextLine();
			}
		}while (input != 6);//end of loop on choosing exit option
		sc.close();//close the Scanner Resource
	}
}