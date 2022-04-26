package IO;

import java.io.IOException;
import java.util.HashMap;

public interface Output {
	
	abstract void writeToCSV(String message, String path, HashMap<String,Integer> h) throws IOException;

}
