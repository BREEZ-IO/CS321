import java.util.ArrayList;
/**
 * A class to load files
 * @author Bre McNichols
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
    
    public Plant SearchList(String search, String searchType){
        for (int i = 0; i < plantsList.size(); i++){
            Plant temp = plantsList.get(i);
            if (searchType == "Nickname"){
                if (temp.plantNickname == search){
                    return temp;
                }
            } 
            else if (searchType == "Plant Name"){
                if (temp.plantName == search){
                    return temp;
                }
            }
            else {
                return null;
            }
        }
        System.out.println("Plant " + search + "not found.");
        return null;
    }
    
    ArrayList<Plant> plantsList = new ArrayList<Plant>();
}
