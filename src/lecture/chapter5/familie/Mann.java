package lecture.chapter5.familie;

public class Mann {

  private Frau ehefrau;
  private Kind[] kinder;

  public Mann(){
    kinder = new Kind[10];
  }

  public Frau getEhefrau() {
    return ehefrau;
  }

  public void setEhefrau(Frau ehefrau) {
    this.ehefrau = ehefrau;
  }
}
