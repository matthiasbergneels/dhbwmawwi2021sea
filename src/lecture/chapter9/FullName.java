package lecture.chapter9;

public class FullName implements Comparable<FullName> {

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

  @Override
  public int compareTo(FullName o) {

    if(!this.familyName.equals(o.familyName)){
      return this.familyName.compareTo(o.familyName);
    }

    return this.name.compareTo(o.name);
  }

  @Override
  public boolean equals(Object o) {

    if(this == o){
      return true;
    }

    if(o == null){
      return false;
    }

    if(this.getClass() != o.getClass()){
      return false;
    }

    FullName nameToCheck = (FullName)o;

    if(!this.familyName.equals(nameToCheck.familyName)){
      return false;
    }

    if(!this.name.equals(nameToCheck.name)){
      return false;
    }

    return true;
  }

}
