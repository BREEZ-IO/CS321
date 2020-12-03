import java.util.ArrayList;

/**
 * A class to create and manipulate lists of plants.
 *
 * @author Bre McNichols and Amber Lai Hipp and Michaela Dent
 */
public class PlantList {
    /**
     * 
     */    
    public PlantList(String filename) {
        // if trying to create MyPlants
        if (fileName.equals("MyPlants.txt")) {
            // check to see if file exists
            File myPlants = new File(fileName);
            // if file does not exist
            if (myPlants.isFile() == false) {
                // return empty list
                return;
            }
        }
        Utility test = new Utility();
        test.loadFile(filename, "Plants", plantsList);
    }
    
    public void addPlant(Plant newPlant, boolean setReminder) {
        plantsList.add(newPlant);
        if (setReminder){
            //add logic
        }
    }
    
    public void removePlant(Plant deadPlant, boolean removeReminder) {
        plantsList.remove(deadPlant);
    }
    
    public String printList(){
        String output = "";
        for (Plant p : plantsList) {
            output += p.toString();
        }
        
        return output;
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
            )
        }
            
        System.out.println("Plant " + search + " not found.");
        return null;
    }
    
    public void filterList(String search, String searchType) {
        ArrayList<Plant> mismatch = new ArrayList<Plant>();
        for (Plant p : plantsList) {
            if (searchType.equals("Water")) {
                if (p.getWaterInfo().contains(search))
                    continue;
                else {
                    mismatch.add(p);
                }    
            } 
            else if (searchType.equals("Maintenance")) {
                int m = Integer.parseInt((p.getMaintenanceLevel()));
                int a = Integer.parseInt(search);
                if (m > a) {
                    mismatch.add(p);
                }
                else
                    continue;
            }
            else if (searchType.equals("Light")) {
                if (p.getLightInfo().contains(search))
                    continue;
                else {
                    mismatch.add(p);
                }
            }
        }
        // remove mismatches
        plantsList.removeAll(mismatch);
        // add some sort of exception check for empty list
        return;
    }
    
    public void saveList() {
        Utility test = new Utility();
        test.writeFile(plantsList);
    }
    
    public int getSize() {
        return plantsList.size();
    }
    
    public Plant getRandom() {
        if (plantsList.size() == 1)
            return plantsList.get(0);
        Random rand = new Random();
        int i = rand.nextInt(plantsList.size());
        
        return plantsList.get(i);
    }
    
    private ArrayList<Plant> plantsList = new ArrayList<Plant>();
}
