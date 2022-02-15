package lecture.excursion.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test Class")
class CalculatorTest {

  Calculator testCalculator;

  @BeforeEach
  void setUp() {
    System.out.println("Läuft vor jedem Test");
    testCalculator = new Calculator();
  }

  @AfterEach
  void tearDown() {
    System.out.println("Läuft nach jedem Test");
    testCalculator = null;
  }

  @Test
  @DisplayName("adding two numbers")
  void add() {
    System.out.println("testen der add Methode");
    double result = testCalculator.add(10.0, 10.0);

    assertEquals(20.0, result);
  }

  @Test
  @DisplayName("subtract two numbers")
  void subtract() {
    System.out.println("testen der subtract Methode");
    double result = testCalculator.subtract(10.0, 10.0);

    assertEquals(0.0, result);
  }

  @Test
  @DisplayName("mulitply two numbers")
  void multiply() {
    double result = testCalculator.multiply(5.0, 5.0);

    assertEquals(25.0, result);
  }
}