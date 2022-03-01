package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

  @Test
  void bookSlotsThrowsNotEnoughFreeSlotsExceptionOwnClass(){
    int slots = 50;

    NotEnoughFreeSlotsException missingsSlotsException =
      Assertions.assertThrows(NotEnoughFreeSlotsException.class, new NotEnougfhFreeSlotsInHotelExecutable(slots));

    Assertions.assertEquals("Es wurde versucht 51 Plätze zu buchen, aber es sind nur 50 Plätze frei.",
                      missingsSlotsException.getMessage());
  }

  @Test
  void bookSlotsThrowsNotEnoughFreeSlotsExceptionAnonymousClass(){
    int slots = 50;

    /*
    Executable myAnonymousHotelExceptionClass = new Executable() {
      @Override
      public void execute() throws Throwable {
        Hotel myHotel = new Hotel(slots);
        myHotel.bookSlots(slots + 1);
      }
    };

    Assertions.assertThrows(NotEnoughFreeSlotsException.class, myAnonymousHotelExceptionClass);
    */

    Assertions.assertThrows(NotEnoughFreeSlotsException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        Hotel myHotel = new Hotel(slots);
        myHotel.bookSlots(slots + 1);
      }
    });
  }

  @Test
  void bookSlotsThrowsNotEnoughFreeSlotsException() {
    int slots = 50;

    Hotel testingHotelObject = new Hotel(slots);

    NotEnoughFreeSlotsException missingSlotsException = Assertions.assertThrows(NotEnoughFreeSlotsException.class, () -> {
      testingHotelObject.bookSlots(slots+1);
    });

    Assertions.assertNotNull(missingSlotsException);
    Assertions.assertEquals("Es wurde versucht 51 Plätze zu buchen, aber es sind nur 50 Plätze frei.", missingSlotsException.getMessage());
  }

  @Test
  void bookSlotsDontThrowsNotEnoughFreeSlotsException() {
    int slots = 50;

    Hotel testingHotelObject = new Hotel(slots);

    Assertions.assertDoesNotThrow(() -> {
      testingHotelObject.bookSlots(slots);
    });
  }
}