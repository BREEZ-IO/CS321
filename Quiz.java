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
    private ArrayList<String> question; 
    private ArrayList<String> plants; 
    
    public Quiz() {
        //call loadfile from utility class 
        Utility obj = new Utility(); 
        question = obj.loadFile(filename, "Questions", question); //idk filename
        
        //create copy of plant options arraylist of options 
        Utility obj2 = new Utility(); 
        plants = obj2.loadFile (filename, "Plants", plants); //idk filename
        
    }
    private Plant askQuestions() {
        int i = 0; //prime to help stop loop 
        Scanner a = new Scanner(System.in); //for user input

        while (continueQuiz == true || i <= question.size()-1) {
            //read question from arrayList 
            System.out.println(question.get(i));
            
            //store answer 
            answer = a.nextLine(); 
            
            //compare variable to the factor in other plants 
            //CALL arrayList.remove choice for for plants that do not have that factor
            for(int j = plants.size()-1; j >= 0; j--) {//truly inefficient
                if (plants.get(j).tempWaterInfo != answer) {
                    plants.removePlantOption(plants.get(j));
                }
                else if (plants.get(j).tempMLevel != answer) { //maybe idk if this is the right field
                    plants.removePlantOption(plants.get(j));
                }
                else if (plants.get(j).tempLight != answer) {
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
        return chosenPlant;
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
