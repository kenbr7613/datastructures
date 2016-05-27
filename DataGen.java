import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

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
        
        Date myDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        
        String filename = new String("data_").concat(sdf.format(myDate)).concat(".txt");
        try { 
            FileWriter outputFile = new FileWriter(filename);
            Random rand = new Random();
            
            for(int i=0; i< num; i++) {
                outputFile.append(String.valueOf(rand.nextInt(range)));
                outputFile.append(" ");
            }
            
            outputFile.append("\n");
            outputFile.flush();
            outputFile.close();
            System.out.println("Created file " + filename);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}