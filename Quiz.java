import java.util.*;

/**
 * @author Michaela Dent
 * Quiz holds a question bank, and chooses a plant based on the answers
 * user gives. 
 */
public class Quiz {
    
    private ArrayList<String> questions; //list of questions
    private String answer; 
    private PlantList plantOptions; // array list of plants copy 
    private Plant chosenPlant; //Plant object 
    private boolean continueQuiz = true; 
    
    /**
     * Default constructor for Quiz class. 
     * @param 
     */
    public Quiz() {
        // create list of plant options
        PlantList plantOptions = new PlantList("MainPlants.txt");
    }
    
    private void askQuestions() {
        int i = 0; //number of questions to help stop loop  
        
        Scanner a = new Scanner(System.in);
        while (continueQuiz == true || i <= questions.size()-1) {
            //read question from arrayList 
            System.out.println(questions.get(i));
            
            //store answer 
            answer = a.nextLine(); 
            
            //compare variable to the factor in other plants 
            //CALL arrayList.remove choice for for plants that do not have that factor
            for(int j = plantOptions.size()-1; j >= 0; j--) {//truly inefficient
                if (plantOptions.get(j).fieldA != answer) {
                    plantOptions.removePlant(plantOptions.get(j));
                }
                else if (plantOptions.get(j).fieldB != answer) {
                    plantOptions.removePlantOption(plantOptions.get(j));
                }
                else if (plantOptions.get(j).fieldC != answer) {
                    plantOptions.removePlantOption(plantOptions.get(j));
                }      
            }
            
            //IF there are n > 1 plants, continue quiz ELSE continueQuiz = false
            if (plants.size() < 1) {
                continueQuiz = false; 
            }
            i ++; 
        }
        
        chosenPlant = choosePlant(plantOptions);
    }
    
    private void removePlantOption(Plant p) {
        this.remove(p); 
    }
    
    private Plant choosePlant(PlantList p) {
        //random num generator 
        //return index
        Random rand = new Random(); 
        int index =  rand.nextInt(p.size());
        chosenPlant = p.get(index); 
        return chosenPlant; 
    }
    
}
