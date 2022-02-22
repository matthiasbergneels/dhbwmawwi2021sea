package lecture.chapter8;

public class NotEnoughFreeSlotsException extends Exception{

  private int freeSlots;

  public NotEnoughFreeSlotsException(int slotsToBook, int freeSlots){
    super("Es wurde versucht " + slotsToBook + " Plätze zu buchen, aber es sind nur " + freeSlots + " Plätze frei.");
    this.freeSlots = freeSlots;
  }

  public int getFreeSlots(){
    return freeSlots;
  }

}
