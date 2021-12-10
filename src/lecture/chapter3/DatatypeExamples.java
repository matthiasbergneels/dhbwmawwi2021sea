package lecture.chapter3;

public class DatatypeExamples {

  public static void main(String[] args) {

    // Deklaration der Variable numberA
    int numberA;

    // Initialisierung von numberA
    numberA = 15;

    char firstSign = 'a';

    System.out.println(numberA);

    numberA = 42;

    System.out.println(numberA);

    // Deklaration & Initialisierung der Konstanten PI
    final double PI = 3.14;

    System.out.println(PI);

    //pi = 5.1;


    // Literale

    // Ganzzahlen Literale:

    // Dezimal
    numberA = 0;
    numberA = 9;
    numberA = 8273;
    numberA = 90;
    System.out.println(numberA);

    byte shortNumberB = 127;
    System.out.println(shortNumberB);


    // Oktal Literal (Ganzzahl, 0-7, prefix 0)
    numberA = 07;
    System.out.println(numberA);

    numberA = 077;
    System.out.println(numberA);

    // hexadezimal Literal (Ganzzahl, 0-9 & A-F, Prefix 0x)
    numberA = 0x1A;
    System.out.println(numberA);

    // Long Literal
    long veryLongNumber = 3000000000000000000L;


    // Double Literal

    double preciseNumber = .1;
    System.out.println(preciseNumber);

    preciseNumber = 15.45;
    preciseNumber = 15.45e4;
    preciseNumber = 15.45e-4D;

    System.out.println(preciseNumber);

    // float Literal
    float notSoPreciseNumber = 15.45F;


    // boolsches Literal
    boolean isTired = true; // false

    // Char Literal
    char secondSign = 'g';
    secondSign = '6';
    secondSign = '\'';
    secondSign = '\u2764';

    System.out.println(secondSign);

    secondSign = 76;
    System.out.println(secondSign);

    // Zeichenketten Literal
    String myText = "Das ist \"mein\" \nlanger \tText! \u2764";
    System.out.println(myText);


    // Datentypkonvertierung

    byte smallNumber = 99;

    // implizite Konvertierung
    numberA = smallNumber;

    numberA = 170;

    // explizite Konvertierung über Type Cast ()
    smallNumber = (byte)numberA;

    System.out.println(smallNumber);

    numberA = (int)PI;

    System.out.println(numberA);

    char thirdSign = 'a';

    numberA = thirdSign;
    System.out.println(thirdSign);
    System.out.println(numberA);

    thirdSign = (char)(numberA + 1);
    System.out.println(thirdSign);
    System.out.println(numberA + 1);


    var numberC = '1';                // typ char
    var newSign = thirdSign;    // typ char
  }
}
