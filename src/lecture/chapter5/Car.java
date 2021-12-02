package lecture.chapter5;

public class Car {

  // Instanz Attribute
  private String color;
  protected short hp = 100;
  private String licensePlate = "";
  private int currentSpeed;
  public final CarBrands CAR_BRAND;

  // Klassen Attribut(e)
  private static int carCount;

  // öffentliche Konstanten
  public static final String ALLOWED_COLOR_RED = "RED";
  public static final String ALLOWED_COLOR_BLUE = "BLUE";
  public static final String ALLOWED_COLOR_GREEN = "GREEN";
  public static final String ALLOWED_COLOR_BLACK = "BLACK";
  public static final String ALLOWED_COLOR_GREY = "GREY";

  public enum CarBrands{
    Mercedes, Volvo, BMW, Fiat, Skoda, Audi
  }


  // Konstruktor(en)

  public Car(String color, short hp, CarBrands brand, String licensePlate){
    this.setColor(color);
    this.hp = hp;
    this.CAR_BRAND = brand;
    this.setLicensePlate(licensePlate);

    this.currentSpeed = 0;

    carCount++;
  }

  public Car(){
    this(Car.ALLOWED_COLOR_BLACK, (short) 150, CarBrands.Fiat, "");
  }

  public Car(String color){
    this(color, (short) 150, CarBrands.Fiat, "");
  }

  public Car(short hp){
    this(Car.ALLOWED_COLOR_BLACK, hp, CarBrands.Fiat, "");
  }

  // Methoden
  public void accelerate(int accelerationSpeed){
    if(accelerationSpeed < hp / 10){
      this.currentSpeed = this.currentSpeed + accelerationSpeed;
    } else {
      currentSpeed = currentSpeed + hp / 10;
    }
  }

  public void brake(){
    currentSpeed = currentSpeed - 10;
    if(currentSpeed < 0){
      currentSpeed = 0;
    }
  }

  public void fullBrake(){
    currentSpeed = 0;
  }


  // Getter- und Setter-Methode
  /* --> unnötig, weil Konstante (kann nicht mehr verändert werden
  String getCAR_BRAND(){
    return CAR_BRAND;
  }
   */

  public int getCurrentSpeed(){
    return currentSpeed;
  }

  public String getColor() {
    return color;
  }

  public short getHp() {
    return hp;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate){
    this.licensePlate = licensePlate;
  }

  public void setColor(String color){
    if(color.equals(ALLOWED_COLOR_GREY)
      || color.equals(ALLOWED_COLOR_BLACK)
      || color.equals(ALLOWED_COLOR_GREEN)
      || color.equals(ALLOWED_COLOR_RED)
      || color.equals(ALLOWED_COLOR_BLUE)){
      this.color = color;
    } else {
      this.color = ALLOWED_COLOR_BLACK;
    }

  }

  protected void finalize(){
    System.out.println("Das " + this.color + " Auto wurde verschrottet!");
    carCount--;
  }

  @Override
  public String toString() {
    return "Car{" +
      "color='" + color + '\'' +
      ", hp=" + hp +
      ", licensePlate='" + licensePlate + '\'' +
      ", currentSpeed=" + currentSpeed +
      ", CAR_BRAND=" + CAR_BRAND +
      '}';
  }

  // Klassenmethode(n)

  public static int getCarCount(){
    return carCount;
  }
}
