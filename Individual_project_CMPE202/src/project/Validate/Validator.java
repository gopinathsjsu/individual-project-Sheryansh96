package project.Validate;

import java.util.ArrayList;
import java.util.HashMap;

import project.Database;

public interface Validator {
	void next(Validator v);
	ArrayList<String> validate(HashMap<String,Integer> h, Database s);
}
