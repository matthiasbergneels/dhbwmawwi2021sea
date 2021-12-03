package lecture.chapter7;

import java.util.TreeSet;

public class Plane extends Object implements Bookable, Comparable, Cloneable{

  private boolean[] seats; // --> true = besetzt, false = frei

  public Plane(int seatCount){
    seats = new boolean[seatCount];
  }

  public void fly (){
    System.out.println("und ich flieg, flieg, flieg, ...");
  }

  @Override
  public boolean bookSlots(int slots) {

    if(freeSlots() >= slots){
      for(int i = 0; i < seats.length; i++){
        if(!seats[i]){
          seats[i] = true;
          slots--;
        }

        if(slots == 0){
          return true;
        }
      }
    }

    return false;
  }

  @Override
  public int freeSlots() {
    int freeSlots = 0;

    for(boolean seat : seats){
      if(!seat){
        freeSlots++;
      }
    }

    return freeSlots;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
