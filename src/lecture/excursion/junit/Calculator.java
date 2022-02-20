package lecture.excursion.junit;

public class Calculator {

  public double add(double numberA, double numberB){
    return numberA + numberB;
  }

  public double subtract(double numberA, double numberB){
    return numberA - numberB;
  }

  public double multiply(double numberA, double numberB){
    return numberA * numberB;
  }

  public double divide(double numberA, double numberB) throws ArithmeticException {
    if (numberB == 0) {
      throw new ArithmeticException("Division by 0 not allowed");
    }
    return numberA / numberB;
  }
}
