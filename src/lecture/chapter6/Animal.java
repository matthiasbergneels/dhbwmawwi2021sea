package lecture.chapter6;

public abstract class Animal {

  private float size;
  private float weight;
  private final String description;

  // Konstruktor
  public Animal(float size, float weight, String description){
    //setDescription(description);
    this.description = description;
    setSize(size);
    setWeight(weight);
  }

  // Verhaltensmethoden
  public final void move(){
    System.out.println("Das Tier " + description + " bewegt sich");
  }

  public void eat(){
    System.out.println("Das Tier " + description + " frisst ");
  }

  public abstract void breath();

  // Setter- / Getter-Methoden
  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public String getDescription() {
    return description;
  }


  @Override
  public String toString(){
    return super.toString() + " - Beschreibung: " + getDescription()
      + "; Größe: " + getSize()
      + "; Gewicht: " + getWeight();
  }
}
