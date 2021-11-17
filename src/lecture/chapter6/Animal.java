package lecture.chapter6;

public class Animal {

  private float size;
  private float weight;
  private String description;

  // Konstruktor
  public Animal(float size, float weight, String description){
    setDescription(description);
    setSize(size);
    setWeight(weight);
  }

  // Verhaltensmethoden
  public void move(){
    System.out.println("Das Tier " + description + " bewegt sich");
  }

  public void eat(){
    System.out.println("Das Tier " + description + " frisst ");
  }

  public void breath(){
    System.out.println("Das Tier " + description + " atmet");
  }

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

  public void setDescription(String description) {
    this.description = description;
  }
}
