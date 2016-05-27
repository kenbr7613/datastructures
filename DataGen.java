import java.io.FileWriter;
import java.io.IOException;

public class DataGen {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Takes 2 arguments (num, range)");
            return;
        }
        int num = Integer.parseInt(args[0]);
        int range = Integer.parseInt(args[1]);
        if(num <= 0 || range <= 0) {
            System.out.println("num and range must be greater than zero");
        }
        
        try { 
            FileWriter outputFile = new FileWriter("temp.txt");
            
            outputFile.write("testststst");
            
            outputFile.flush();
            outputFile.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
}