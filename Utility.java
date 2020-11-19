import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * A class to load files
 * @author amberlaihipp
 */
public class Utility {
    /**
     * 
     */
    public Utility() {
        
    }

    public int loadFile(String fileName, String fileType, ArrayList aList) {           
          // FileInputStream in = null;
           //int c;

           try {      
               FileReader read = new FileReader(fileName);
               Scanner scanner = new Scanner(read); // create scanner
               
               if (fileType.equals("Plants")) {
                   // initialize temp variables
                   String tempName = "";
                   String tempSciName = "";
                   String tempNickname = "";
                   String tempLight = "";
                   String tempWaterInfo = "";
                   String tempMLevel = "";
                                      
                   while (scanner.hasNextLine()) { // While there are more lines in the file 
                           tempName = scanner.nextLine(); // set tempName to line read in
                           tempSciName = scanner.nextLine();
                           tempNickname = scanner.nextLine();
                           tempLight = scanner.nextLine();
                           tempWaterInfo = scanner.nextLine();
                           tempMLevel = scanner.nextLine();
                           
                           // Create Plant Object with info
                           Plant p = new Plant(tempName, tempSciName, tempNickname, tempLight, tempWaterInfo, tempMLevel);
                           // Add plant to arrayList that was passed in
                           aList.add(p);
                       }
                   }
               else if (fileType.equals("Questions")){
                   while (scanner.hasNextLine()) { // While there are more lines in the fill
                       aList.add(scanner.nextLine()); // add question to list
                   }
               }
               
               scanner.close(); // close scanner
           }   
           catch (Exception FileNotFoundException) {
               System.out.println("ERROR: File not found.");
               System.exit(0);
           }

           return 0;
    }
}