import java.util.ArrayList;
/**
 * A class to load files
 * @author amberlaihipp
 */
public class PlantList {
    /**
     * 
     */
    public PlantList(String filename) {
        Utility test = new Utility();
        test.loadFile(filename, "Plants", plantsList);
    }
    
    public void AddPlant(Plant newPlant){
        plantsList.add(newPlant);
    }
    
    public void RemovePlant(Plant deadPlant){
        plantsList.remove(deadPlant);
    }
    
    public void PrintList(){
        for (int i = 0; i < plantsList.size(); i++) {
            Plant temp = (plantsList.get(i));
            System.out.println(temp.plantNickname);
            System.out.println(temp.plantSciName);
            System.out.println(temp.plantName);
            System.out.println(temp.plantLight);
            System.out.println(temp.plantWaterInfo);
            System.out.println(temp.lastWatered);
                    
        }  
    }
    
    ArrayList<Plant> plantsList = new ArrayList<Plant>();
}

