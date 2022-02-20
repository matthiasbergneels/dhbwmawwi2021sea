package lecture.excursion.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test Class")
class CalculatorTest {

  Calculator testCalculator;

  @BeforeEach
  void setUp() {
    testCalculator = new Calculator();
  }

  @AfterEach
  void tearDown() {
    testCalculator = null;
  }

  @Nested
  @DisplayName("Tests for add Method")
  class addTests {
    @Test
    @DisplayName("adding two numbers")
    void add() {
      double result = testCalculator.add(10.0, 10.0);

      assertEquals(20.0, result);
    }

    @Test
    @DisplayName("adding two integer numbers")
    void addTestWithInteger() {
      double result = testCalculator.add(10, 10);

      assertEquals(20.0, result);
    }

    @Test
    @DisplayName("adding numbers as negativ test")
    void addWithNegativTest() {
      double result = testCalculator.add(10, 10);

      assertNotEquals(99.0, result);
    }

    @Test
    @DisplayName("adding two large numbers")
    void addWithLargeNumbers() {
      double result = testCalculator.add(50000000000000000.0, 10.0);

      assertEquals(50000000000000010.0, result);
    }
  }

  @Test
  @DisplayName("subtract two numbers")
  void subtract() {
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

  @Nested
  @DisplayName("Multipiply Test Cases")
  class MultiplyTestCases {

    @ParameterizedTest(name = "{0} multiplied {1} should be {2}")
    @DisplayName("Multiply Test")
    @CsvSource({
      "10.0, 10.0, 100.0",
      "5.0, 10.0, 50.0",
      "10.0, 0.0, 0.0"
    })
    void multiply(double numberA, double numberB, double expectedResult) {
      assertEquals(expectedResult, testCalculator.multiply(numberA, numberB));
    }

    @ParameterizedTest(name = "{0} multiplied {1} should be {2}")
    @DisplayName("Multiply Test from MethodSource")
    @MethodSource("lecture.excursion.junit.CalculatorTest#provideMultiplyTestCases")
    void multiplyWithDataFromMethod(double numberA, double numberB, double expectedResult) {
      assertEquals(expectedResult, testCalculator.multiply(numberA, numberB));
    }
  }

  @Test
  @DisplayName("Divide by 0 exception test")
  void subtractWithException(){
    ArithmeticException resultException = assertThrows(ArithmeticException.class, () -> {
      testCalculator.divide(100.0, 0.0);
    });

    assertEquals("Division by 0 not allowed", resultException.getMessage());
  }


  static Stream provideMultiplyTestCases(){
    return Stream.of(
      Arguments.of(10.0, 10.0, 100.0),
      Arguments.of(5.0, 4.0, 20.0)
      // ... additional Test cases
    );
  }

}