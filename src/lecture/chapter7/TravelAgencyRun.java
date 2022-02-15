package lecture.chapter7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelAgencyRun {

  public static void main(String[] args) {



    Bookable[] bookableEntities = new Bookable[5];

    // Narrowing Cast --> Sichtbarkeit auf "Fähigkeiten" von Bookable eingeschränkt
    bookableEntities[0] = new Plane(100);
    bookableEntities[1] = new Hotel(250);
    bookableEntities[2] = new Hotel(10);
    bookableEntities[3] = new Plane(500);
    bookableEntities[4] = new Hotel(200);


    for(Bookable currentBookableEntity : bookableEntities){
      // Polymorphie durch Interfaces

      System.out.println("Feier Plätze: " + currentBookableEntity.freeSlots());

      boolean booked = currentBookableEntity.bookSlots(50);

      System.out.println("Buchen hat geklappt: " + booked);

      System.out.println("Feier Plätze: " + currentBookableEntity.freeSlots());

      System.out.println("Priority Booking: " + currentBookableEntity.prioritySlotBooking(100));
    }

    Plane myPlane = new Plane(5);
    Object myObject = myPlane;

    System.out.println("Ist mein Flugzeug buchbar? " + (myObject instanceof Bookable));
    Bookable myBookableEntity = (Bookable) myObject;

  }

}
