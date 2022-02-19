package lecture.excursion.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

  @Nested
  @DisplayName("Tests for add Method")
  class addTests {
    @Test
    @DisplayName("adding two numbers")
    void add() {
      System.out.println("testen der add Methode");
      double result = testCalculator.add(10.0, 10.0);

      assertEquals(20.0, result);
    }

    @Test
    @DisplayName("adding two integer numbers")
    void addTestWithInteger() {
      System.out.println("testen der add Methode");
      double result = testCalculator.add(10, 10);

      assertEquals(20.0, result);
    }

    @Test
    @DisplayName("adding numbers as negativ test")
    void addWithNegativTest() {
      System.out.println("testen der add Methode");
      double result = testCalculator.add(10, 10);

      assertNotEquals(99.0, result);
    }

    @Test
    @DisplayName("adding two large numbers")
    void addWithLargeNumbers() {
      System.out.println("testen der add Methode");
      double result = testCalculator.add(50000000000000000.0, 10.0);

      assertEquals(50000000000000010.0, result);
    }
  }

  @Test
  @DisplayName("subtract two numbers")
  void subtract() {
    System.out.println("testen der subtract Methode");
    double result = testCalculator.subtract(10.0, 10.0);

    assertEquals(0.0, result);
  }

  @ParameterizedTest(name = "{0} minus {1} should result in {2}")
  @DisplayName("paramterized Subtract")
  @CsvSource({
    "10.0, 5.0, 5.0",
    "15.0, 8.0, 7.0",
    "18, 20, -2",
    "10000000, -1, 10000001"
  })
  void paramterizedSubtract(double numberA, double numberB, double expectedResult){
    double result = testCalculator.subtract(numberA, numberB);

    assertEquals(expectedResult, result);
  }

  @Test
  @DisplayName("mulitply two numbers")
  void multiply() {
    double result = testCalculator.multiply(5.0, 5.0);

    assertEquals(25.0, result);
  }
}