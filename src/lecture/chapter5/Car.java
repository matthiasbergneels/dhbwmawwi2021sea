package lecture.chapter5;

public class Car {

  // Attribute
  private String color;
  protected short hp = 100;
  private String licensePlate = "";
  private int currentSpeed;
  public final String CAR_BRAND;

  // Konstruktor(en)
  public Car(String parameterColor, short parameterHp, String parameterBrand, String parameterLicensePlate){
    color = parameterColor;
    hp = parameterHp;
    CAR_BRAND = parameterBrand;
    licensePlate = parameterLicensePlate;

    currentSpeed = 0;
  }

  // Methoden
  public void accelerate(int accelerationSpeed){
    if(accelerationSpeed < hp / 10){
      currentSpeed = currentSpeed + accelerationSpeed;
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

  public void setLicensePlate(String parameterLicensePlate){
    licensePlate = parameterLicensePlate;
  }

  public void setColor(String parameterColor){
    if(parameterColor.equals("grey")
      || parameterColor.equals("black")
      || parameterColor.equals("green")
      || parameterColor.equals("red")
      || parameterColor.equals("blue")){
      color = parameterColor;
    } else {
      color = "black";
    }

  }
}
