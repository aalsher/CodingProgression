public class StringManipulator {
  //Trim both input strings and then concatenate them. Return the new string.
  public String trimAndConcat(String str1, String str2) {
    //trim both strings
    str1 = str1.replaceAll("\\s+","");
    str2 = str2.replaceAll("\\s+","");
    //concat strings
    String concatenatedstring = str1.concat(str2);
    return "" + concatenatedstring;
  }

  public Integer getIndexOrNull(String str1, char letter){
    //Get the index of the char and return either the index or null. If the char appears multiple times, return the first index.
    for (int i =0; i < str1.length(); i++){
      if (str1.charAt(i) == letter){
        return i;
      }
    }
    return null;
  }

  public Integer getIndexOrNull(String str1, String str2){
    //Get the index of the start of the substring and return either the index or null
    if (str1.contains(str2)){
      return str1.indexOf(str2);
    }
    else {
      return null;
    }
  }

  public String concatSubstring(String str1, int start, int end, String str2){
    //Get a substring using a starting and ending index, and concatenate that with the second string input to our method
    String substring = str1.substring(start,end);
    String concatenatedstring = substring.concat(str2);
    return concatenatedstring;
  }
}
