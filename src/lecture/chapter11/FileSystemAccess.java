package lecture.chapter11;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
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
      myDirectory.delete();
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
    }else {
      myFile.delete();
    }


    System.out.println("Einlesen von Daten über System.in (Bytes)");
    System.out.println("=====================================");

    System.out.println("Geben Sie einen Text ein:");

    byte[] input = new byte[255];

    try{
      System.in.read(input, 0, 255);
    }catch(IOException e){
      System.out.println("Fehler bei der Eingabe " + e.getMessage());
    }

    System.out.println(input);
    System.out.println(new String(input));

    System.out.println("Einlesen von Daten über System.in (Char)");
    System.out.println("=====================================");

    InputStreamReader systemInReader = new InputStreamReader(System.in);
    BufferedReader systemInBufferedReader = new BufferedReader(systemInReader);

    String inputString = "";
    ArrayList<String> inputTextLines = new ArrayList<>();

    System.out.println("Bitte geben Sie einen Text ein (Beenden mit exit):");

    while(true){
      try{
        inputString = systemInBufferedReader.readLine();
        if(inputString.equals("exit")){
          break;
        }
        System.out.println(inputString);
        inputTextLines.add(inputString);
      } catch(IOException e){
        System.out.println("Fehler bei der Eingabe " + e.getMessage());
      }
    }

    System.out.println("Vollständiger Text:");
    for(String line : inputTextLines){
      System.out.println(line);
    }

    FileWriter myTextFileWriter = null;

    try {
      myTextFileWriter = new FileWriter(myRenamedFile);

      for(String line : inputTextLines){
        myTextFileWriter.write(line + "\n");
      }
    }catch (IOException e){
      System.out.println("Fehler beim schreiben der Datei " + e.getMessage());
    } finally {
      try {
        myTextFileWriter.close();
      }catch(IOException e){
        System.out.println("Fehler beim schliessen der Datei " + e.getMessage());
      }
    }

    System.out.println("Auslesen aus Datei");
    System.out.println("=====================================");

    try(FileReader myTextFileReader = new FileReader(myRenamedFile);
        BufferedReader myTextFileBufferedReader = new BufferedReader(myTextFileReader)){

      String line;

      while((line = myTextFileBufferedReader.readLine()) != null){
        System.out.println(line);
      }

    }catch(IOException e){
      System.out.println("Fehler beim auslesen der Datei " + e.getMessage());
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
