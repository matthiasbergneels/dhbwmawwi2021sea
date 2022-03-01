package lecture.chapter9;

import java.util.ArrayList;
import java.util.List;

public class ListExample {


  public static void main(String[] args) {

    List myNameList = new ArrayList();

    myNameList.add("Klaus");
    myNameList.add("Fritz");
    myNameList.add("Hans-Peter");
    myNameList.add("Klaus");
    myNameList.add("Gabi");
    myNameList.add("Frida");

    System.out.println("Name Index 2: " + myNameList.get(2));
    System.out.println("Enthält Fritz? " + myNameList.contains("Fritz"));
    System.out.println("Anzahl Namen: " + myNameList.size());

    for(int i = 0; i < myNameList.size(); i++){
      System.out.println(myNameList.get(i));
    }

    System.out.println("Enthält Klaus? " + myNameList.contains("Klaus"));
    myNameList.remove("Klaus");
    System.out.println("Anzahl Namen: " + myNameList.size());

    System.out.println("Name Index 0: " + myNameList.get(0));
    myNameList.remove(0);
    System.out.println("Name Index 0: " + myNameList.get(0));

    for(int i = 0; i < myNameList.size(); i++){
      System.out.println(myNameList.get(i));
    }


  }
}
