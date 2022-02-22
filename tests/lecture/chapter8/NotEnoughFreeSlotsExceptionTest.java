package lecture.chapter8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotEnoughFreeSlotsExceptionTest {

  @Test
  void getFreeSlots() {
    NotEnoughFreeSlotsException missingSlotsException = new NotEnoughFreeSlotsException(50, 10);
    Assertions.assertEquals(10, missingSlotsException.getFreeSlots());
  }

  @Test
  void exceoptionObjectMessageTest(){
    NotEnoughFreeSlotsException missingSlotsException = new NotEnoughFreeSlotsException(50, 10);

    Assertions.assertNotNull(missingSlotsException);
    Assertions.assertEquals("Es wurde versucht 50 Plätze zu buchen, aber es sind nur 10 Plätze frei.", missingSlotsException.getMessage());
  }
}