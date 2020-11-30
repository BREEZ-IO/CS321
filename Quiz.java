import java.util.*;

/**
 * @author Michaela Dent
 * Quiz generates questions, and chooses a plant to suggest for the user
 * based on the responses given.
 */
public class Quiz {

    /**
     * Default constructor for Quiz class. 
     */
    public Quiz() {
        // create list of plant options
        PlantList plantOptions = new PlantList("MainPlants.txt");
                
        // create list of questions
        Utility util = new Utility();
        util.loadFile("Questions.txt", "Questions", questions);
    }
    
    
    /**
     * askQuestions generates questions for the user to answer and filters plant
     * options based on the user's response.
     * @return chosenPlant, a plant object that is suggested to the user. 
     */
    private Plant askQuestions() {
        int i = 0; //number of questions to help stop loop  
        
        Scanner a = new Scanner(System.in);
        while (continueQuiz == true || i <= questions.size()-1) {
            
            System.out.println(questions.get(i)); //read question from arrayList 
            answer = a.nextLine(); //user's answer 
            
            // call filterList to remove plant options based on responses
            if(i == 0){
                plantOptions.filterList(answer, "Water"); 
            }
            else if (i == 1){
                plantOptions.filterList(answer, "Maintenance");
            }
            else if (i == 2){
                plantOptions.filterList(answer, "Light");
            }

            //stops asking questions if there are no more plant options
            if (plantOptions.getSize() < 1) {
                continueQuiz = false; 
            }
            
            i ++; 
        }
        
        chosenPlant = plantOptions.getRandom();
        return chosenPlant; 
    }
    
    private ArrayList<String> questions; //list of questions
    private String answer; 
    private PlantList plantOptions; 
    private Plant chosenPlant; 
    private boolean continueQuiz = true; 
    
}

