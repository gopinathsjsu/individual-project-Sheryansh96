package project.Validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import project.Database;

public class ValidateItem implements Validator{
	
	
	private Validator nextValidator = null;
	boolean hasenough = true;
	@Override
	public void next(Validator v) {
		// TODO Auto-generated method stub
		this.nextValidator = v;
	}

	@Override
	public HashMap<String, ArrayList<String>> validate(HashMap<String, Integer> h, Database s) {
		// TODO Auto-generated method stub
		Iterator it = h.entrySet().iterator();
		ArrayList<String> item = new ArrayList<String>();
		HashMap<String,ArrayList<String>> mp = new HashMap<String,ArrayList<String>>();
		HashSet<String> things = s.getThings();
		while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry)it.next();
	        if(!things.contains((String) pair.getKey())) {
	        	System.out.println((String) pair.getKey());
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
