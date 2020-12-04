package main;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

/**
 * A class to create and manipulate lists of plants.
 * 
 * @author Bre McNichols and Amber Lai Hipp and Michaela Dent
 */
public class PlantList {
    /**
     * Constructor function to create a plant list based on a text file.
     * 
     *@param fileName a string containing the address of the file holding all plants to be added.
     *@param util a utility class to use the loadFile function.
     */    
    public PlantList(String fileName, Utility util) {
        // If trying to create MyPlants
        if (fileName.equals("MyPlants.txt")) {
            // Check to see if file exists
            File myPlants = new File(fileName);
            // If file does not exist
            if (myPlants.isFile() == false) {
                // return empty list
                return;
            }
        }
        
        util.loadFile(fileName, plantsList);
    }
    
    /**
     * Function to add a plant to the plant list. It can also add a last watered date if needed.
     * 
     * @param newPlant the plant that is going to be added to the list.
     * @param setLastWateredDate a boolean that tells if the plant needs a last-watered date or not.
     */
    public void addPlant(Plant newPlant, boolean setLastWateredDate) {
        if (setLastWateredDate == true) {
            newPlant.setLastWateredDate();
        }
        
        plantsList.add(newPlant); 
    }
    
    /**
     * Removes a given plant from the list of plants.
     * 
     * @param deadPlant the plant to be removed from the list.
     */
    public void removePlant(Plant deadPlant) {
        plantsList.remove(deadPlant);
    }
    
    /**
     * Function to return the entire list as a string.
     * 
     * @return output each plant's toString function conjoined together.
     * @see toString()
     */
    public String printList(){
        String output = "";
        for (Plant p : plantsList) {
            output += p.toString();
        }
        
        return output;
    }
    
    /**
     * Searches through a plant list for a given plant by its name or nickname.
     * 
     * @param search the search keyword.
     * @param searchType defines if the plant is being searched by name or nickname.
     * @return temp, a copy of plant that was being searched for, or null if not found.
     */
    public Plant searchList(String search, String searchType) {
        for (Plant p : plantsList) {
            if (searchType.equals("Nickname")){
                if (p.getNickname().contains(search)){
                    Plant temp = p.copy();
                    return temp;
                }
            } 
            else if (searchType.equals("Plant Name")) {
                if (p.getName().contains(search)){
                    Plant temp = p.copy();
                    return temp;
                }
            }    
        }
        
        System.out.println("Plant " + search + " not found.");
        return null;
    }
    
    /**
     * Removes plants from the list whose attributes don't fit into 
     * the users needs.
     * 
     * @param search the search key designating the exact attribute being searched for.
     * @param searchType the type of attribute that is being searched for, Water, Maintenance, or Light.
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
                if (p.getLightInfo().equals(search))
                    continue;
                else {
                    mismatch.add(p);
                }
            }
        }
        // remove mismatches
        plantsList.removeAll(mismatch);
        // add some sort of exception check for empty list?
        return;
    }
    
    /**
     * Saves the list as a text file.
     */
    public void saveList() {
        Utility util = new Utility();
        util.writeFile(plantsList);
    }
    
    /**
     * Gives the length of the list of plants.
     * @return size of plant list as an integer. 
     */
    public int getSize() {
        return plantsList.size();
    }
    
    /**
     * Allows an outside class to iterate through the plantsList by returning 
     *  the plant at a given index.
     * 
     * @param index the index of the plant you want to get access to.
     * @return temp, a copy of the plant object.
     */
    public Plant iterateList(int index) {
        try {
            Plant temp = plantsList.get(index).clone();
            return temp;
        }
        catch (Error ArrayIndexOutOfBoundsException) {
            System.out.println("Error accessing plant in list0");
            System.exit(0);
        }
        return null;
    }

    /**
     * Picks a random plant from the list of plants.
     * 
     * @return temp, a copy of the plant object that was selected.
     */
    public Plant getRandom() {
        if (plantsList.size() == 1)
            Plant temp = plantsList.get(0).clone();
            return temp;
        Random rand = new Random();
        int i = rand.nextInt(plantsList.size());
        Plant temp = plantsList.get(i).clone();
        return temp;
    }
    
    private ArrayList<Plant> plantsList = new ArrayList<Plant>();
}