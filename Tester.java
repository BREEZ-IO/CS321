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
        
        // test add plant function, add Peace Lily to myPlants
        myPlants.addPlant(new Plant(mainPlants.searchList("Peace Lily", "Plant Name")));
        
        // test add plant function, add Chinese Money Plant to myPlants
        myPlants.addPlant(new Plant(mainPlants.searchList("Chinese Money Plant", "Plant Name")));
        
        // print out myPlant
        System.out.println("**My Plants List**");
        myPlants.printList();
        
        // test remove plant
        myPlants.removePlant(myPlants.searchList("Peace Lily", "Plant Name"));
        
        // print out myPlant
        System.out.println("**My Plants List**");
        myPlants.printList();
       
        // save myPlants list
        myPlants.saveList();
    }
}
