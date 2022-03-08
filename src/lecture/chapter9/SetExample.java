package lecture.chapter9;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

  public static void main(String[] args) {


    Set<String> setOfNames = new TreeSet<String>();

    setOfNames.add("Klaus");
    setOfNames.add("Gabi");
    setOfNames.add("Frida");
    setOfNames.add("Zeus");
    setOfNames.add("Klaus");
    setOfNames.add("Michael");

    System.out.println("Anzahl Namen: " + setOfNames.size());
    System.out.println("Enthält Gabi: " + setOfNames.contains("Gabi"));
    System.out.println("Entferne Michael: " + setOfNames.remove("Michael"));
    System.out.println("Entferne Franz: " + setOfNames.remove("Franz"));
    System.out.println("Anzahl Namen: " + setOfNames.size());

    // setOfNames.get(0); --> kein wahlfreier Zugriff

    System.out.println("Sequentielle Ausgabe for-each");
    for(String name : setOfNames){
      System.out.println(name);
    }

    setOfNames.add("Volker");

    System.out.println("Sequentielle Ausgabe Iterator:");
    Iterator<String> i = setOfNames.iterator();
    while(i.hasNext()){
      String name = i.next();

      System.out.println(name);
    }

  }
}
