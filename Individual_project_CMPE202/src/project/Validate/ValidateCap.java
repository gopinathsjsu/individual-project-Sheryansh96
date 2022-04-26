package project.Validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import project.Database;
import project.Item;

public class ValidateCap implements Validator{

	private Validator nextValidator = null;
	boolean hasenough = true;
	
	@Override
	public void next(Validator v) {
		// TODO Auto-generated method stub
		this.nextValidator = v;
	}

	@Override
	public ArrayList<String> validate(HashMap<String, Integer> h, Database s) {
		// TODO Auto-generated method stub
		//Database s = Database.getInstance();
		Iterator it = h.entrySet().iterator();
		Integer essential=0;
		Integer lux=0;
		Integer misc=0;
		ArrayList<String> Essentials = new ArrayList<String>();
		ArrayList<String> Luxury = new ArrayList<String>();
		ArrayList<String> Misc = new ArrayList<String>();
		
		while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry)it.next();
			String category = s.getItemData().get(pair.getKey()).getCategoryname();
			if(category == "Essentials") {
				Essentials.add((String) pair.getKey() + " " + String.valueOf(pair.getValue()));
				essential+= (Integer)pair.getValue();
			}
			else if(category == "Luxury") {
				Luxury.add((String) pair.getKey()+ " " + String.valueOf(pair.getValue()));
				lux+=(Integer)pair.getValue();;
			}
			else {
				Misc.add((String) pair.getKey()+ " " + String.valueOf(pair.getValue()));
				misc+=(Integer)pair.getValue();
			}
		}
		
		
		if(s.getCategoryLimit("Essentials") < essential) {
			return Essentials;
		}
		else if(s.getCategoryLimit("Luxury") < lux) {
			return Luxury;
		}
		else if(s.getCategoryLimit("Misc") < misc) {
			return Misc;
		}
		else {
			return new ArrayList<String>();
		}
	}

}
