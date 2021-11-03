package lecture.chapter5;

public class CallByExamples {

  public static void main(String[] args) {

    // Call by Value

    int numberA = 5;
    int numberB;

    // call by Value
    numberB = numberA;

    numberA = numberA + 5;

    System.out.println(numberB);


    // Call by Reference

    Person herrBergNeels = new Person();
    Person profDrHoley = new Person();

    // Call by Reference
    Person matthias = herrBergNeels;
    Person papa = herrBergNeels;
    Person hasiPupsi = papa;

    profDrHoley = herrBergNeels;

    System.out.println("Herr Prof Holey ein blaues Auge? " + profDrHoley.hasBlueEye());
    System.out.println("Herr Berg-Neels ein blaues Auge? " + herrBergNeels.hasBlueEye());

    hasiPupsi.hitInFace();

    System.out.println("Hat Hasi Pupsi ein blaues Auge? " + hasiPupsi.hasBlueEye());
    System.out.println("Herr Prof Holey ein blaues Auge? " + profDrHoley.hasBlueEye());
    System.out.println("Herr Berg-Neels ein blaues Auge? " + herrBergNeels.hasBlueEye());

  }
}
