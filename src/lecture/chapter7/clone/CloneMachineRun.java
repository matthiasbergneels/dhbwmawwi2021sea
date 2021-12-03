package lecture.chapter7.clone;

public class CloneMachineRun {

  public static void main(String[] args) {

    Sheep dolly = new Sheep("Dolly", 3);

    try {
      Sheep dolly2 = dolly.clone();

      System.out.println("Dolly Original: " + dolly.getName() + " - " + dolly.getAge());
      System.out.println("Dolly Clone: " + dolly2.getName() + " - " + dolly2.getAge());

      dolly2.setName("Gabi");

      System.out.println("Dolly Original: " + dolly.getName() + " - " + dolly.getAge());
      System.out.println("Dolly Clone: " + dolly2.getName() + " - " + dolly2.getAge());

    } catch(Exception e){
      System.out.println("Clonen ist schief gegangen!");
      System.out.println(e.getMessage());

    }


  }
}
