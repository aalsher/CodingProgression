//Create a Node class with the value and next attributes
public class Node {
  private Object val;
  private Node next;

  public Node(){
    this.val = null;
  }
  public Node(Object val){
    this.val = val;
  }
  public Object getVal(){
    return this.val;
  }
  //Create a constructor method that sets the value to a given number and next to null of your Node objects
  public void setVal(Object val){
    this.val = val;
  }
  public void setNext(Node next){
    this.next = next;
  }
  public Node getNext(){
    return this.next;
  }
}
