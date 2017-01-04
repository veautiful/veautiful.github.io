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
