package lecture.chapter6;

public class Dog extends Animal{

  private String breed;

  public Dog(float size, float weight, String description, String breed){
    super(size, weight, description);
    this.breed = breed;
  }

  public void bark(){
    System.out.println("Der Hund " + super.getDescription() + " bellt");
  }

  @Override
  public void eat(){
    System.out.println("Der Hund " + getDescription() + " frisst");
  }

  public void eat(float amount){
    System.out.println("Der Hund " + getDescription() + " frisst " + amount + " g Fleisch");
  }
}
