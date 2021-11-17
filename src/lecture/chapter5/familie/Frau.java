package lecture.chapter5.familie;

public class Frau {

  private Mann ehemann;
  private Kind[] kinder;

  public Frau(){
    kinder = new Kind[10];
  }

  public Mann getEhemann() {
    return ehemann;
  }

  public void setEhemann(Mann ehemann) {
    this.ehemann = ehemann;
  }
}
