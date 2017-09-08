import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.*;
public class PuzzleJava {

  // Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
  public void puzzleOne(){
    //Create an array with the following values: 3,5,1,2,7,9,8,13,25,32.
    Integer[] arr = {3,5,1,2,7,9,8,13,25,32};
    ArrayList<Integer> myArray = new ArrayList<Integer>(Arrays.asList(arr));
    // Print the sum of all numbers in the array
    int sum = 0;
    for (int i=0; i < myArray.size(); i++){
      //Also have the function return an array that only includes numbers that are greater than 10
      if (myArray.get(i) > 10){
        System.out.println(myArray.get(i));
      }
      sum = sum + i;
    }
  System.out.println(sum);
  }

  // Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
  public void puzzleTwo(){
    //Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa.
    String[] arr = {"Nancy","Jinichi","Fujibayashi","Momchi","Ishikawa"};
    ArrayList<String> myArray = new ArrayList<String>(Arrays.asList(arr));
    //Shuffle the array and print the name of each person.
    Collections.shuffle(myArray);
    System.out.println(myArray);
    //Have the method also return an array with names that are longer than 5 characters.
    for(String word: myArray){
      if(word.length() > 5){
        System.out.println(word);
      }
    }
  }

  //Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and display the last letter of the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message

  public void puzzleThree(){
    //Create an array that contains all 26 letters of the alphabet (this array must have 26 values).
    String[] arr = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    ArrayList<String> alpha = new ArrayList<String>(Arrays.asList(arr));
    String[] arr1 = {"a","e","i","o","u","y"};
    ArrayList<String> vowels= new ArrayList<String>(Arrays.asList(arr1));
    //Shuffle the array and display the last letter of the array.
    Collections.shuffle(alpha);
    System.out.println(alpha);
    System.out.println(alpha.get(alpha.size() -1));
    //Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message
    if (vowels.contains(alpha.get(0))){
      System.out.println("First letter is a vowel");
    }
    else{
      System.out.println(alpha.get(0));
    }

  }

  //Generate and return an array with 10 random numbers between 55-100.
  public void puzzleFour(){
    ArrayList<Integer> random = new ArrayList<Integer>(10);
    for (int i =0; i < 10; i++){
      int randomNum = ThreadLocalRandom.current().nextInt(55, 100+1);
      random.add(randomNum);
    }
    System.out.println(random);
  }

  //Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.
  public void puzzleFive(){
    ArrayList<Integer> random = new ArrayList<Integer>(10);
    for (int i =0; i < 10; i++){
      int randomNum = ThreadLocalRandom.current().nextInt(55, 100+1);
      random.add(randomNum);
    }
    Collections.sort(random);
    System.out.println(random);
    System.out.println(random.get(0));
    System.out.println(random.get(9));

  }
  //Create a random string that is 5 characters long.
  public void puzzleSix(){
    String randomchars= "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    StringBuilder randomstring = new StringBuilder();
    Random random = new Random();
    while(randomstring.length() < 6){
      int index = (int) (random.nextFloat() * randomchars.length());
      randomstring.append(randomchars.charAt(index));
    }
    String finalrandomstring = randomstring.toString();
    System.out.println(finalrandomstring);
    }

  //Generate an array with 10 random strings that are each 5 characters long
  public void puzzleSeven(){
    String randomchars= "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    ArrayList<String> bigrandomstring = new ArrayList<String>(10);
    Random random = new Random();
    while(bigrandomstring.size() < 10){
      StringBuilder randomstring = new StringBuilder();
      while(randomstring.length() < 6){
        int index = (int) (random.nextFloat() * randomchars.length());
        randomstring.append(randomchars.charAt(index));
      }
      String finalrandomstring = randomstring.toString();
      bigrandomstring.add(finalrandomstring);
      }
      System.out.println(bigrandomstring);
    }
}
