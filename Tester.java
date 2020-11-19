import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amberlaihipp
 */
public class Tester {
    
    public static void main(String[] args) {
        // create utility
        Utility test = new Utility();
        
        // create ArrayList
        ArrayList<Plant> mainPlants = new ArrayList<>();
        
        //String file = "MainPlants.txt";
        //String type = "Plants";
        
        test.loadFile("MainPlants.txt", "Plants", mainPlants);
        
       Iterator<Plant> testIterator = mainPlants.iterator();
       
       while (testIterator.hasNext()) {
           testIterator.next().printInfo();
       }
        
    }
}
