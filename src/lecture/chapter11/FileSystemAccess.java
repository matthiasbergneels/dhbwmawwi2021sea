package lecture.chapter11;

import java.io.File;
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
    

  }
}
