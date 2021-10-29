package lecture.chapter3;

public class ArrayExamples {

  public static void main(String[] args) {

    int numberA, numberB, numberC, numberE;

    int[] numbers = new int[10];

    numbers[0] = 5;
    numbers[1] = 42;

    System.out.println(numbers[1]);

    System.out.println(numbers[5]);

    int[] luckyNumbers = {67, 89, 67, 155, 12};

    System.out.println(luckyNumbers[3]);

    System.out.println(luckyNumbers.length);

    for(int currentNumber : luckyNumbers){
      if(currentNumber == 89){
        currentNumber = 100;
        System.out.println("Böse zahl");
        continue;
      }

      if(currentNumber == 155){
        System.out.println("Gewonnen");
        break;
      }
      System.out.println(currentNumber);

    }

    for(int i = 0; i < luckyNumbers.length; i++){
      if(luckyNumbers[i] == 89){
        luckyNumbers[i] = 100;
      }
      System.out.println(luckyNumbers[i]);
    }


    char[][] tictactoe = new char[3][3];

    tictactoe[1][1] = 'X';


    String[][] sentences = new String[5][];

    sentences[0] = new String[3];
    sentences[0][0] = "Ich";
    sentences[0][1] = "liebe";
    sentences[0][2] = "Dich";

    sentences[1] = new String[4];
    sentences[1][0] = "Ich";
    sentences[1][1] = "liebe";
    sentences[1][2] = "Currywurst";
    sentences[1][3] = "mehr";

    //sentences[2] = {"Das", "wird", "ein", "sehr", "sehr", "langer", "Satz"};

    System.out.println(sentences.length);

    System.out.println(sentences[0].length);
    System.out.println(sentences[1].length);

    String[][] sentences2 = {{"Das", "wird", "ein", "sehr", "sehr", "langer", "Satz"}, {"Das", "wird", "ein", "sehr", "sehr", "langer", "Satz"}};
  }
}
