package view;
import model.*;
import java.util.*;

public class ShoppingCartView {
	
	public void displayShoppingCart(List<Product> cartProducts)
	{
		for(int i=0;i<cartProducts.size();i++)
		{
			if(cartProducts.get(i).getQuantity()>0){
			System.out.println("Item Name: "+cartProducts.get(i).getName()+"   "+"Quantity: "+cartProducts.get(i).getQuantity());
			}
			
		}
	}
	
	public void displayBill(int bill)
	{
		System.out.println("Your bill is: Rs."+bill);
	}
	
	public void displayError()
	{
		System.out.println("INVALID REMOVAL");
	}

}
