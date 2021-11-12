package lecture.chapter5;

public class Student {

  private int studentId;
  private String name;

  public Student(int studentId, String name) {
    this.studentId = studentId;
    this.name = name;
  }

  public int getStudentId() {
    return studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void drink(float amount){
    System.out.println(this.name + " trinkt " + amount + " l");
  }

  public void drink(float amount, float percentageOfAlcohol){
    this.drink(amount);
    System.out.println("und wird betrunken" );
  }

  public void drink(float amount, boolean poisned){
    this.drink(amount);
    if(poisned){
      System.out.println("und stirbt!");
    }
  }

  /*
  public void drink(float amount, double percentageOfAlcohol){
    System.out.println(this.name + " trinkt " + amount + " l und wird betrunken" );
  }

  public void drink(double amount, float percentageOfAlcohol){
    System.out.println(this.name + " trinkt " + amount + " l und wird betrunken" );
  }

   */
}
