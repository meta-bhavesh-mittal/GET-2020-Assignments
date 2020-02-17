package view;
import java.util.*;
import model.*;

public class Products {
	
	public void displayProducts(List<Product> allProductsList)
	{
		for(int i=0;i<allProductsList.size();i++)
		{
			System.out.println(allProductsList.get(i));
		}		
	}
}
