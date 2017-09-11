import java.util.HashMap;
public class ExceptionsGenerics{
  public void tryIntegerCast(){
    //create ArrayList
    ArrayList<Object> myList = new ArrayList<Object>();
    //add elements
    myList.add("13");
    myList.add("hello world");
    myList.add(48);
    myList.add("Goodbye World");
  }
}
