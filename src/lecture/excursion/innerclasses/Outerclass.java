package lecture.excursion.innerclasses;

public class Outerclass {

  public static interface InnerInterface{
    void print(String message);
  }

  public static interface SecondInnerInterface{
    void print();
  }

  // inner top-level class
  public static class InnerTopLevelClass{
    void print(String message){
      System.out.println(this.getClass().getName() + " - Innere Top Level Klasse sagt: " + message);
    }
  }

  // inner element class
  public class InnerElementClass{
    void print(String message){
      System.out.println(this.getClass().getName() + " - Innere Element Klasse sagt: " + message);
    }
  }

  void printFromInnerLocalClass(String message){
    // Inner Local Class
    class InnerLocalClass{
      void print(String message) {
        System.out.println(this.getClass().getName() + " - Innere Lokale Klasse sagt: " + message);
      }
    }

    InnerLocalClass myInnerLocalClass = new InnerLocalClass();
    myInnerLocalClass.print(message);
  }


  void printFromInnerAnonymousClass(String message){
    // Inner anonymous class
    InnerInterface myInnerAnonymousClass = new InnerInterface(){
      @Override
      public void print(String message) {
        System.out.println(this.getClass().getName() + " - Innere Anonyme Klasse sagt: " + message);
      }
    };

    myInnerAnonymousClass.print(message);
  }

  void printFromLambdaFunction(String message){

    InnerInterface myLambdaFunction = (String lambdaMessage) -> {
      System.out.println(this.getClass().getName() + " - Lambda Funktion sagt: " + lambdaMessage);
    };

    myLambdaFunction.print(message);
  }

  void printFromShortenedLambdaFunction(String message){

    SecondInnerInterface myLambdaFunction = () -> System.out.println(this.getClass().getName() + " - Lambda Funktion sagt: " + message);

    myLambdaFunction.print();
  }



  public static void main(String[] args) {
    String message = "Hello World";

    System.out.println(Outerclass.class.getName() + " - Äußere Klasse sagt: " + message);

    Outerclass.InnerTopLevelClass myInnerTopLevelClass = new Outerclass.InnerTopLevelClass();
    myInnerTopLevelClass.print(message);

    Outerclass myOutclass = new Outerclass();
    Outerclass.InnerElementClass myInnerElementClass = myOutclass.new InnerElementClass();
    myInnerElementClass.print(message);

    myOutclass.printFromInnerLocalClass(message);

    myOutclass.printFromInnerAnonymousClass(message);

    myOutclass.printFromLambdaFunction(message);


  }
}
