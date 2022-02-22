package lecture.chapter7;

import lecture.chapter8.BookableEntityIsBurnedDownException;
import lecture.chapter8.NotEnoughFreeSlotsException;

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
      try {
        System.out.println("Freie Plätze: " + currentBookableEntity.freeSlots());

        currentBookableEntity.bookSlots(50);
        System.out.println("Buchen hat geklappt.");

        System.out.println("Feier Plätze: " + currentBookableEntity.freeSlots());

      } catch(NotEnoughFreeSlotsException e){
        System.out.println("Buchen hat NICHT geklappt!");
        System.out.println(e.getMessage());

        System.out.println("Es könnten " + e.getFreeSlots() + " gebucht werden oder man sucht Alternativen.");

        return;
        /*
        try {
          System.out.println("Buche verbleibende freie Plätze:");
          currentBookableEntity.bookSlots(e.getFreeSlots());
          System.out.println("Zweite Buchung hat geklappt!");
        } catch(NotEnoughFreeSlotsException e1){
          // Should not happen!
          System.out.println("Zweite Buchung ist auch fehlgeschlagen!");
        }
         */

      } catch (Exception e){
        // Catch All
        System.out.println("Das war Pech");
      } finally {
        System.out.println("Finally wird IMMER ausgeführt!");
      }



      System.out.println("Priority Booking: " + currentBookableEntity.prioritySlotBooking(100));
    }

    Plane myPlane = new Plane(5);
    Object myObject = myPlane;

    System.out.println("Ist mein Flugzeug buchbar? " + (myObject instanceof Bookable));
    Bookable myBookableEntity = (Bookable) myObject;

  }

}
