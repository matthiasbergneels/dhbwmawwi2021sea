package lecture.chapter9;

import lecture.chapter5.Car;
import lecture.chapter5.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListExample {


  public static void main(String[] args) {

    List<String> myNameList = new ArrayList<String>();

    List<Student> myStudentList = new ArrayList<Student>();

    myNameList.add("Klaus");
    myNameList.add("Fritz");
    myNameList.add("Hans-Peter");
    myNameList.add("Klaus");
    myNameList.add("Gabi");
    myNameList.add("Frida");
    //myNameList.add(new Student(4711, "Michael"));  // --> nicht möglich, wegen Typisierung mit Generic
    //myNameList.add(new Car()); // --> nicht möglich, wegen Typisierung mit Generic

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

    // Sequentielle Zugriffe auf Listen

    System.out.println("Sequentieller Zugriff über for-each:");
    for(String myName : myNameList){
      System.out.println(myName);

      /* --> "externe" modification wärend der Iteration ist nicht erlaubt
      if(myName.equals("Klaus")){
        myNameList.remove("Klaus");
      }

       */
    }

    System.out.println("Sequentieller Zugriff über Iterator:");

    Iterator<String> i = myNameList.iterator();
    while(i.hasNext()){
      String name = i.next();
      if(name.equals("Klaus") || name.equals("Frida")){
        i.remove();
        // myNameList.add("Franz"); --> "externe" modification wärend der Iteration ist nicht erlaubt
      }
      System.out.println("Aktueller Name: " + name);
    }

    System.out.println("Anzahl Namen: " + myNameList.size());


    System.out.println("Einfache Datentypen in Containern");

    List<Integer> numbers = new ArrayList<Integer>();

    numbers.add(42);                  // <-- Auto-Boxing von "int" zu "Integer"
    numbers.add(new Integer(42));
    numbers.add(Integer.valueOf(42));
    //numbers.add(3.14);

    Integer myIntObject = numbers.get(0);

    int myNumber = numbers.get(0);  // <-- Auto-Unboxing von "Integer" zu "int"


    List<FullName> fullNameList = new ArrayList<>();

    fullNameList.add(new FullName("Klaus", "Müller"));
    fullNameList.add(new FullName("Gabi", "Schmidt"));
    fullNameList.add(new FullName("Gisela", "Friedhelm"));
    fullNameList.add(new FullName("Klaus", "Müller"));

    System.out.println("FullName List Ausgabe:");
    for(FullName currentFullName : fullNameList){
      System.out.println(currentFullName);
    }

    System.out.println("FullName List Ausgabe - sortiert nach Länge:");
    fullNameList.sort(new SortFullNameBySignCount());

    for(FullName currentFullName : fullNameList){
      System.out.println(currentFullName);
    }


    System.out.println("FullName List Ausgabe - sortiert natürlicher Ordnung:");
    Collections.sort(fullNameList); // FullName MUSS Comparable implementieren --> natürliche Ordnung

    for(FullName currentFullName : fullNameList){
      System.out.println(currentFullName);
    }


    System.out.println("FullName List Ausgabe - sortiert nach Länge:");
    Collections.sort(fullNameList, new SortFullNameBySignCount());

    for(FullName currentFullName : fullNameList){
      System.out.println(currentFullName);
    }

    System.out.println("FullName List Ausgabe - sortiert nach Differenz der Länge von Vor- und Nachname: ");
    Collections.sort(fullNameList, (firstFullName, secondFullName) -> {
      int signCountDifferenceFirstFullName = firstFullName.getFamilyName().length() - firstFullName.getName().length();
      int signCountDifferenceSecondFullName = secondFullName.getFamilyName().length() - secondFullName.getName().length();
      return signCountDifferenceFirstFullName - signCountDifferenceSecondFullName;
    });

    for(FullName currentFullName : fullNameList){
      System.out.println(currentFullName);
    }
  }
}
