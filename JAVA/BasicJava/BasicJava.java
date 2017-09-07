import java.util.*;
public class BasicJava {
  //Write a method that prints all the numbers from 1 to 255.
  public ArrayList <Integer> print1To255() {
    ArrayList<Integer> myArray = new ArrayList<Integer>();
    for (int i=1; i < 256; i++){
      myArray.add(i);
    }
    return myArray;
  }

  // //Write a method that prints all the odd numbers from 1 to 255
  public ArrayList <Integer> printOdds(){
    ArrayList<Integer> myArray = new ArrayList<Integer>();
    for (int i=1; i < 256; i++){
      if( i % 3 == 0){
        myArray.add(i);
      }
    }
    return myArray;
  }

  //Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far
  public String printSum(){
    int sum =0;
    for (int i=1; i <256; i++){
      sum = sum + i;
      System.out.println("New Number:" + i + "Sum:" + sum);
    }
    return "" + sum;
  }

  // Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen.
  public void printVals(int[] arr1){
    for(int i=0; i < arr1.length; i++){
      System.out.println(arr1[i]);
    }
  }

//   //Write a method (sets of instructions) that takes any array and prints the maximum value in the array.
  public void findMax(int[] arr1){
    int max=0;
    for( int i=0; i < arr1.length; i++){
      if( arr1[i] > max){
        max = arr1[i];
      }
    }
    System.out.println(max);
  }

//   //Write a method that takes an array, and prints the AVERAGE of the values in the array.
  public void findAvg(int[] arr1){
    int sum= 0;
    for( int i=0; i < arr1.length; i++){
      sum += arr1[i];
    }
    int avg = sum / arr1.length;
    System.out.println(avg);
  }

//   //Write a method that creates an array 'y' that contains all the odd numbers between 1 to 255.
  public ArrayList <Integer> arrayOdds(){
    ArrayList<Integer> y = new ArrayList<Integer>();
    for (int i=1; i < 256; i++){
      if( i % 3 == 0){
        y.add(i);
      }
    }
    System.out.println(y);
    return y;
  }
//
//   //Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y.
  public void largerThanY(int[] arr1, int y){
    int count=0;
    for (int i=0; i < arr1.length; i++){
      if (arr1[i] > y){
        count= count + 1;
      }
    }
    System.out.println(count);
  }
  //Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself. When the method is done, the array x should have values that have been squared, say [1, 25, 100, 4].
  public void squareVals(int[] arr1){
    for (int i=0; i < arr1.length; i++){
      arr1[i] = arr1[i] * arr1[i];
    }
    System.out.println(Arrays.toString(arr1));
  }

  //Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0.
  public int[] noNegs(int[] arr2){
    for (int i =0; i < arr2.length; i++){
      if (arr2[i] < 0){
        arr2[i] = 0;
      }
    }
    System.out.println(Arrays.toString(arr2));
    return arr2;
  }

//   //Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array. The returned array should be three elements long and contain: [MAXNUM, MINNUM, AVG]
  public ArrayList<Integer> maxMinAvg(int[] arr1){
    ArrayList<Integer> myArray = new ArrayList<Integer>(3);
    int maxnum= arr1[0];
    Integer minnum= arr1[0];
    int sum= 0;
    for (int i=0; i < arr1.length; i++){
      if(arr1[i] > maxnum){
        maxnum = arr1[i];
      }
      else if(arr1[i] < minnum){
        minnum = arr1[i];
      }
      sum = sum + arr1[i];
    }
    int avg = sum / arr1.length;
    myArray.add(maxnum);
    myArray.add(minnum);
    myArray.add(avg);
    System.out.println(myArray);
    return myArray;
  }

//   //Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front
  public void shiftToFront(int[] arr1){
    for (int i =0; i < arr1.length-2; i++){
      arr1[i]= arr1[i+1];
    }
    arr1[arr1.length-1] = 0;
    System.out.println(Arrays.toString(arr1));
  }

}
