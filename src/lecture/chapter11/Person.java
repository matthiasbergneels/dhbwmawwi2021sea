package lecture.chapter11;

import java.io.Serializable;

public class Person implements Serializable {

  static final long serialVersionUID = 1L;

  private String name;
  private String familyName;
  private String fullName;

  public Person(String name, String familyName){
    this.name = name;
    this.familyName = familyName;
    this.setFullName();
  }

  private void setFullName(){
    this.fullName = this.familyName + ", " + this.name;
  }

  public String getName(){
    return name;
  }

  public String getFamilyName(){
    return familyName;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", familyName='" + familyName + '\'' +
      ", fullName='" + fullName + '\'' +
      '}';
  }
}
