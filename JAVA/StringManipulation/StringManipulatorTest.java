public class StringManipulatorTest {
  public static void main(String [] args) {
    //Trim both input strings and then concatenate them. Return the new string.
    StringManipulator manipulator = new StringManipulator();
    String str = manipulator.trimAndConcat("    Hello     ","     World    ");
    System.out.println(str); // HelloWorld

    //Get the index of the character and return either the index or null. If the character appears multiple times, return the first index.

    char letter = 'o';
    Integer a = manipulator.getIndexOrNull("Coding", letter);
    Integer b = manipulator.getIndexOrNull("Hello World", letter);
    Integer c = manipulator.getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c); // null

    //Get the index of the start of the substring and return either the index or null.

    String word1 = "Hello";
    String subString = "llo";
    String notSubString = "world";
    Integer d = manipulator.getIndexOrNull(word1, subString);
    Integer e = manipulator.getIndexOrNull(word1, notSubString);
    System.out.println(d); // 2
    System.out.println(e); // null

    //Get a substring using a starting and ending index, and concatenate that with the second string input to our method.

    String word2 = manipulator.concatSubstring("Hello", 1, 2, "world");
    System.out.println(word2); // eworld
  }
}
