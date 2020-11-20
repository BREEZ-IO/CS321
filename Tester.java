import java.util.*;
/*
 * Used to test functionality of other classes
 * Will not be in final project
 */

/**
 *
 * @author amberlaihipp
 */
public class Tester {
    
    public static void main(String[] args) {
        
        // create mainPlant list from file
        PlantList mainPlants = new PlantList("MainPlants.txt");
        
        // print list of main plants
        mainPlants.printList();
        
        // create empty myPlants list
        PlantList myPlants = new PlantList();
        
        // test add plant function, add Pothos to myPlants
        myPlants.addPlant(new Plant(mainPlants.searchList("Pothos", "Plant Name")));
       
        // save myPlants list
        myPlants.saveList();
    }
}
