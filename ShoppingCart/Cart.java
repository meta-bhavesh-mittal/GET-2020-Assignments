import java.util.*;
import java.util.InputMismatchException;
public class Cart {
	//Using LinkedHashMap to store item_name and their Quantity
	private LinkedHashMap<String,Integer> cart = new LinkedHashMap<String,Integer>();
	Item item=new Item();//object of Item class
	//id variable to store ID of product
	//quantity variable to store quantity of a product in cart
	int id,quantity;
	Scanner sc= new Scanner(System.in);//Object of Scanner class
	//call the getItems method of Item class
	//store all the item of Item class in items
	LinkedHashMap<String, Integer> items=item.getItems();
	//change the items name into itemList 
	//it is converted into ArrayList
	ArrayList<String>itemList=new ArrayList<String>(items.keySet());

	boolean setID(){//to set id for the process and verify it
		/*
		 * Using try catch block to handle exception
		 * it'll catch the wrong input type exception
		 * it'll help in not terminating the program incorrectly
		 */
		try{
			//take ID as input
			System.out.println("Enter product ID:");
			id = sc.nextInt();
		}
		catch(InputMismatchException e){//handle the exception
			System.out.println("Wrong Data entered");//Message on wrong data inout entered
			sc.nextLine();//to flush the buffer
			return false;//return false on wrong type of input
		}
		//check if id is negative
		//check if id is not available in item 
		if(id<1 || id> item.itemName.length){
			System.out.println("Wrong Product Id Selected");
			sc.nextLine();//to flush the buffer
			return false;//return false on wrong selection of id
		}
		return true;//return true on successful setID
	}

	boolean setQuantity(){//to set the quantity of a item
		/*
		 * Using try catch block to handle exception
		 * it'll catch the wrong input type exception
		 * it'll help in not terminating the program incorrectly
		 */
		try{
			//take quantity as input
			quantity=sc.nextInt();
		}
		catch(InputMismatchException e){//handle the exception
			System.out.println("Wrong Data entered ");//Message on wrong data inout entered
			sc.nextLine();//to flush the buffer
			return false;//return false on wrong type of input
		}
		if(quantity<0){//check if quantity is negative or not
			System.out.println("Quantity can't be negative of a Product");
			sc.nextLine();//to flush the buffer
			return false;//return false on negative quantity
		}
		return true;//return true on successfully entered quantity	
	}

	//method to add item in cart
	boolean addProduct(){
		//to check entered id is proper or not
		if(setID()){
			String value = itemList.get(id-1);//get the item name using id of item
			//check if the input item is in cart or not
			if(cart.containsKey(value)){
				int preQuantity= cart.get(value);//to get the pre-quantity of item from cart
				System.out.println("You have "+preQuantity+" quantity of "+value+" ,Enter more Quantity:");
				if(setQuantity()){//to set new quantity of product
					quantity+=preQuantity;
				}
				if(quantity>100){//check if the quantity not more than 100
					System.out.println("Max Quantity can be 100 of a Product");
					return false;//return false if quantity more than 100
				}

				cart.put(value, quantity);//save the quantity associated with item in cart
			}
			else{
				System.out.println("Enter the Quantity of "+value+" (Max Quantity 100):");
				//check the quantity is proper or not
				if(setQuantity()){
					if(quantity>100){
						System.out.println("Max Quantity can be 100 of a Product");
						return false;
					}
					cart.put(value, quantity);//save the quantity associated with item in cart 
				}
			}
		}
		return true;//return true on successful add the item in cart
	}

	//method to edit the quantity of a item in cart
	void editQuantity(){
		//to check id is proper or not
		if(setID()){
			String value = itemList.get(id-1);//get the item_name from itemlist using id
			if(!(cart.containsKey(value))){//check the cart contain the selected item or not
				System.out.println("Cart don't contain the selected item");
			}
			else{
				/*
				 * Using try catch block to handle exception
				 * it'll catch the wrong input type exception
				 * it'll help in not terminating the program incorrectly
				 */
				try{
					System.out.println("Enter the updated Quantity of item:");
					//take quantity as input
					quantity=sc.nextInt();
				}
				catch(InputMismatchException e){//handle the exception
					System.out.println("Wrong Data entered ");//Message on wrong data inout entered
					sc.nextLine();//to flush the buffer
					return;//return if wrong type of data entered
				}
				if(quantity<0){//check if quantity is negative or not
					System.out.println("Quantity can't be negative of a Product");
					sc.nextLine();//to flush the buffer
					return;//return if quantity is less than 0
				}
				if(quantity>100){
					System.out.println("Quantity can't be more than 100");
					return;//return if quantity is greater than 100
				}
				if(quantity==0){
					cart.remove(value);//remove the item from cart 
					return;
				}
				else{
					cart.put(value, quantity);//update the quantity of cart
					return;
				}
			}
		}
	}
	
	//method to remove item from cart
	void removeProduct(){
		//to check id is proper or not 
		if(setID()){
			String value = itemList.get(id-1);//get the item_name from itemlist using id
			if(!(cart.containsKey(value))){//check the cart contain the selected item or not
				System.out.println("Cart don't contain the selected item");
			}
			else{
				cart.remove(value);//remove the item from cart if it contain the selected item
				System.out.println("Succesfully Removed");
			}
		}
	}

	//method to show the cart items
	boolean showCart(){
		if(cart.isEmpty()){//check the cart is empty or not
			System.out.println("Cart is Empty, Add items in your Cart!!!");
			return false;//return false if cart is empty
		}
		else{
			System.out.println("\n----------------------Items in your cart------------------------ ");
			System.out.println("Id\t\tItems\t\tQuantity");
			for (Map.Entry< String,Integer> me:cart.entrySet())//to iterate the cart 
			{ 	
				//print the items of cart with their id and quantity
				System.out.println(itemList.indexOf(me.getKey())+1+"\t\t"+me.getKey()+"\t\t"+me.getValue());
			}
		}
		return true;
	}

	//method to generate the bill of selected item
	boolean generateBill(){
		if(cart.isEmpty()){//check that cart is empty or not
			System.out.println("Cart is Empty, To generate bill add items in your Cart!!!");
		}
		else{
			System.out.println("\n----------------------Bill------------------------ ");
			System.out.println("\nID\t\tItems\t\tQuantity\tPrice");
			int amount=0;//variable to store the final total amount of cart 
			for (Map.Entry< String,Integer> me:cart.entrySet())//to iterate the cart 
			{ 	
				String itemName=me.getKey();//to get the itemName
				int quantity=me.getValue();//to get the quantity of item
				int rate=items.get(itemName);//to get per piece rate of item
				int price= rate* quantity;//calculate the price of item using rate and quantity
				System.out.println(itemList.indexOf(me.getKey())+1+"\t\t"+itemName+"\t\t"+quantity+"\t\t"+price); 
				amount+=price;//add the every item price to get final amount
			}
			System.out.println("Total Amount:"+amount);//print the final amount of cart
		}
		return true;
	}
}