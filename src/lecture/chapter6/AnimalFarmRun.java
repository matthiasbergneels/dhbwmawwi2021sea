package lecture.chapter6;

public class AnimalFarmRun {

  public static void main(String[] args) {

    Animal myAnimal = new Animal(50f, 15f, "Fred");

    myAnimal.eat();
    myAnimal.move();
    myAnimal.breath();

    Dog myDog = new Dog(70f, 50f, "Bello", "Pudel");

    myDog.move();
    myDog.eat();
    myDog.eat(500f);
    myDog.breath();
    myDog.bark();

    Bird myBird = new Bird(5f, 10f, "Tweety", true);

    myBird.eat();
    myBird.move();
    myBird.breath();
    myBird.tweet();

  }
}
