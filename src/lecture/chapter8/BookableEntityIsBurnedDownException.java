package lecture.chapter8;

public class BookableEntityIsBurnedDownException extends Exception {

  public BookableEntityIsBurnedDownException(){
    super("Buchbare Entität ist abgebrannt");
  }
}
