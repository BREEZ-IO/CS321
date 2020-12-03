import java.util.ArrayList;

/**
 * A class to create and manipulate lists of plants.
 * @param plantsList An Arraylist of Plant objects that will hold all plants in the PlantList
 * @author Bre McNichols and Amber Lai Hipp and Michaela Dent
 */
public class PlantList {
    /**
     * Constructor function to create a plant list based on a text file.
     @param filename: A string containing the address of the file holding all plants to be added
     @param util: A utility class to use the loadFile function 
     */    
    public PlantList(String filename, Utility util) {
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
        util.loadFile(filename, "Plants", plantsList);
    }
    /**
    Function to add a plant to the plant list. It can also add a last watered date if needed.
    @param newPlant: the plant that is going to be added to the list.
    @param setLastWateredDate: A boolean that tells if the plant needs a last-watered date or not.
    */
    public void addPlant(Plant newPlant, boolean setLastWateredDate) {
        if (setLastWateredDate == true) {
            newPlant.setLastWateredDate();
        }
        
        plantsList.add(newPlant); 
    }
    /**
    Function to remove a given plant from a list.
    @param deadPlant: The specific plant that will be removed from the list.
    */
    public void removePlant(Plant deadPlant) {
        plantsList.remove(deadPlant);
    }
    /**
    Function to return the entire list as a string.
    @return output Each plant's toString function conjoined together
    @see toString()
    */
    public String printList(){
        String output = "";
        for (Plant p : plantsList) {
            output += p.toString();
        }
        
        return output;
    }
    /**
    Searches through a plantlist for a given plant by its name or nickname
    @param search The search keyword
    @param searchType Defines if the plant is being searched by name or nickname
    @return p The Plant object that was being searched for, or null if not found
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
            )
        }
            
        System.out.println("Plant " + search + " not found.");
        return null;
    }
    /**
    Removes plants from the list who's attributes don't fit into the user's needs.
    @param search The search key designating the exact attribute being searched for
    @param searchType The type of attribute that is being searched for, Water, Maintenance, or Light
    */
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
    /**
    Function to save the list as a text file that can be read in the next time the program is opened.
    */
    public void saveList() {
        Utility test = new Utility();
        test.writeFile(plantsList);
    }
    /**
    Returns the length of the list in plants.
    @return plantsList.size() the size of the plantList
    @see plantsList.size()
    */
    public int getSize() {
        return plantsList.size();
    }
    /**
    Function to get a random plant out of a list
    @return plantsList.get(i or 0) The randomized Plant that will be returned
    */
    public Plant getRandom() {
        if (plantsList.size() == 1)
            return plantsList.get(0);
        Random rand = new Random();
        int i = rand.nextInt(plantsList.size());
        
        return plantsList.get(i);
    }
    
    private ArrayList<Plant> plantsList = new ArrayList<Plant>();
}
