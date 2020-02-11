package com.metacube.Inventory_WebApp.repositories;

import java.util.ArrayList;
import java.util.List;

import com.metacube.Inventory_WebApp.pojo.Inventory;

public class InventoryRepository {
	
	private List<Inventory> inventories;
	
	public InventoryRepository() {
		inventories = new ArrayList<Inventory>();
		
		Inventory a1 = new Inventory();
		a1.setName("Apples");
		a1.setQuantity(5);
		
		Inventory a2 = new Inventory();
		a2.setName("Grapes");
		a2.setQuantity(2);
		
		Inventory a3 = new Inventory();
		a3.setName("Banana");
		a3.setQuantity(32);
		
		inventories.add(a1);
		inventories.add(a2);
		inventories.add(a3);
		
	}
	
	public List<Inventory> getInventories() {
		return inventories;
	}
	
	public Inventory getInventory(String name) {
		for (Inventory i : inventories) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return new Inventory();
	}
	
	private int isInventoryExist(Inventory i1) {
		int numberOfInventories = inventories.size();
		for (int index = 0; index < numberOfInventories; index++) {
			if (inventories.get(index).getName().equals(i1.getName())) {
				return index;
			}
		}
		return -1;
	}
	
	public Inventory addInventory(Inventory i1) {
		int index = isInventoryExist(i1);
		if (index == -1) {
			inventories.add(i1);
			return i1;
		}
		Inventory currentInventory = inventories.get(index);
		int currentQuantity = currentInventory.getQuantity();
		int newQuantity = i1.getQuantity();
		currentInventory.setQuantity(currentQuantity + newQuantity);
		return currentInventory;
	}
	
	public List<Inventory> deleteInventories() {
		inventories.clear();
		return inventories;
	}

	public Inventory deleteInventory(String inventoryName) {
		Inventory i1 = new Inventory();
		i1.setName(inventoryName);
		int index = isInventoryExist(i1);
		if (index == -1) {
			System.out.println("InventoryNotFound.");
			return new Inventory();
		}
		inventories.remove(index);
		return i1;
	}
	
	public Inventory updateInventory(String inventoryName, Inventory i1) {
		Inventory tempInventory = new Inventory();
		tempInventory.setName(inventoryName);
		int index = isInventoryExist(tempInventory);
		if (index == -1) {
			return new Inventory();
		}
		inventories.set(index, i1);
		return inventories.get(index);
	}
	
	public List<Inventory> updateInventories(List<Inventory> newInventories) {
		inventories = newInventories;
		return inventories;
	}
}