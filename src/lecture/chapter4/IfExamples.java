package lecture.chapter4;

public class IfExamples {

  public static void main(String[] args) {

    int grade = 2;

    if(grade <= 4) {
      System.out.println("Klausur bestanden");
    } else {
      System.out.println("Durchgefallen");
      System.out.println("Muss ich wiederholen.");
    }


    if(grade < 2){
      System.out.println("Sehr gut bestanden");
    } else if(grade >= 3 & grade <= 4){
      System.out.println("Das war knapp");
    } else if(grade >= 2 & grade < 3){
      System.out.println("bestanden");
    } else {
      System.out.println("Durchgefallen");
      System.out.println("Muss ich wiederholen.");
    }

    System.out.println("Ende");

  }
}
