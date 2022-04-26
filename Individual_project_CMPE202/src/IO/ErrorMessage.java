package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;

public class ErrorMessage implements Output {
	
	Random rand = new Random();

    public void writeToCSV(String errorMessage, String path, HashMap<String,Integer> h) throws IOException {

        Path path_ = Paths.get(path);

        System.out.println("\nIssue while processing your order please look at the output file");
        FileWriter fileWriter = new FileWriter( path_.getParent() + "/error__" + rand.nextInt()  + "_.txt");
        fileWriter.append(errorMessage);
        fileWriter.close();
    }
    
}
