package lecture.chapter6;

public class AnimalFarmRun {

  public static void main(String[] args) {

    /*
    Animal myAnimal = new Animal(50f, 15f, "Fred");

    myAnimal.eat();
    myAnimal.move();
    myAnimal.breath();
     */

    Dog myDog = new Dog(50f, 30f, "Bello", "Pudel");
    Dog yourDog = new Dog(70f, 50f, "Wuffy", "Schäferhund");

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

    System.out.println(myDog.toString());
    System.out.println(yourDog.toString());

    Dog anyDog = myDog;
    System.out.println(anyDog); // --> impliziter Aufruf von toString()

    System.out.println(myBird);


    // Narrowing Cast --> einschränken der Sichtbarkeit (Eigenschaft und Verhalten)
    Animal anyAnimal = myDog;

    anyAnimal.move();
    anyAnimal.eat();
    anyAnimal.breath();
    // anyAnimal.bark(); --> bark ist über eine Animal Referentz nicht sichbar!


    // Widening Cast --> erweitern der Sichtbarkeit (Eigenschaften und Verhalten)
    anyDog = (Dog)anyAnimal;

    anyDog.move();
    anyDog.bark();

    Object anyObject = anyAnimal;

    System.out.println(anyObject);

    System.out.println("Ist das Objekt ein Tier (Animal): " + (anyObject instanceof Animal));
    System.out.println("Ist das Objekt ein Objekt: " + (anyObject instanceof Object));
    System.out.println("Ist das Objekt ein Vogel (Bird): " + (anyObject instanceof Bird));


    Animal[] shelter = new Animal[5];
    // Narrowing Cast
    shelter[0] = myDog;
    shelter[1] = myBird;
    shelter[2] = yourDog;
    shelter[3] = new Bird(20f, 15f, "Pingi", false);
    shelter[4] = new Bird(14f, 11f, "Ducky", true);


    // Nutzen der Polymorhpy --> Vielgestaltigkeit von Objekten
    System.out.println("=== Bauer geht durch den Stall und kümmert sich um seine Tiere:");
    for(Animal currentAnimal : shelter){
      currentAnimal.breath();
      currentAnimal.eat();
      currentAnimal.move();

      if(currentAnimal instanceof Dog){
        // Widening Cast
        Dog currentDog = (Dog)currentAnimal;
        currentDog.bark();
      } else {
        System.out.println(currentAnimal.getDescription() + " ist kein Hund!");
      }
    }

  }
}
