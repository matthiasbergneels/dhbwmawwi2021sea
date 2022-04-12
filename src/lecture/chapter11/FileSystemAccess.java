package lecture.chapter11;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;
import java.util.Set;

public class FileSystemAccess {

  public static void main(String[] args) {

    System.out.println("Liste von Laufwerken / root Verzeichnis: ");
    System.out.println("=========================================");
    File[] rootList = File.listRoots();

    for(File root : rootList){
      System.out.println("Pfad: " + root.getPath());
      System.out.println(" - existiert: " + root.exists());
      System.out.println(" - Lesezugriff: " + root.canRead());
      System.out.println(" - Schreibzugriff: " + root.canWrite());
    }


    //File anyFile = new File("c:\\verzeichnis\\Datei.end");

    System.out.println("System Properties in Java: ");
    System.out.println("=========================================");
    Properties systemProperties = System.getProperties();

    Set systemPropertiesKeys = systemProperties.keySet();
    for(Object key : systemPropertiesKeys){
      System.out.println(key + ": " + systemProperties.get(key));
    }


    System.out.println("Ausgabe von allen Inhalten aus user.dir: ");
    System.out.println("=========================================");

    File userDir = new File(System.getProperty("user.dir"));

    System.out.println("Name: " + userDir.getName());
    System.out.println("Pfad: " + userDir.getPath());
    System.out.println("Existiert: " + userDir.exists());
    System.out.println("Ist Verzeichnis: " + userDir.isDirectory());
    System.out.println("Ist Datei: " + userDir.isFile());

    System.out.println("Inhalt von " + userDir.getName() + ":");
    System.out.println("=====================================");

    listDirectoryAndContent(userDir, 0);


    System.out.println("Umgang mit Verzeichnissen und Dateien");
    System.out.println("=====================================");

    String pathString = System.getProperty("user.dir") + File.separator + "myDirectory";
    String pathRenamedString = System.getProperty("user.dir") + File.separator + "myRenamedDirectory";
    System.out.println(pathString);
    File myDirectory = new File(pathString);
    File myRenamedDirectory = new File(pathRenamedString);

    System.out.println("Existiert: " + myDirectory.exists());

    if(!myDirectory.exists()){
      myDirectory.mkdir();
      System.out.println("Existiert: " + myDirectory.exists());
    }

    if(myDirectory.exists() && !myRenamedDirectory.exists()){
      System.out.println(myDirectory.getName() + " - existiert: " + myDirectory.exists());
      System.out.println(myRenamedDirectory.getName() + " - existiert: " + myRenamedDirectory.exists());
      System.out.println("Umbenennen des Verzeichnis");
      myDirectory.renameTo(myRenamedDirectory);
      System.out.println(myDirectory.getName() + " - existiert: " + myDirectory.exists());
      System.out.println(myRenamedDirectory.getName() + " - existiert: " + myRenamedDirectory.exists());
    } else {
      // myDirectory löschen
    }

    File myFile = new File(myRenamedDirectory.getPath() + File.separator + "myFile.txt");
    File myRenamedFile = new File(myRenamedDirectory.getPath() + File.separator + "myRenamedFile.txt");

    if(!myFile.exists()){
      try {
        System.out.println(myFile.getName() + " - existiert: " + myFile.exists());
        System.out.println("Anlegen der Datei:" + myFile.getName());
        myFile.createNewFile();
        System.out.println(myFile.getName() + " - existiert: " + myFile.exists());
      }catch(IOException e){
        System.out.println("Anlegen der Datei fehlgeschlagen");
        System.out.println(e.getMessage());
      }
    }

    if(myFile.exists() && !myRenamedFile.exists()){
        System.out.println(myFile.getName() + " - existiert: " + myFile.exists());
        System.out.println(myRenamedFile.getName() + " - existiert: " + myRenamedFile.exists());
        System.out.println("Umbenennen der Datei:" + myFile.getName());
        myFile.renameTo(myRenamedFile);
        System.out.println(myFile.getName() + " - existiert: " + myFile.exists());
        System.out.println(myRenamedFile.getName() + " - existiert: " + myRenamedFile.exists());
    }

  }

  private static void listDirectoryAndContent(File currentDirectory, int indentation){
    printlnWithIndentation("+" + currentDirectory.getName() +" - "
      + (currentDirectory.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; "
      +(currentDirectory.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff"), indentation );

    File[] currentDirectoryContent = currentDirectory.listFiles();
    for(File currentFile : currentDirectoryContent){
      if(currentFile.isDirectory()){
        listDirectoryAndContent(currentFile, indentation+1);
      }else if(currentFile.isFile()){
        printlnWithIndentation("-" + currentFile.getName()
          + " - "+ (currentFile.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; "
          +(currentFile.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff") + "; "
          + currentFile.length() + " Byte", indentation+1 );
      }
    }

  }

  private static void printlnWithIndentation(String txt, int indentation){
    String indentationText = "";
    for(int i = 0; i < indentation; i++){
      indentationText += "\t";
    }

    System.out.println(indentationText + txt);
  }
}
