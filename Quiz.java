import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Quiz{
  
  private ArrayList<Question> quiz = new ArrayList<Question>();
  private static Scanner scan = new Scanner(System.in);
  private int numCorrect;
  private DecimalFormat frm = new DecimalFormat("0.##");
  private int totalQuestions = 25;
  
  public Quiz(String[] questions, String[] answers, int[] complexity){
    
    for(int i = 0; i < totalQuestions; i++){
      quiz.add(new Question(questions[i], answers[i]));
      quiz.get(i).setComplexity(complexity[i]);
    }
  }
  
  public void add(String q, String a){
    quiz.add(new Question(q,a));
    totalQuestions++;
  }
  public void add(String q, String a, int c){
    add(q, a);
    quiz.get(totalQuestions - 1).setComplexity(c);
  }
  
  public void giveQuiz(){//define a results class after
    for(int i = 0; i < quiz.size(); i++){
      System.out.println(quiz.get(i).getQuestion());
      String response = scan.next();
      
      if(quiz.get(i).answerCorrect(response))
        numCorrect++;
    }
  }
  
  public void giveQuiz(int min, int max){
    totalQuestions = 0;
    for(int x = 0; x < quiz.size(); x++){
      
      if(quiz.get(x).getComplexity() >= min && quiz.get(x).getComplexity() <= max){
        System.out.println(quiz.get(x).getQuestion());
        String response = scan.next();
      
      if(quiz.get(x).answerCorrect(response))
        numCorrect++;
      totalQuestions++;
      }
    
    }
  }
  public String results(){
    double answer = ((double)numCorrect / totalQuestions) * 100;
    return frm.format(answer);
    
  }

}