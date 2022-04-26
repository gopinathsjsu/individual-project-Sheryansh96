package IO;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class IObasic {
	ArrayList<String> fileData = new ArrayList<>();
	Output output;
	
    public void readOrderpath(String path) throws IOException {
        String line;
        boolean skipHeader = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                } else {
                    this.fileData.add(line);
                    //System.out.println("File size is" + this.fileData.size());
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Not found");
        }
    }

    public ArrayList<String> getFileData(){
    	//System.out.println("File size is" + this.fileData.size());
        return this.fileData;
    }
    
    public void writeFinal(String message, boolean goodtoclear, String path, HashMap<String,Integer> h) throws IOException {
        if (goodtoclear){
            output = new SuccessMessage();
        }else {
            output = new ErrorMessage();
        }
        output.writeToCSV(message, path, h);
    }
    
}
