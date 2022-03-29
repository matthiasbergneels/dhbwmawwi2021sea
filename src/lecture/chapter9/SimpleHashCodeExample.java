package lecture.chapter9;

public class SimpleHashCodeExample {

  public static void main(String[] args) {
    Point2D myFirstPoint = new Point2D(5,10);
    Point2D mySecondPoint = new Point2D(10,10);
    Point2D myThirdPoint = new Point2D(10,5);
    Point2D myfourthPoint = new Point2D(5,10);

    System.out.println("Equals first and second: " + myFirstPoint.equals(mySecondPoint));
    System.out.println("myFirstPoint HashCode: " + myFirstPoint.hashCode());
    System.out.println("mySecondPoint HashCode: " + mySecondPoint.hashCode());


    System.out.println("Equals first and third: " + myFirstPoint.equals(myThirdPoint));
    System.out.println("myFirstPoint HashCode: " + myFirstPoint.hashCode());
    System.out.println("myThirdPoint HashCode: " + myThirdPoint.hashCode());


    System.out.println("Equals first and fourth: " + myFirstPoint.equals(myfourthPoint));
    System.out.println("myFirstPoint HashCode: " + myFirstPoint.hashCode());
    System.out.println("myfourthPoint HashCode: " + myfourthPoint.hashCode());
  }
}
