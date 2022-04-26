package lecture.chapter13;

public class SortingAlgorithms {


  public static void main(String[] args) {
    int[] toSort = {50, 70, 100, 80, 40, 30, 20, 10 ,60};

    System.out.println("Unsortiert: ");
    printArray(toSort);

    int[] sorted = bubbleSort(toSort.clone());

    System.out.println("Bubble Sort V1 sortiert: ");
    printArray(sorted);

    sorted = bubbleSortV2(toSort.clone());

    System.out.println("Bubble Sort V2 sortiert: ");
    printArray(sorted);

    sorted = bubbleSortV3(toSort.clone());

    System.out.println("Bubble Sort V3 sortiert: ");
    printArray(sorted);

    sorted = bubbleSortV3(sorted.clone());

    System.out.println("Bubble Sort V3 vor-sortiert: ");
    printArray(sorted);

    sorted = selectionSort(toSort.clone());

    System.out.println("Selection Sort sortiert: ");
    printArray(sorted);
  }

  public static int[] bubbleSort(int[] numbers){

    long startTime = System.nanoTime();

    for(int i = numbers.length; i > 0; i--){
      for(int j = 0; j < numbers.length-1; j++){
        if(numbers[j] > numbers[j+1]){
          // swap
          swap(numbers, j, j+1);
        }
      }
    }

    long stopTime = System.nanoTime();

    System.out.println("BubbleSort Runtime " + numbers.length + " Elemente: " + (stopTime - startTime) + " ns");

    return numbers;
  }

  public static int[] bubbleSortV2(int[] numbers){

    long startTime = System.nanoTime();

    for(int i = numbers.length; i > 0; i--){
      for(int j = 0; j < i-1; j++){
        if(numbers[j] > numbers[j+1]){
          // swap
          swap(numbers, j, j+1);
        }
      }
    }

    long stopTime = System.nanoTime();

    System.out.println("BubbleSort Runtime V2 " + numbers.length + " Elemente: " + (stopTime - startTime) + " ns");

    return numbers;
  }

  public static int[] bubbleSortV3(int[] numbers){

    int j = numbers.length - 1;
    boolean swapped = false;

    long startTime = System.nanoTime();

    do{
      swapped = false;

      for(int i = 0; i < j; i++){
        if(numbers[i] > numbers[i+1]){
          swap(numbers, i, i+1);
          swapped = true;
        }
      }
      j--;
    }while(swapped);

    long stopTime = System.nanoTime();

    System.out.println("BubbleSort Runtime V3 " + numbers.length + " Elemente: " + (stopTime - startTime) + " ns");

    return numbers;
  }

  public static int[] selectionSort(int[] numbers){

    int sortedMarker = numbers.length - 1;

    long startTime = System.nanoTime();

    while(sortedMarker > 0){
      int maxPos = 0;
      for(int i = 1; i <= sortedMarker; i++){
        if(numbers[i] > numbers[maxPos]){
          maxPos = i;
        }
      }

      swap(numbers, maxPos, sortedMarker);
      sortedMarker--;
    }

    long stopTime = System.nanoTime();

    System.out.println("Selection Runtime " + numbers.length + " Elemente: " + (stopTime - startTime) + " ns");

    return numbers;
  }

  public static void printArray(int[] numbers){
    for(int number : numbers){
      System.out.print(number + ", ");
    }
    System.out.println();
  }

  private static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
