package order;

import java.io.*;
import java.util.*;

import IO.IObasic;
import project.Database;
import project.Validate.ValidateCap;
import project.Validate.ValidateQuantity;
import project.Validate.Validator;

public class PlacedOrder {
	IObasic inputOutput = new IObasic();
	String carddetails = "";
	public void generateBill(String outputpath, Database s) throws IOException{
        
        ArrayList<String> inputfile = new ArrayList<>();
        this.inputOutput.readOrderpath(outputpath);
        inputfile = this.inputOutput.getFileData();
        Double totalOrder = 0.0;
        StringBuilder sb = new StringBuilder();
        Validator quantity = new ValidateQuantity();
        Validator stock = new ValidateCap();
        
        quantity.next(stock);
        
        HashMap<String, Integer> BillOrder = new HashMap<String, Integer>();
        for (int i = 0; i < inputfile.size(); i++) {
        	String data = inputfile.get(i);
        	String[] line_data = data.split(",");
        	String item = line_data[0];
            Integer orderQuantity = Integer.parseInt(line_data[1]);
            if(carddetails == "") {
            	carddetails = line_data[2];
            }
            BillOrder.put(item, orderQuantity);
        }
        String finalOutput="";
        boolean goodTogo = true;
        ArrayList<String> ans1 = new ArrayList<String>();
        ArrayList<String> ans2 = new ArrayList<String>();
        ans1 = quantity.validate(BillOrder, s);
        ans2 = stock.validate(BillOrder, s);
        if(ans1.size()!=0){
            finalOutput = "Quantity more than the storage amount. Please reduce the quantity for \n";
            for (String num : ans1) { 	
                finalOutput += num + "\n"; 		
           }
            goodTogo = false;
        }else if(ans2.size()!=0){
            finalOutput = "Quantity more than the cap amount. Please reduce quantity for \n";
            for (String num : ans2) { 	
                finalOutput += num + "\n"; 		
           }
            goodTogo = false;
        }
        
        if(!goodTogo) {
        	inputOutput.writeFinal(finalOutput, false, outputpath, BillOrder);
        }
        else {
        	HashSet<String> mp = s.getCardData();
        	Iterator<String> it_card = mp.iterator();
        	boolean hasCard = false;
        	while(it_card.hasNext()) {
        		if(it_card.next() == carddetails) {
        			hasCard = true;
        			break;
        		}
        	}
        	if(!hasCard) {
        		s.AddCard(carddetails);
        	}
        	Iterator it_bill = BillOrder.entrySet().iterator();
        	for (Map.Entry<String,Integer> entry : BillOrder.entrySet()) {
                //System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
        	}
    		while(it_bill.hasNext()) {
    			HashMap.Entry pair = (HashMap.Entry)it_bill.next();
    	        Integer val = (Integer)pair.getValue();
    	        Double price = s.getItemData().get(pair.getKey()).getPrice();
    	        totalOrder += val*price;
    	        s.getItemData().get(pair.getKey()).updateQuantity(val);
    		}
    		finalOutput = "Thanks for Shopping this is your bill = " + totalOrder;
    		inputOutput.writeFinal(finalOutput, true, outputpath, BillOrder);
        }
        
        
    }
	
	
	
}