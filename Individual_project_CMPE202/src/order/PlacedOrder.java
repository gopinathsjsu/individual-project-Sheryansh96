package order;

import java.io.*;
import java.util.*;

import IO.IObasic;
import project.Database;
import project.Validate.ValidateCap;
import project.Validate.ValidateItem;
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
        Validator things = new ValidateItem();
        Validator quantity = new ValidateQuantity();
        Validator stock = new ValidateCap();
        
        things.next(quantity);
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
        HashMap<String,ArrayList<String>> ans1 = new HashMap<String,ArrayList<String>> ();
        ArrayList<String> ans2 = new ArrayList<String>();
        ans1 = things.validate(BillOrder, s);
        Iterator it_ans1 = ans1.entrySet().iterator();
        HashMap.Entry pair_ans1 = (HashMap.Entry)it_ans1.next();
        String s1 = (String) pair_ans1.getKey();
        ans2 = (ArrayList<String>) pair_ans1.getValue();
        if(ans2.size()!=0){
        	if(s1 == "1") {
        		finalOutput = "Following items don't exist \n";
	            for (String num : ans2) { 	
	                finalOutput += num + "\n"; 		
	            }
	            goodTogo = false;
        	}
        	else if(s1 == "2") {
        		finalOutput = "Quantity more than the storage amount. Please reduce the quantity for \n";
	            for (String num : ans2) { 	
	                finalOutput += num + "\n"; 		
	            }
	            goodTogo = false;
        	}
	        else{
	            finalOutput = "Quantity more than the cap amount. Please reduce quantity for \n";
	            for (String num : ans2) { 	
	                finalOutput += num + "\n"; 		
	           }
	            goodTogo = false;
	        }
        }
        
        if(!goodTogo) {
        	inputOutput.writeFinal(finalOutput, false, outputpath, BillOrder);
        }
        else {
        	HashSet<String> mp = s.getCardData();
        	Iterator<String> it_card = mp.iterator();
        	boolean hasCard = false;
        	while(it_card.hasNext()) {
        		String x = it_card.next();
        		if(x.equals(carddetails)) {
        			hasCard = true;
        			break;
        		}
        	}
        	if(!hasCard) {
        		System.out.println("New Card Added");
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
