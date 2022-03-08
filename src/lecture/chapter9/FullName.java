package lecture.chapter9;

public class FullName {

  private String name;
  private String familyName;

  public FullName(String name, String familyName){
    this.name = name;
    this.familyName = familyName;
  }

  @Override
  public String toString() {
    return familyName + ", " + name;
  }
}
