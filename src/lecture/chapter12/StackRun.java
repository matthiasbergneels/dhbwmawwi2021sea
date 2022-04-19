package lecture.chapter12;

public class StackRun {

  public static void main(String[] args) {

    Stack<String> myWordStack = new Stack<>();

    myWordStack.push("Brot");
    myWordStack.push("Butter");
    myWordStack.push("Käse");
    myWordStack.push("Salami");
    myWordStack.push("Butter");
    myWordStack.push("Brot");

    System.out.println("Anzahl Elemente auf dem Stack: " + myWordStack.size());

    System.out.println("Aktuelle oberste Element: " + myWordStack.peek());

    while(myWordStack.peek() != null){
      System.out.println("Entnehmen: " + myWordStack.pop());
    }

  }
}
