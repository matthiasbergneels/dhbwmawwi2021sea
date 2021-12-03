package lecture.chapter7;

public interface Bookable {

  public boolean bookSlots(int slots);
  public int freeSlots();

  // default Implementierung für Interface Methoden um das Interface abwärtskompatibel zu halten
  public default boolean reserveSlots(int slots){
    return false;
  };

  public default boolean prioritySlotBooking(int slots){
    return false;
  };

}
