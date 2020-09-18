import java.util.*;
public class PlantsDictionary {

  public static void Main(String [args]) {
    
  }
    
    public static ArrayList PlantFinder(String searchPlant){
      List<String> plantInfo = new ArrayList<String>();
      
      Scanner scanner = new Scanner(file);
      File plants = new File("Plant_Data.txt");
      Boolean foundPlant = false
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if line.contains(searchPlant) {
          //Get the next lines that contain plant info and
          //add them to whichever data structure we choose
          //then return it.
          foundPlant = true;
       }
        if (foundPlant == true){
          for (int i = 0; i<10; i++) {
            plantInfo.add(scanner.nextLine());
          }
        foundPlant = false;
        return plantInfo;
        }
        
    }
    
    
    
    
      
  }

}
