public class Kata
{
  public static String reverseWords(final String original)
  {
    String[] answer = new String[100];
    answer = original.split(" ");
    String output = "";
    
    for(int i = 0; i < answer.length; i++){
      String tmp = answer[i];
      char[] charArray = tmp.toCharArray();
      for(int j = 0; j < tmp.length()/2; j++){
          char tmpChar = charArray[j];
          charArray[j] = charArray[tmp.length() - j -1];
          charArray[tmp.length() - j -1] = tmpChar;
      }
      if(i+1 < answer.length){
        output += charArray.toString();
        output += " ";
      }else{
        output += charArray.toString();
      }
    }
    return output;
  }
}
