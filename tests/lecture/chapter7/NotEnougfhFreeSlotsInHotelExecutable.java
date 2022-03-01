package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;
import org.junit.jupiter.api.function.Executable;

public class NotEnougfhFreeSlotsInHotelExecutable implements Executable {
  private int freeSlots;
  private Hotel myHotel;

  public NotEnougfhFreeSlotsInHotelExecutable(int freeSlots){
    myHotel = new Hotel(freeSlots);
    this.freeSlots = freeSlots;
  }

  @Override
  public void execute() throws Throwable {
    myHotel.bookSlots(freeSlots + 1);
  }
}
