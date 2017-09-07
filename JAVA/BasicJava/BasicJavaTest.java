
import java.util.ArrayList;
public class BasicJavaTest{
  public static void main(String[] args){
    BasicJava iD = new BasicJava();
    int[] arr1= {1,2,3,4,5,6};
    int[] arr2= {-5,7-10,23,-1};
    int y = 3;
    
    ArrayList<Integer> first = iD.print1To255();
    System.out.println(first);

    // //printOdds
    ArrayList<Integer> second = iD.printOdds();
    System.out.println(second);

    //print sum
    String third = iD.printSum();

    //print vals in array
    iD.printVals(arr1);

    //print max in array
    iD.findMax(arr1);

    //print avg
    iD.findAvg(arr1);

    //print odds between 1 and 255
    iD.arrayOdds();

    //print larger than Y
    iD.largerThanY(arr1,y);

    //print squared values of an array
    iD.squareVals(arr1);

    //no negs in an array
    iD.noNegs(arr2);

    //print max min avg
    iD.maxMinAvg(arr1);

    //shift to front
    iD.shiftToFront(arr1);
  }
}
