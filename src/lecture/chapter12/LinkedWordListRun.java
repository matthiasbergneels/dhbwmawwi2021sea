package lecture.chapter12;

public class LinkedWordListRun {

  public static void main(String[] args) {

    LinkedWordList myWords = new LinkedWordList();

    System.out.println("Anzahl Element: " + myWords.size());

    System.out.println("Enthält Kabelbruch: " + myWords.contains("Kabelbruch"));

    myWords.add("Kabelbruch");
    myWords.add("Sesambrot");
    myWords.add("Schimmelkruste");
    myWords.add("Kabelbruch");
    myWords.add("Sesambrot");
    myWords.add("Schimmelkruste");
    myWords.add("Kabelbruch");
    myWords.add("Sesambrot");
    myWords.add("Schimmelkruste");

    System.out.println("Enthält Kabelbruch: " + myWords.contains("Kabelbruch"));
    System.out.println("Enthält Käsekuchen: " + myWords.contains("Käsekuchen"));

    System.out.println("Anzahl Element: " + myWords.size());

    myWords.remove("Kabelbruch");
    myWords.remove("Schimmelkruste");
    myWords.remove("Himmelbett");

    System.out.println("Anzahl Element: " + myWords.size());

    myWords.printWordList();


  }
}
