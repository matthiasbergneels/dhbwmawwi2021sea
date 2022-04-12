package lecture.chapter11;

import java.io.*;
import java.util.ArrayList;

public class PersistPersons {

  public static void main(String[] args) {

    ArrayList<Person> personList = new ArrayList<>();

    personList.add(new Person("Klaus", "Müller"));
    personList.add(new Person("Gabi", "Fritz"));
    personList.add(new Person("Hans", "Zeus"));
    personList.add(new Person("Michaela", "Amadeus"));


    System.out.println("Manuelle Serialisierung / Deserialisierung: ");
    File myPersonFile = new File(System.getProperty("user.dir") + File.separator + "persons.txt");

    if(!myPersonFile.exists()){
      try {
        myPersonFile.createNewFile();
      }catch(IOException e){
        System.out.println("Fehler beim Anlegen der Datei.");
        return;
      }
    }

    try(FileWriter myPersonFileWriter = new FileWriter(myPersonFile)){
      for(Person currentPerson : personList){
        // manuelle Serialisierung
        myPersonFileWriter.write(currentPerson.getFamilyName() + "," + currentPerson.getName() + "\n");
      }
    }catch(IOException e){
      System.out.println("Fehler beim Schreiben der Datei");
    }

    ArrayList<Person> personFromFileList = new ArrayList<>();


    try(FileReader myTextFileReader = new FileReader(myPersonFile);
        BufferedReader myTextFileBufferedReader = new BufferedReader(myTextFileReader)){

      String line;

      while((line = myTextFileBufferedReader.readLine()) != null){
        System.out.println("Gelesen von PersonFile: " + line);

        // manuelle De-Serialisierung
        String[] personNames = line.split(",");
        personFromFileList.add(new Person(personNames[1], personNames[0]));
      }

    }catch(IOException e){
      System.out.println("Fehler beim auslesen der Datei " + e.getMessage());
    }

    System.out.println("Ausagbe der Ausgelesenen Personen");
    for(Person currentPerson : personFromFileList){
      System.out.println(currentPerson);
    }


    System.out.println("Java Serializable:");

    File mySerializedPersonFile = new File(System.getProperty("user.dir") + File.separator + "persons.dat");

    if(!mySerializedPersonFile.exists()){
      try {
        mySerializedPersonFile.createNewFile();
      }catch(IOException e){
        System.out.println("Fehler beim Anlegen der Datei.");
        return;
      }
    }

    try(FileOutputStream personFileOutputStream = new FileOutputStream(mySerializedPersonFile);
        ObjectOutputStream personObjectOutputStream = new ObjectOutputStream(personFileOutputStream)){

      for(Person currentPerson : personList){
        // Java Serializierung
        personObjectOutputStream.writeObject(currentPerson);
      }


    }catch(IOException e){
      System.out.println("Fehler beim schreiben der Object Dat");
    }



    try(FileInputStream personFileInputStream = new FileInputStream(mySerializedPersonFile);
        ObjectInputStream personObjectInputStream = new ObjectInputStream(personFileInputStream)){

      while(true){
        try {
          System.out.println(personObjectInputStream.readObject());
        } catch (EOFException e) {
          break;
        }
      }

    }catch(IOException e){
      System.out.println("Fehler beim auslesen der Object Datei");
    }catch(ClassNotFoundException e){

    }


  }
}
