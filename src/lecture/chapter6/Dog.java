package lecture.chapter6;

public final class Dog extends Animal{

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
    super.eat();
    System.out.println("Fleisch");
  }

  // Überladene Methode aus Animal (eat())
  public void eat(float amount){
    this.eat();
    System.out.println("und zwar " + amount + " Gramm");
  }

  @Override
  public void breath(){
    System.out.println("Der Hund " + getDescription() + " atmet!");
  }

  @Override
  public String toString(){
    return super.toString()
          + "; Rasse: " + breed;
  }
}
