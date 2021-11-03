package lecture.chapter4;

public class LoopExamples {

  public static void main(String[] args) {

    int count = 0;

    System.out.println("While Schleife:");
    while(count <= 10){
      int evenDeterminator = 2;
      if(count % evenDeterminator != 0){
        count++;
        continue;
      }
      System.out.println(count);
      count++;
    }

    // System.out.println(evenDeterminator); --> außerhalb des Scopes ("Lebensbereich") der Variable

    count = 0;
    System.out.println("Do-While Schleife:");
    do{
      System.out.println(count);
      count++;
    }while(count <= 10);

    System.out.println("For Schleife");
    for(int i = 0; i <= 10; i++){
      System.out.println(i);
    }

    System.out.println("Die Timmmmmmmmmeyyyy For-Schleife:");
    count = 0;

    for(;;){
      System.out.println(count);
      count++;
      if(count > 10){
        break;
      }
    }

    System.out.println("For Schleife mit vielfachen von drei");

    for(int i = 0; i < 100; i = i + 3){
      System.out.println(i);
    }
  }
}
