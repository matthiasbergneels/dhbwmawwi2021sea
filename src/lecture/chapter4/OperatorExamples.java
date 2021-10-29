package lecture.chapter4;

public class OperatorExamples {

  public static void main(String[] args) {

    int numberA = 5;

    numberA++;    // numberA = numberA + 1;


    int numberB = ++numberA * 5;

    System.out.println(numberB);


    System.out.println( ++numberA );
    System.out.println(numberA);

    numberA += numberB;   // => numberA = numberA + numberB;


    boolean isRaining = true;

    String weatherCondition = isRaining ? "Wir brauchen einen Regenschirm" : "Die Sonne scheint";

    System.out.println(weatherCondition);

    String firstText = "Hello";
    String secondText = "Klaus";

    String resultText = numberA + numberB + firstText + " " + secondText + " " + numberA + numberB;

    System.out.println(resultText);

  }
}
