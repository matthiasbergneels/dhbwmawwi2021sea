package lecture.chapter5.familie;

public class Kind {

  private final Mann vater;
  private final Frau mutter;

  Kind(Mann vater, Frau mutter){
    if(vater != null){
      this.vater = vater;
    } else {
      this.vater = new Mann();
    }

    if(mutter != null){
      this.mutter = mutter;
    } else {
      this.mutter = new Frau();
    }

    // TODO: Kind bei Vater und Mutter setzen
  }


}
