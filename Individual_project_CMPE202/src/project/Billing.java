package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import IO.IObasic;
import order.PlacedOrder;

public class Billing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Billing obj = new Billing();
        //obj.start();
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		
        Database db = Database.getInstance();
		db.createCardDatabase();
		db.createItemDatabase();
		db.setcategoryLimit();
		db.setThings();
		
		IObasic inputOutput = new IObasic();
		
		System.out.println("\nPlease enter File Path of Order File: ");
		
	    String order_path = buffReader.readLine();
	    //inputOutput.readOrderpath(order_path);
	    
	    PlacedOrder order = new PlacedOrder();
        order.generateBill(order_path, db);
	}

}
