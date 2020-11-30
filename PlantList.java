import java.util.ArrayList;
import java.util.Random; 
/**
 * A class to create and manipulate lists of plants.
 * @author Bre McNichols and Amber Lai Hipp
 */
public class PlantList {
    /**
     * Create list from a file.
     */
    public PlantList() {
        
    }
    
    /**
     * Creates list from a file.
     * @param filename, the file that the plant list will be pulled from.  
     */
    public PlantList(String filename) {
        Utility test = new Utility();
        test.loadFile(filename, "Plants", plantsList);
    }
    
    /**
     * addPlant(Plant) adds plant objects to the plant list. 
     * @param newPlant, the plant object that will be added to the list. 
     */
    public void addPlant(Plant newPlant) {
        plantsList.add(newPlant);
    }
    
    /**
     * removePlant(Plant) removes plants from the plant list. 
     * @param deadPlant, the plant being removed from the list.  
     */
    public void removePlant(Plant deadPlant) {
        plantsList.remove(deadPlant);
    }
    
    /**
     * printList() prints all the information for each plant. 
     */
    public void printList(){
        for (int i = 0; i < plantsList.size(); i++) {
            Plant temp = (plantsList.get(i));
            System.out.println(temp.getName());
            System.out.println(temp.getSciName());
            System.out.println(temp.getNickname());
            System.out.println(temp.getLightInfo());
            System.out.println(temp.getWaterInfo());
            System.out.println(temp.getLastWaterDate() + "\n");
        }  
    }
    
    /** 
     * searchList(String, String) searches plant list by the a plant object's
     * nickname, and plant name. 
     * @param search, the search key. 
     * @param searchType, the pattern the key is supposed to match. 
     * @return a plant object, p, if the key matches the pattern. Otherwise, null. 
     */
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
        /**
         * filterList(String, String) removes plants from the plant list if they
         * have undesired fields. 
         * @param search, the key. 
         * @param searchType, the pattern. 
         * @return a plant object if the key matches the patter. Otherwise, null. 
         */
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
    
    /**
     * saveList() saves the current plant list.
     */    
    public void saveList() {
        Utility test = new Utility();
        test.writeFile(plantsList);
    }
    /**
     * getSize() returns the size of the plant list. 
     */
    public int getSize() {
        return plantsList.size();
    }
    
    /**
     * getRandom() returns a random plant in plant list. 
     */
    public Plant getRandom(){
        if (plantsList.size() == 1) 
            return plantsList.get(0); 
        Random rand = new Random(); 
        int i = rand.nextInt(plantsList.size());
        
        return plantsList.get(i); 
}
    
    private ArrayList<Plant> plantsList = new ArrayList<Plant>();
}