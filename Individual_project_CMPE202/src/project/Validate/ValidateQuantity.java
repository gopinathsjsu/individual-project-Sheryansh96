package project.Validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import project.Database;
import project.Item;

public class ValidateQuantity implements Validator{
	
	private Validator nextValidator = null;
	boolean hasenough = true;
	@Override
	public void next(Validator v) {
		// TODO Auto-generated method stub
		this.nextValidator = v;
		
	}
	
	@Override
	public HashMap<String,ArrayList<String>> validate(HashMap<String,Integer> h, Database s) {
		// TODO Auto-generated method stub
		//Database s = Database.getInstance();
		Iterator it = h.entrySet().iterator();
		ArrayList<String> item = new ArrayList<String>();
		HashMap<String,ArrayList<String>> mp = new HashMap<String,ArrayList<String>>();
		while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry)it.next();
	        Integer quantity = s.getItemData().get(pair.getKey()).getCurrentQuantity();
	        if(quantity < (Integer)pair.getValue()) {
	        	item.add((String) pair.getKey() + " " + String.valueOf(pair.getValue()));
	        }
		}
		if(item.size()>0) {
			mp.put("1", item);
			return mp;
		}
		else {
			return nextValidator.validate(h, s);
		}
	}
	
	
}
