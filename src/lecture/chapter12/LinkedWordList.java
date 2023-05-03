package lecture.chapter12;

public class LinkedWordList {

  private WordNode firstWordNode = null;
  private int size = 0;

  public void add(String word){
    WordNode newWordNode = new WordNode(word);
    size++;

    if(firstWordNode == null){
      // Liste ist leer
      firstWordNode = newWordNode;
      return;
    }

    WordNode currentWordNode = firstWordNode;
    while(currentWordNode.getNextWordNode() != null){
      currentWordNode = currentWordNode.getNextWordNode();
    }

    currentWordNode.setNextWordNode(newWordNode);
  }

public boolean contains(String word){

    /*
    if(firstWordNode == null){
      return false;
    }

    WordNode currentWordNode = firstWordNode;
    if(word.equals(currentWordNode.getWord())){
      return true;
    }

    while(currentWordNode.getNextWordNode() != null){
      currentWordNode = currentWordNode.getNextWordNode();
      if(word.equals(currentWordNode.getWord())){
        return true;
      }
    }
    */

    WordNode currentWordNode = firstWordNode;
    while(currentWordNode != null){
      if(word.equals(currentWordNode.getWord())){
        return true;
      }
      currentWordNode = currentWordNode.getNextWordNode();
    }

    return false;
}

public int size(){
    return this.size;
}

public void printWordList(){
  if(firstWordNode == null){
    System.out.println("Liste ist leer");
    return;
  }

  System.out.println("Listeninhalt: ");
  printWordList(firstWordNode);
}

// Rekursive Ausgabe der Liste
private void printWordList(WordNode wordNode){
  System.out.println("- " + wordNode.getWord());
  if(wordNode.getNextWordNode() != null){
    printWordList(wordNode.getNextWordNode());
  }
}

public boolean remove(String word){
    if(firstWordNode != null){

      if(firstWordNode.getWord().equals(word)){
        firstWordNode = firstWordNode.getNextWordNode();
        size--;
        return true;
      }

      WordNode currentNode = firstWordNode;
      while(currentNode.getNextWordNode() != null){
        if(currentNode.getNextWordNode().getWord().equals(word)){
          currentNode.setNextWordNode(currentNode.getNextWordNode().getNextWordNode());
          size--;
          return true;
        }
        currentNode = currentNode.getNextWordNode();
      }

    }

    return false;
}

  private class WordNode{
    private String word;
    private WordNode nextWordNode;

    public WordNode(String word){
      this.word = word;
      this.nextWordNode = null;
    }

    public void setNextWordNode(WordNode nextWordNode){
      this.nextWordNode = nextWordNode;
    }

    public WordNode getNextWordNode(){
      return this.nextWordNode;
    }

    public String getWord(){
      return this.word;
    }
  }

}
