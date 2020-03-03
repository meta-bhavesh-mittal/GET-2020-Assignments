package facade;
import dao.*;
import java.util.*;
import model.*;

public class CartFacade {

		List<Product> productList=new ArrayList<Product>();
		ShoppingCartDao cart=new ShoppingCartDao();
		public List<Product> ProductListFacade()
		{
			ProductDao productdao=new ProductDao();
			productList=productdao.ProductList();
			return productList;
		}
		
		public void addProductFacade(Product product)
		{
			
			cart.addProduct(product);
		}
		
		public void removeProductFacade(Product product)
		{
			cart.removeProduct(product);
		}
		
		public List<Product> viewCart()
		{
			List<Product> products=new ArrayList<Product>();
			products=cart.sendCart();
			return products;
		}
		
		public int bill()
		{
			List<Product> billProducts=new ArrayList<Product>();
			billProducts=viewCart();
			int bill=0;
			for(int i=0;i<billProducts.size();i++)
			{
				bill+=billProducts.get(i).getQuantity()*billProducts.get(i).getPrice();
			}
			return bill;
		}
		
}

