public class SLLTest{
  public static void main(String[] args){
    SLL newSLL = new SLL();
    newSLL.addNode(1);
    newSLL.addNode(2);
    newSLL.addNode(3);
    newSLL.addNode(4);
    newSLL.printValues();
    newSLL.removeNode();
    newSLL.printValues();
    newSLL.find(2);
  }
}
