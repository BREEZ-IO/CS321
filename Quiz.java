import java.util.*;

/**
 * @author Michaela Dent
 * Quiz holds a question bank, and chooses a plant based on the answers
 * user gives. 
 */
public class Quiz {
    
    private ArrayList<String> questions; //list of questions
    private String answer; 
    private ArrayList<Plant> plants; // array list of plants copy 
    private Plant chosenPlant; //Plant object 
    private boolean continueQuiz = true; 
    
    /**
     * Default constructor for Quiz class. 
     * @param 
     */
    public Quiz() {
        //call loadfile from utility class 
        
        //create copy of plant options arraylist of options 
        ArrayList<String> plants = Plants;
        
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
            for(int j = plants.size()-1; j >= 0; j--) {//truly inefficient
                if (plants.get(j).fieldA != answer) {
                    plants.removePlantOption(plants.get(j));
                }
                else if (plants.get(j).fieldB != answer) {
                    plants.removePlantOption(plants.get(j));
                }
                else if (plants.get(j).fieldC != answer) {
                    plants.removePlantOption(plants.get(j));
                }      
            }
            
            //IF there are n > 1 plants, continue quiz ELSE continueQuiz = false
            if (plants.size() < 1) {
                continueQuiz = false; 
            }
            i ++; 
        }
        
        chosenPlant = choosePlant(plants);
    }
    
    private void removePlantOption(Plant p) {
        this.remove(p); 
    }
    
    private Plant choosePlant( ArrayList<Plant> p) {
        //random num generator 
        //return index
        Random rand = new Random(); 
        int index =  rand.nextInt(p.size());
        chosenPlant = p.get(index); 
        return chosenPlant; 
    }
    
}
