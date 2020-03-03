package controller;

import java.io.*;
import view.*;
import model.*;
import facade.*;
import java.util.*;

public class ShoppingCartController {

	public void inputChoice() throws NumberFormatException, IOException {
		
		int choice,choice2,quantity1,quantity3,quantity5,flag2;
		List<Product> allProductsFacade=new ArrayList<Product>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		CartFacade facade2=new CartFacade();
		
		
		for(int j=1;j>0;j++)
		{
			flag2=0;
			MenuView menu=new MenuView();
			menu.displayMenu();
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:CartFacade facade=new CartFacade();
				allProductsFacade=facade.ProductListFacade(); 
				Products allproducts=new Products();
				allproducts.displayProducts(allProductsFacade);
				break;
				case 2:
				MenuView itemMenu=new MenuView();
				itemMenu.itemMenu();
				choice2=Integer.parseInt(br.readLine());
				switch(choice2)
				{
					case 0:MenuView quantity=new MenuView();
						quantity.askQuantity();
						quantity1=Integer.parseInt(br.readLine());
						Product product =new Product(123,"Furniture","chair",200,quantity1);
						facade2.addProductFacade(product);
						break;
					case 1:MenuView quantity2=new MenuView();
						quantity2.askQuantity();
						quantity3=Integer.parseInt(br.readLine());
						Product product2 =new Product(124,"Furniture","table",500,quantity3);
						facade2.addProductFacade(product2);
						break;
					case 2:MenuView quantity4=new MenuView();
						quantity4.askQuantity();
						quantity5=Integer.parseInt(br.readLine());
						Product product3 =new Product(125,"Furniture","bed",1000,quantity5);
						facade2.addProductFacade(product3);
						break;
				}
				break;
			case 3:
				for(int k=0;k<facade2.viewCart().size();k++)
				{
					if(facade2.viewCart().get(k).getQuantity()>0)
						flag2=1;
				}
				if(flag2==1){
				MenuView itemMenu1=new MenuView();
				itemMenu1.itemMenu();
				choice2=Integer.parseInt(br.readLine());
				switch(choice2)
				{
					case 0:if(facade2.viewCart().get(0).getQuantity()>0){
						MenuView quantity=new MenuView();
						quantity.askQuantity();
						quantity1=Integer.parseInt(br.readLine());
						Product product =new Product(123,"Furniture","chair",200,quantity1);
						facade2.removeProductFacade(product);
					}
					else{
						ShoppingCartView error=new ShoppingCartView();
						error.displayError();
					}
						break;
					case 1:if(facade2.viewCart().get(1).getQuantity()>0){
						MenuView quantity2=new MenuView();
						quantity2.askQuantity();
						quantity3=Integer.parseInt(br.readLine());
						Product product2 =new Product(124,"Furniture","table",500,quantity3);
						facade2.removeProductFacade(product2);
						break;
					}
					else{
						ShoppingCartView error=new ShoppingCartView();
						error.displayError();
					}
					case 2:if(facade2.viewCart().get(2).getQuantity()>0){
						MenuView quantity4=new MenuView();
						quantity4.askQuantity();
						quantity5=Integer.parseInt(br.readLine());
						Product product3 =new Product(125,"Furniture","bed",1000,quantity5);
						facade2.removeProductFacade(product3);
						break;
					}
					else{
						ShoppingCartView error=new ShoppingCartView();
						error.displayError();
					}
				}
				break;
				}
				else{
					ShoppingCartView error=new ShoppingCartView();
					error.displayError();
				}
			case 4:
				List<Product> cartProducts=new ArrayList<Product>();
				cartProducts=facade2.viewCart();
				ShoppingCartView view=new ShoppingCartView();
				view.displayShoppingCart(cartProducts);
				break;
			case 5:
				int bill=facade2.bill();
				ShoppingCartView billView=new ShoppingCartView();
				billView.displayBill(bill);				
				break;
			case 6:j=-1;
				break;
			default:
		}
	}	
}
}
	
	
