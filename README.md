# Card (6.8)

    public class Card
    {
     private String face;
     private String suit;

    public Card( String cardFace, String cardSuit )
    {
      face = cardFace;
      suit = cardSuit;
    }

    public String toString()
    {
      return face + " of " + suit;
    }
    }

# DeckofCards (6.8)
     public class DeckOfCardsTest
        {
    public static void main( String[] args )
    {
            DeckOfCards testdeck = new DeckOfCards();
             testdeck.shuffle();

          for ( int i = 1; i <= 52; i++ )
               {
             System.out.printf( "%-19s", testdeck.dealCard() );

             if ( i % 4 == 0 ) // output a newline after every fourth card
              System.out.println();
             }
             }
             }









# Question

    //********************************************************************
    //  Question.java       Author: Lewis/Loftus/Cocking
    //
    //  Represents a question (and its answer).
    //********************************************************************

    public class Question implements Complexity
    {
    private String question, answer;
    private int complexityLevel;

    //-----------------------------------------------------------------
    //  Sets up the question with a default complexity.
    //-----------------------------------------------------------------
    public Question (String query, String result)
    {
      question = query;
      answer = result;
      complexityLevel = 1;
    }

    //-----------------------------------------------------------------
    //  Sets the complexity level for this question.
    //-----------------------------------------------------------------
    public void setComplexity (int level)
    {
      complexityLevel = level;
    }

    //-----------------------------------------------------------------
    //  Returns the complexity level for this question.
    //-----------------------------------------------------------------
    public int getComplexity()
    {
      return complexityLevel;
    }

    //-----------------------------------------------------------------
    //  Returns the question.
    //-----------------------------------------------------------------
    public String getQuestion()
    {
      return question;
    }
    //-----------------------------------------------------------------
    //  Returns the answer to this question.
    //-----------------------------------------------------------------
    public String getAnswer()
    {
      return answer;
    }

    //-----------------------------------------------------------------
    //  Returns true if the candidate answer matches the answer.
    //-----------------------------------------------------------------
    public boolean answerCorrect (String candidateAnswer)
    {
      return answer.equals(candidateAnswer);
    }

    //-----------------------------------------------------------------
    //  Returns this question (and its answer) as a string.
    //-----------------------------------------------------------------
    public String toString()
    {
      return question + "\n" + answer;
    }
    }


# Complexity

    //********************************************************************
    //  Complexity.java       Author: Lewis/Loftus/Cocking
    // 
    //  Represents the interface for an object that can be assigned an
    //  explicit complexity.
    //********************************************************************

    public interface Complexity
    {
    public void setComplexity (int complexity);
    public int getComplexity();
    }

# Quiz
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

       
# QuizTime

    import java.util.Scanner;

    public class QuizTime{
  
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    String[] questions = {"What color is Clifford?", "1 + 2 = ",
      "Who wears red leather jackets with zippers",
      "Who lives in a trash can on 'Sesame Street'?",
      "What do dogs say most of the time?",
      "What do cats say most of the time?",
      "What's 10/2?",
      "If you wanted to dig a hole, which of the following would you be most likely to use?",
      "If you're driving a car, but you're going than the speed limit, you are then ___",
      "If an average person counted all of their fingers and toes, how many would they have?",
      "What color is a stop sign?",
      "what do we take camping and to school?",
      "what's 23 + 1?",
      "What house is Harry Potter from?",
      "bronze, silver, and ___ ",
      "3+3 = ",
      "Dogs have how many legs?",
      "Who shot the sheriff, yet refrained from shooting the deputy?",
      "Is it reasonable to have smores for dinner?",
      "Roaches are gross. true/false? (type T or F)",
      "Real Time Strategy games are generally dominated by which country?",
      "How many cores does an intel quad core processor have?",
      "Which city is Thomas Jefferson Bridge in?",
      "I should lose weight? T/F",
      "PSU is to power, as RAM is to _",
      "how many fingers do you have"};
    
    String[] answers = {"Red",
      "3",
      "Michael Jackson",
      "Oscar",
      "woof",
      "meow",
      "5",
      "shovel",
      "speeding",
      "20",
      "red",
      "backpack",
      "24",
      "Gryffindor",
      "gold",
      "6",
      "4",
      "Bob Marley",
      "yes",
      "t",
      "South Korea",
      "4",
      "San pedro",
      "T",
      "flash memory",
      "five"};
    int[] hardness = {4, 1, 1, 7, 2, 1, 2, 3, 3, 2, 1, 3, 9, 8, 7, 8, 6, 5, 10, 8, 9, 10, 10, 6, 7};
    Quiz torcher = new Quiz(questions, answers, hardness);
    
    System.out.println("Please enter the range of how hard you'd like your quiz to be: \nminimum hardness:");
    int min = scan.nextInt();
    System.out.println("maximum hardness:");
    int max = scan.nextInt();
    
    torcher.giveQuiz(min, max);
    
    System.out.println("number of answers correct divided by our number of questions " + torcher.results());
    }
    }
