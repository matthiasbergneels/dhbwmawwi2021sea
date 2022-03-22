package lecture.chapter9;

public class FullName implements Comparable<FullName> {

  private String name;
  private String familyName;

  public FullName(String name, String familyName){
    this.name = name;
    this.familyName = familyName;
  }

  public String getName(){
    return name;
  }

  public String getFamilyName(){
    return familyName;
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

  @Override
  public int hashCode(){
    return familyName.hashCode() + name.hashCode();
  }

  /*
  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
    return result;
  }
   */
}
