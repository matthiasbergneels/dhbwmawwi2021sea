package lecture.chapter12;

public class LinkedWordList {

  private WordNode firstWordNode = null;

  public void add(String word){
    WordNode newWordNode = new WordNode(word);

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
    return false;
}

public int size(){
    return 0;
}

public void printWordList(){

}

public boolean remove(String word){
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
      return this.getWord();
    }
  }

}
