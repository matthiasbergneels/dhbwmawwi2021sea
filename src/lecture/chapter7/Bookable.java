package lecture.chapter7;

import lecture.chapter8.BookableEntityIsBurnedDownException;
import lecture.chapter8.NotEnoughFreeSlotsException;

public interface Bookable {

  public void bookSlots(int slots) throws NotEnoughFreeSlotsException, BookableEntityIsBurnedDownException;
  public int freeSlots();

  // default Implementierung für Interface Methoden um das Interface abwärtskompatibel zu halten
  public default boolean reserveSlots(int slots){
    return false;
  }

  public default boolean prioritySlotBooking(int slots){
    return false;
  }

}
