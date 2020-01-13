import java.util.*;
public class Item{
	//Using LinkedHashMap to store item_name and their price
	private LinkedHashMap<String,Integer> item = new LinkedHashMap<String,Integer>();
	//Array of item_name
	String[] itemName={"Pizza","Bread","Toast","Pepsi","Paneer","Milk","Butter"};
	//Array of Price of correspondence item
	int[] price={80,30,40,60,120,20,45};

	//Default Constructor of Item class
	Item(){    
		for(int i=0;i<itemName.length;i++)
			//Enter the item_name and their price in LinkedHashMap
			item.put(itemName[i], new Integer(price[i])); 
	}

	public LinkedHashMap<String, Integer> getItems() {
		//Return the item LinkedHashMap
		return item;
	}

	void display(){ 
		//it'll display the items
		int i=1;
		System.out.println("\n----------------------Items Menu------------------------");
		System.out.println("ID\t\tItem\t\tPrice");
		for (Map.Entry< String,Integer> me:item.entrySet()) 
		{ 
			System.out.println(i+".\t\t"+me.getKey()+"\t\t"+me.getValue()); 
			i++;
		}
	}
}