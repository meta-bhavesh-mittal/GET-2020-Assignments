package com.metacube.Inventory_WebApp.resources;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.Inventory_WebApp.pojo.Inventory;
import com.metacube.Inventory_WebApp.repositories.InventoryRepository;

@Path("inventory")
public class InventoryResource {

	private static InventoryRepository repo = new InventoryRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Inventory> getInventories() {
		System.out.println("getInventories called.");
		
		return repo.getInventories();
	}	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Inventory create(Inventory i1) {
		System.out.println("inventory called.");
		return repo.addInventory(i1);
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Inventory> deleteInventories() {
		return repo.deleteInventories();
	}
	
	@DELETE
	@Path("{inventoryName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Inventory deleteInventory(@PathParam("inventoryName") String inventoryName){
		System.out.println(inventoryName);
		return repo.deleteInventory(inventoryName);
		
	}
	
	@PUT
	@Path("{inventoryName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Inventory updateInventory(@PathParam("inventoryName") String inventoryName, Inventory inv) {
		return repo.updateInventory(inventoryName, inv);
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Inventory> updateInventories(List<Inventory> inventories) {
		return repo.updateInventories(inventories);
	}
	
}