import java.util.*;

/**
 * Quiz holds a question bank, and chooses a plant based on the answers
 * user gives.
 * 
 * @author Michaela Dent and Amber Lai Hipp
 */
public class Quiz {    
    /**
     * Default constructor for Quiz class.
     */
    public Quiz() {        
        // Create list of questions
        Utility util = new Utility();
        util.loadFile("Questions.txt", "Questions", questions);
    }
    
    /**
     * Generates questions for the user to answer and filters plant
     * options based on the user's response.
     */
    public void runQuiz() {
        // Create list of plant options
        PlantList plantOptions = new PlantList("MainPlants.txt");
        String answer = "";
        
        Scanner a = new Scanner(System.in);
        // For each question in the list
        for (int i = 0; i < questions.size(); i++) {
            // Print question
            System.out.println(questions.get(i) + "\n");
            
            // Store answer 
            answer = a.nextLine(); 
            
            // Question 1
            if (i == 0) {
                // Elminate plants that require too much water
                plantOptions.filterList(answer, "Water");
            }
            // Question 2
            else if (i == 1) {
                // Eliminate plants that are too high maintenance
                plantOptions.filterList(answer, "Maintenance");
            }
            // Question 3
            else if (i == 2) {
                // Eliminate plants that don't meet light requirements
                plantOptions.filterList(answer, "Light");
            }
            
            // Stop asking questions if there are no more plant options
            if (plantOptions.getSize() == 0) {
                System.out.println("Please try again, there were no plants that matched your answers");
                return;
            }
            // Test print statement to check if list is being altered correctly
            //plantOptions.printList();
        }
        
        /*
        if (plantOptions.getSize() == 0) {
            System.out.println("Please try again, there were no plants that matched your answers");
        }
        */
        //else {
        // Choose a plant randomly from ones left in the list
        Plant chosenPlant = plantOptions.getRandom();
        
        // Display chosenPlant
        System.out.println("Recommended Plant: " + chosenPlant.getName());
        //}
    }  
    
    private ArrayList<String> questions = new ArrayList<>(); // List of questions
    //private String answer;
    //private PlantList plantOptions; // array list of plants copy 
    //private Plant chosenPlant; //Plant object 
    //private boolean continueQuiz = true; 
}

