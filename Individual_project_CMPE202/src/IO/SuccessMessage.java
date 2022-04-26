package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;


public class SuccessMessage implements Output{
	public void writeToCSV(String orderTotal, String path, HashMap<String,Integer> h) throws IOException {

		Random rand = new Random();
		
        Path path_ = Paths.get(path);

        System.out.println("\nThanks for shopping");
        FileWriter fileWriter = new FileWriter(path_.getParent() + "/output" + rand.nextInt() + "_.csv");
        fileWriter.write("Your Bill is\n");
        Iterator it = h.entrySet().iterator();
        while(it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry)it.next();
			String s1 = (String) pair.getKey();
			String s2 = String.valueOf(pair.getValue());
			fileWriter.append(s1+"           "+s2+System.getProperty( "line.separator" ));
		}
        fileWriter.append(String.valueOf(orderTotal));
        fileWriter.close();
    }
}
