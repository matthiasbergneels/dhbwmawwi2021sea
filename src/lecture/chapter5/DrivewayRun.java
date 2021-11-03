package lecture.chapter5;

public class DrivewayRun {

  public static void main(String[] args) {


    // Car myCar; deklarieren einer Variable vom Typ "Car" um mit einem Objekt von Car zu interagieren
    // new Car(); erzeugt ein neues (individuelles) Object von der Klasse Car
    Car myCar = new Car("grey", (short)250, "Volvo", "HD-XX 1234");
    Car yourCar = new Car("green", (short)100, "Opel", "MA-VV 5678");

    myCar.hp = 400;


    // myCar.brand = "Mercedes"; --> funktioniert nicht, da brand eine Konstante ist
    // myCar.color = "kackbraun"; --> funktioniert nicht, da color private ist (nicht sichtbar)
    myCar.setColor("kackbraun");

    //yourCar.color = "green";
    //yourCar.brand = "Opel";

    System.out.println(myCar.getColor() + " - " + myCar.CAR_BRAND + "; " + myCar.getHp() + "; " + myCar.getLicensePlate());
    System.out.println(yourCar.getColor() + " - " + yourCar.CAR_BRAND + "; " + yourCar.getHp() + "; " + yourCar.getLicensePlate());



    myCar.accelerate(32000);   // Java Quellcode: myCar.accelerate(50);
    myCar.accelerate(10);

    System.out.println(myCar.CAR_BRAND + " fährt aktuell mit " + myCar.getCurrentSpeed() + " km/h");
    System.out.println(yourCar.CAR_BRAND + " fährt aktuell mit " + yourCar.getCurrentSpeed() + " km/h");

    myCar.brake();
    myCar.brake();

    // myCar.currentSpeed = 32000; --> funktioniert nicht, da currentSpeed private ist (nicht sichtbar)

    yourCar.accelerate(15);

    System.out.println(myCar.CAR_BRAND + " fährt aktuell mit " + myCar.getCurrentSpeed() + " km/h");
    System.out.println(yourCar.CAR_BRAND + " fährt aktuell mit " + yourCar.getCurrentSpeed() + " km/h");

    myCar.fullBrake();

    System.out.println(myCar.CAR_BRAND + " fährt aktuell mit " + myCar.getCurrentSpeed() + " km/h");
    System.out.println(yourCar.CAR_BRAND + " fährt aktuell mit " + yourCar.getCurrentSpeed() + " km/h");
  }
}