import java.util.*;

public class Quiz {
    public static void Main(String[] args){

    }

    public static List GenerateQuiz(int questions){



        List answers = null;
        for (int i = 0; i<questions; i++){
            userAnswer = CallQuestions(i);
            answers.add(userAnswer);
        }
        return answers;
    }

    public static int AnswersToPlant(List answers){
    
        return 0;
    }
    
    public static String CallQuestions(int i){
        //Get the question i, ask the user, then return the answer
        String userAnswer = "";
        
        
        
        return userAnswer;
    }
    

}
