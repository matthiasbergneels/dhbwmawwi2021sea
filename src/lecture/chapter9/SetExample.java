package lecture.chapter9;

import java.util.HashSet;
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


    System.out.println("Eigene Objekte verwalten: ");

    Set<FullName> setOfFullNames = new TreeSet<FullName>();

    FullName zeusOne = new FullName("Zeus", "Göttlich");
    FullName zeusTwo = new FullName("Zeus", "Göttlich");
    FullName zeusThree = zeusOne;

    System.out.println("ZeusOne equals ZeusTwo? " + zeusOne.equals(zeusTwo));
    System.out.println("ZeusOne ==  ZeusTwo? " + (zeusOne == zeusTwo));
    System.out.println("ZeusOne equals ZeusThree? " + zeusOne.equals(zeusThree));
    System.out.println("ZeusOne ==  ZeusThree? " + (zeusOne == zeusThree));

    System.out.println("ZeusOne hashCode(): " + zeusOne.hashCode());
    System.out.println("ZeusTwo hashCode(): " + zeusTwo.hashCode());
    System.out.println("ZeusThree hashCode(): " + zeusThree.hashCode());

    setOfFullNames.add(new FullName("Volker", "Schmidt"));
    setOfFullNames.add(new FullName("Gabi", "Michels"));
    setOfFullNames.add(zeusOne);
    setOfFullNames.add(new FullName("Franz", "Michels"));
    setOfFullNames.add(zeusTwo);
    setOfFullNames.add(zeusOne);


    for(FullName currentName : setOfFullNames){
      System.out.println(currentName);
    }

  }
}
