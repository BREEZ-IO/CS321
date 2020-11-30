import java.util.ArrayList;
/**
 * A class to create and manipulate lists of plants.
 * @author Bre McNichols and Amber Lai Hipp
 */
public class PlantList {
    /**
     * 
     */
    // Create empty plant list
    public PlantList() {
        
    }
    
    // Create list from a file
    public PlantList(String filename) {
        Utility test = new Utility();
        test.loadFile(filename, "Plants", plantsList);
    }
    
    public void addPlant(Plant newPlant) {
        plantsList.add(newPlant);
    }
    
    public void removePlant(Plant deadPlant) {
        plantsList.remove(deadPlant);
    }
    
    public void printList(){
        for (int i = 0; i < plantsList.size(); i++) {
            Plant temp = (plantsList.get(i));
            System.out.println(temp.getName());
            System.out.println(temp.getSciName());
            System.out.println(temp.getNickname());
            System.out.println(temp.getLightInfo());
            System.out.println(temp.getWaterInfo());
            System.out.println(temp.getLastWateredDate() + "\n");
        }  
    }
    
    public Plant searchList(String search, String searchType) {
        for (Plant p : plantsList) {
            if (searchType.equals("Nickname")){
                if (p.getNickname().contains(search)){
                    return p;
                }
            } 
            else if (searchType.equals("Plant Name")) {
                if (p.getName().contains(search)){
                    return p;
                }
            }
            else {
                return null;
            }
        }
        System.out.println("Plant " + search + " not found.");
        return null;
    }
    
        public Plant filterList(String search, String searchType) {
        for (Plant p : plantsList) {
            if (searchType.equals("Water")){
                if (p.getWaterInfo().contains(search))
                    continue;
                else
                    return p;
            } 
            else if (searchType.equals("Maintenance")) {
                int m = Integer.parseInt((p.getMaintenanceLevel()));
                int a = Integer.parseInt(search);
                if (m > a)
                    return p;
                else
                    continue;
            }
            else if (searchType.equals("Light")) {
                if (p.getLightInfo().contains(search))
                    continue;
                else
                    return p;
            }
        }
        
        return null;
    }
    
    public void saveList() {
        Utility test = new Utility();
        test.writeFile(plantsList);
    }
    
    public int getSize() {
        return plantsList.size();
    }
    
    private ArrayList<Plant> plantsList = new ArrayList<Plant>();
}
