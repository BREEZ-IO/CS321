import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * A class to load files
 * @author amberlaihipp
 */
public class PlantList {
    /**
     * 
     */
    public PlantList(String filename) {
        ArrayList<String> plantsList = new ArrayList<String>();
        Utility test = new Utility();
        test.loadFile(filename, "Plants", plantsList);
    }
    
    
}
