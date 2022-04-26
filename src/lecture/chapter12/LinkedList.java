package lecture.chapter12;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {

  private Node<T> firstNode = null;
  private Node<T> lastNode = null;
  private int size;

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {

    Node<T> currentNode = firstNode;
    while(currentNode != null){
      if(o.equals(currentNode.getData())){
        return true;
      }
      currentNode = currentNode.getNextNode();
    }

    return false;
  }

  @Override
  public Iterator iterator() {
    return new LinkedListIterator(this.firstNode);
  }

  @Override
  public Object[] toArray() {
    Object[] items = new Object[this.size];
    int index = 0;
    Node<T> currentNode = firstNode;

    while(currentNode != null){
      items[index++] = currentNode.getData();
      currentNode = currentNode.getNextNode();
    }

    return items;
  }

  @Override
  public boolean add(T o) {
    Node<T> newNode = new Node<T>(o);
    size++;

    if(firstNode == null && lastNode == null){
      firstNode = newNode;
      lastNode = newNode;
      return true;
    }

    lastNode.setNextNode(newNode);
    lastNode = newNode;

    return true;
  }

  @Override
  public boolean remove(Object o) {
    if(firstNode != null && lastNode != null){

      if(firstNode.getData().equals(o)){
        firstNode = firstNode.getNextNode();
        if(lastNode.getData().equals(o)){
          lastNode = null;
        }
        size--;
        return true;
      }

      Node<T> currentNode = firstNode;
      while(currentNode.getNextNode() != null){
        if(currentNode.getNextNode().getData().equals(o)){
          if(currentNode.getNextNode() == lastNode){
            lastNode = currentNode;
          } else {
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
          }
          size--;
          return true;
        }
        currentNode = currentNode.getNextNode();
      }
    }
    return false;
  }

  @Override
  public boolean addAll(Collection c) {
    for(Object o : c){
      add((T) o);
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection c) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public T get(int index) {
    if(size < index + 1){
      throw new IndexOutOfBoundsException();
    }

    Node<T> currentNode = firstNode;
    while(index > 0){
      currentNode = currentNode.getNextNode();
      index--;
    }

    return currentNode.getData();
  }

  @Override
  public Object set(int index, Object element) {
    if(size < index + 1){
      throw new IndexOutOfBoundsException();
    }

    Node<T> newNode = new Node<T>((T) element);

    if(index == 0){
      T data = firstNode.getData();
      newNode.setNextNode(firstNode.getNextNode());
      firstNode = newNode;
      return data;
    }

    Node<T> currentNode = firstNode;
    while(index-1 > 0){
      currentNode = currentNode.getNextNode();
      index--;
    }

    T data = currentNode.getNextNode().getData();
    newNode.setNextNode(currentNode.getNextNode().getNextNode());
    currentNode.setNextNode(newNode);

    return data;
  }

  @Override
  public void add(int index, Object element) {
    if(size < index + 1){
      throw new IndexOutOfBoundsException();
    }

    Node<T> newNode = new Node<T>((T) element);

    if(index == 0){
      newNode.setNextNode(firstNode);
      firstNode = newNode;
      size++;
      return;
    }

    Node<T> currentNode = firstNode;
    while(index-1 > 0){
      currentNode = currentNode.getNextNode();
      index--;
    }

    newNode.setNextNode(currentNode.getNextNode());
    currentNode.setNextNode(newNode);
    size++;
  }

  @Override
  public T remove(int index) {
    if(size < index + 1){
      throw new IndexOutOfBoundsException();
    }

    if(index == 0){
      T data = firstNode.getData();
      firstNode = firstNode.nextNode;
      size--;
      return data;
    }

    Node<T> currentNode = firstNode;
    while(index-1 > 0){
      currentNode = currentNode.getNextNode();
      index--;
    }

    T data = currentNode.getData();
    currentNode.setNextNode(currentNode.getNextNode());
    size--;

    return data;
  }

  @Override
  public int indexOf(Object o) {
    Node<T> currentNode = firstNode;
    int index = 0;

    while(currentNode != null){
      if(o.equals(currentNode.getData())){
        return index;
      }
      index++;
      currentNode = currentNode.getNextNode();
    }

    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    Node<T> currentNode = firstNode;
    int count = 0;
    int foundIndex = -1;

    while(currentNode != null){
      if(o.equals(currentNode.getData())){
        foundIndex = count;
      }
      count++;
      currentNode = currentNode.getNextNode();
    }

    return foundIndex;
  }

  @Override
  public ListIterator listIterator() {
    return null;
  }

  @Override
  public ListIterator listIterator(int index) {
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return null;
  }

  @Override
  public boolean retainAll(Collection c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection c) {
    return false;
  }

  @Override
  public boolean containsAll(Collection c) {
    return false;
  }

  @Override
  public Object[] toArray(Object[] a) {
    return new Object[0];
  }

  private class Node<T>{

    private T data;
    private Node<T> nextNode;

    Node(T data){
      this.data = data;
    }

    void setNextNode(Node<T> nextNode){
      this.nextNode = nextNode;
    }

    Node<T> getNextNode(){
      return this.nextNode;
    }

    void setData(T data){
      this.data = data;
    }

    T getData(){
      return this.data;
    }
  }

  private class LinkedListIterator<T> implements Iterator<T>{

    private Node<T> currentNode;

    LinkedListIterator(Node<T> currentNode){
      this.currentNode = currentNode;
    }

    @Override
    public boolean hasNext() {
      return currentNode.getNextNode() != null;
    }

    @Override
    public T next() {
      T data = currentNode.getData();
      currentNode = currentNode.getNextNode();
      return data;
    }
  }

  private class LinkedListListIterator<T> implements ListIterator<T>{

    private Node<T> currentNode;
    private int currentIndex;

    LinkedListListIterator(Node<T> currentNode, int currentIndex){
      this.currentIndex = currentIndex;
      this.currentNode = currentNode;
    }

    @Override
    public boolean hasNext() {
      return currentNode.getNextNode() != null;
    }

    @Override
    public T next() {
      T data = currentNode.getData();
      currentNode = currentNode.getNextNode();
      currentIndex++;
      return data;
    }

    @Override
    public boolean hasPrevious() {
      return currentNode != firstNode;
    }

    @Override
    public T previous() {
      return null;
    }

    @Override
    public int nextIndex() {
      return currentIndex++;
    }

    @Override
    public int previousIndex() {
      return currentIndex--;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {
      currentNode.setData(t);
    }

    @Override
    public void add(T t) {
      
    }
  }
}
