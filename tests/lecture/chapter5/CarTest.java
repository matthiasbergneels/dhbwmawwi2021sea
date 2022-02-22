package lecture.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

  @Test
  void getCarCount() {
    Car firstCar = new Car("kackbraun", (short)250, Car.CarBrands.Mercedes, "HD-XX 1234");
    Car secondCar = new Car(Car.ALLOWED_COLOR_RED, (short)100, Car.CarBrands.Audi, "MA-VV 5678");

    Assertions.assertEquals(2, Car.getCarCount());
  }
}