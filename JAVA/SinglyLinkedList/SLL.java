public class SLL {
  //Create a SinglyLinkedList class with the head attribute
  private Node head;
  public SLL(){
    //Create a constructor method that sets the head to null of your SinglyLinkedList objects
    this.head = null;
  }

  //Create a constructor method that sets the head to null of your SinglyLinkedList objects
  public void setHead(Node node){
    this.head = node;
  }
  //Create a add(int) method that will add a node to the end of your list with the value in the parameter
  public SLL addNode(Object val){
    Node current = head;
    if (this.head == null){
      this.head = new Node(val);
      return this;
    }
    while(current.getNext() != null){
      current = current.getNext();
    }
    current.setNext(new Node(val));
    return this;
  }
  //Create printValues() method that will print all the values of each node in the list in order
  public void printValues(){
    Node current = head;
    while(current != null){
      System.out.println(current.getVal());
      current = current.getNext();
    }
  }
  //Create a remove() method that will remove a node from the end of your list
  public void removeNode(){
    Node current = this.head;
    Node pre= new Node();
    while(current.getNext() !=null){
      pre = current;
      current = current.getNext();
    }
    pre.setNext(null);
  }

  //Implement a find(int) method that will return the first node with the value in the parameter
  public Object find(Object val){
    Node current = this.head;
    while(current.getNext() !=null){
      if(current.getVal() == val){
        System.out.println("Val found");
        return current;
      }
      current = current.getNext();
    }
    System.out.println("Val not found");
    return null;
  }
}
