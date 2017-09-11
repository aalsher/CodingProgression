
import java.util.*;
public class ExceptionsGenericsTest{
  public static void main(String[] args){
    // ExceptionsGenerics iD = new ExceptionsGenerics();
    // iD.tryIntegerCast();
    ArrayList<Object> myList = new ArrayList<Object>();
    //add elements
    myList.add("13");
    myList.add("hello world");
    myList.add(48);
    myList.add("Goodbye World");
    //iterate and typecast every element to Integer type
    for (int i = 0; i < myList.size(); i++){
      try{
        Integer castedValue = (Integer)myList.get(i);
        System.out.println(castedValue);
      }catch (ClassCastException e){
        System.out.println("ERROR ON INDEX" + i);
      }
    }
  }
}
