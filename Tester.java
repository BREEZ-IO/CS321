import java.util.*;

/**
 * Used to test functionality of other classes
 * Will not be in final project
 * 
 * @author Amber Lai Hipp and Colt
 */
public class Tester {
    
    public static void main(String[] args) {
        /**
        * @param args the command line arguments
        */
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlantForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlantForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlantForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlantForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlantForm().setVisible(true);
            }
        });
        
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
        
        System.out.println("Beginning Quiz\n");
        //test quiz
        // create quiz object
        Quiz q = new Quiz();
        
        q.runQuiz();     
    }
}
