package client;
import java.io.*;
import controller.ShoppingCartController;

public class Client {

	public static void main(String[] args)throws IOException 
	{
		ShoppingCartController control=new ShoppingCartController();
		control.inputChoice();
	}
}
