package lecture.chapter13;

public class SortingAlgorithms {


  public static void main(String[] args) {
    int[] toSort = {50, 70, 100, 80, 40, 30, 20, 10 ,60};

    System.out.println("Unsortiert: ");
    printArray(toSort);

    int[] sorted = bubbleSort(toSort);

    System.out.println("Sortiert: ");
    printArray(sorted);
  }

  public static int[] bubbleSort(int[] numbers){

    for(int i = numbers.length; i > 0; i--){
      for(int j = 0; j < numbers.length-1; j++){
        if(numbers[j] > numbers[j+1]){
          // swap
          int temp = numbers[j];
          numbers[j] = numbers[j+1];
          numbers[j+1] = temp;
        }
      }
    }
    return numbers;
  }

  public static void printArray(int[] numbers){
    for(int number : numbers){
      System.out.print(number + ", ");
    }
    System.out.println();
  }
}
