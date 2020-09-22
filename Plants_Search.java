import java.io.File;
import java.util.*;

public class Plants_Search {

    public static List PlantFinder(String searchPlant){
        List<String> plantInfo = new ArrayList<String>();
        File plants = new File("./Plant_Data.txt");
        try {
            Scanner scanner = new Scanner(plants);
            while (scanner.hasNextLine()) { //Search plant database for searchPlant
                String line = scanner.nextLine();
                if (line.contains(searchPlant)) {
                    for (int i = 0; i<4; i++) { //Add 4 lines containing plant's data to list
                        plantInfo.add(scanner.nextLine());
                    }
                    return plantInfo;
                }
            } //If plant's name is not found in file
            plantInfo.add("Plant not found");
            return plantInfo;

        }
        catch (Exception FileNotFoundException){
            System.out.println("ERROR: Plant Database not found.");
            System.exit(0);
        }
        return plantInfo;
    }

}
