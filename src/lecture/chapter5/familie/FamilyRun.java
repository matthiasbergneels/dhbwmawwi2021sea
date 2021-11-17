package lecture.chapter5.familie;

public class FamilyRun {

  public static void main(String[] args) {

    Mann klaus = new Mann();
    Frau gabi = new Frau();

    // verheiraten
    gabi.setEhemann(klaus);
    klaus.setEhefrau(gabi);

    // scheiden
    gabi.setEhemann(null);
    klaus.setEhefrau(null);



  }
}
