package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

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