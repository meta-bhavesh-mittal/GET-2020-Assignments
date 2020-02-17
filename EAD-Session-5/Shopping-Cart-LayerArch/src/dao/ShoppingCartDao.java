package dao;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ShoppingCartDao {
	
	private List<Product> products;
	
	public ShoppingCartDao()
	{
		products=new ArrayList<Product>();
		Product product1=new Product(123,"Furniture","chair",200,0);
		products.add(product1);
		Product product2=new Product(124,"Furniture","table",500,0);
		products.add(product2);
		Product product3=new Product(125,"Furniture","bed",1000,0);
		products.add(product3);
	}
	
	public void addProduct(Product product)
	{
		int flag=0;
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getName().equals(product.getName()))
			{
				flag=1;
				products.get(i).setQuantity(products.get(i).getQuantity()+product.getQuantity());
				break;
			}
		}
		if(flag==0)
			products.add(product);
	}
	
	public void removeProduct(Product product)
	{
		int flag=0;
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getName().equals(product.getName())&&products.get(i).getQuantity()>0)
			{
				flag=1;
				products.get(i).setQuantity(products.get(i).getQuantity()-product.getQuantity());
				break;
			}
		}
		if(flag==0)
			products.remove(product);
	}
	
	public List<Product> sendCart()
	{
		return products;
	}
	
}
