import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Iterator;
/**
 * A class to load and save files
 * @author amberlaihipp
 */
public class Utility {
    /**
     * 
     */
    public Utility() {
        
    }

    public int loadFile(String fileName, String fileType, ArrayList aList) {           
           try {      
               FileReader read = new FileReader(fileName);
               Scanner scanner = new Scanner(read); // create scanner
               String line = "";
               
               if (fileType.equals("Plants")) {
                   // initialize temp variables
                   String tempName = "";
                   String tempSciName = "";
                   String tempNickname = "";
                   String tempLight = "";
                   String tempWaterInfo = "";
                   String tempLastWaterDate = "";
                   String tempMLevel = "";
                                      
                   while (scanner.hasNextLine()) { // While there are more lines in the file 
                           tempName = scanner.nextLine(); // set tempName to line read in
                           tempSciName = scanner.nextLine();
                           tempNickname = scanner.nextLine();
                           tempLight = scanner.nextLine();
                           tempWaterInfo = scanner.nextLine();
                           tempLastWaterDate = scanner.nextLine();
                           tempMLevel = scanner.nextLine();
                           
                           line = scanner.nextLine();
                           // Create Plant Object with info
                           Plant p = new Plant(tempName, tempSciName, tempNickname, tempLight, tempWaterInfo, tempLastWaterDate, tempMLevel);
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
    
    public boolean writeFile(ArrayList<Plant> list) {
        try {            
            FileWriter writer = new FileWriter("MyPlants.txt");
            
            for (Plant p : list) {
                writer.write(p.getName() + "\n");
                writer.write(p.getSciName() + "\n");
                writer.write(p.getNickname() + "\n");
                writer.write(p.getLightInfo() + "\n");
                writer.write(p.getWaterInfo() + "\n");
                writer.write(p.getLastWaterDate() + "\n");
                writer.write(p.getMaintenanceLevel() + "\n");
                writer.write("***************\n");
                
                writer.flush();
            }
            
            writer.close();
            System.out.println("File saved successfully");
            
            return true;           
        }
        catch (IOException e) {
            System.out.println("An ERROR occured saving the file.");
            e.printStackTrace();
            
            return false;
        }
    }
}
