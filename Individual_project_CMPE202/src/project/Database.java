package project;

import java.util.HashMap;
import java.util.*;

public class Database {
	private static Database obj;
	HashMap<String, Item> storageItem = new HashMap<String, Item>();
	HashSet<String> storageCard = new HashSet<String>();
	HashSet<String> things = new HashSet<String>();
	HashMap<String, Integer> categoryLimit = new HashMap<String, Integer>();
	private Database() {
		
	}
	public static Database getInstance() {
		if (obj==null){
			obj = new Database();
        }
        return obj;
	}
	
	void createItemDatabase() {
		storageItem.put("Clothes",new Item("Essentials", 100, 30));
		storageItem.put("Soap", new Item("Essentials", 200, 5));
		storageItem.put("Shampoo", new Item("Essentials", 200, 10));
		storageItem.put("Milk", new Item("Essentials", 100, 5));
		storageItem.put("Perfume", new Item("Luxury", 50, 50));
		storageItem.put("Chocolates", new Item("Luxury", 300, 3));
		storageItem.put("Handbag", new Item("Luxury", 75, 150));
		storageItem.put("Wallet", new Item("Luxury", 100, 100));
		storageItem.put("Bedsheet", new Item("Misc", 150, 75));
		storageItem.put("Footware", new Item("Misc", 200, 25));
		storageItem.put("HomeDecorPiece", new Item("Misc", 100, 40));
		storageItem.put("pen", new Item("Misc", 400, 3));
		storageItem.put("pencil", new Item("Misc", 400, 3));
	}
	
	void createCardDatabase(){
		storageCard.add("5410000000000000");
		storageCard.add("4120000000000");
		storageCard.add("341000000000000");
		storageCard.add("6010000000000000");
	}
	
	void setcategoryLimit() {
		categoryLimit.put("Essentials", 3);
		categoryLimit.put("Luxury", 4);
		categoryLimit.put("Misc", 6);
	}
	
	void setThings() {
		things.add("Clothes");
		things.add("Soap");
		things.add("Shampoo");
		things.add("Milk");
		things.add("Perfume");
		things.add("Chocolates");
		things.add("Handbag");
		things.add("Wallet");
		things.add("Bedsheet");
		things.add("Footware");
		things.add("HomeDecorPiece");
		things.add("pen");
		things.add("pencil");
	}
	
	
	public HashMap<String, Item> getItemData() {
		return storageItem;
	}
	
	public HashSet<String> getCardData(){
		return storageCard;
	}
	
	public HashSet<String> getThings(){
		return things;
	}
	
	public void AddCard(String S) {
		storageCard.add(S);
	}
	
	public Integer getCategoryLimit(String s){
		return categoryLimit.get(s);
	}
}
