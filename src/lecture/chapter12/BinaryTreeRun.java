package lecture.chapter12;

public class BinaryTreeRun {

  public static void main(String[] args) {

    BinaryTree<Integer> myNumbersTree = new BinaryTree<>();

    myNumbersTree.add(50);
    System.out.println("Add 100: " + myNumbersTree.add(100));
    System.out.println("Add 100: " + myNumbersTree.add(100));
    myNumbersTree.add(70);
    myNumbersTree.add(30);
    myNumbersTree.add(20);
    myNumbersTree.add(40);
    myNumbersTree.add(10);
    myNumbersTree.add(80);
    myNumbersTree.add(90);
    myNumbersTree.add(60);

    System.out.println("Baum ist fertig aufgebaut!");

    myNumbersTree.printInOrder();
    myNumbersTree.printPreOrder();
    myNumbersTree.printPostOrder();
  }
}
