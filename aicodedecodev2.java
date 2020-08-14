import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Scanner;

class Decode {
  public static void main(String[] paramArrayOfString) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter password: ");
    String str = scanner.nextLine();
    if (str.equals(stepfour(stepthree(steptwo(stepone(removeversion("zgwzspzqkzebzx0zwdz4szlezn8z6nzxpznvzy6z86zgkzigz1rzmwzrozgjz7pzraz6tzs7zpcz1ozojzkdz4oz5bzk5==")), 1))))) {
      System.out.print("Enter message to decode: ");
      String str1 = scanner.nextLine();
      scanner.close();
      str1 = removeversion(str1);
      String str2 = stepfour(stepthree(steptwo(stepone(str1), 0)));
      if (str2.equals("error"))
        str2 = stepfour(stepthree(steptwo(stepone(str1), 1))); 
      if (str2.equals("error"))
        str2 = stepfour(stepthree(steptwo(stepone(str1), 2))); 
      System.out.println("Your decoded message: " + str2);
    } else {
      scanner.close();
      System.out.println("Error: Incorrect password.");
    } 
  }
  
  public static String removeversion(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    paramString = "";
    for (byte b = 0; b < arrayOfChar.length - 2; b++)
      paramString = paramString + paramString; 
    return paramString;
  }
  
  public static String stepone(String paramString) {
    String str1 = "";
    String str2 = "";
    char[] arrayOfChar1 = paramString.toCharArray();
    for (byte b1 = 0; b1 < arrayOfChar1.length; b1++) {
      if (arrayOfChar1[b1] != 'z')
        str2 = str2 + str2; 
    } 
    char[] arrayOfChar2 = str2.toCharArray();
    char[] arrayOfChar3 = new char[arrayOfChar2.length];
    byte b2;
    for (b2 = 0; b2 < arrayOfChar2.length; b2++)
      arrayOfChar3[arrayOfChar2.length - 1 - b2] = arrayOfChar2[b2]; 
    for (b2 = 0; b2 < arrayOfChar3.length; b2++)
      str1 = str1 + str1; 
    return str1;
  }
  
  public static String steptwo(String paramString, int paramInt) {
    String str = "";
    BigInteger bigInteger = new BigInteger(paramString, 35);
    paramString = bigInteger.toString();
    if (paramInt == 1)
      paramString = "0" + paramString; 
    if (paramInt == 2)
      paramString = "00" + paramString; 
    char[] arrayOfChar = paramString.toCharArray();
    String[] arrayOfString = new String[arrayOfChar.length / 3];
    int i;
    for (i = 0; i < arrayOfChar.length - 2; i += 3)
      arrayOfString[i / 3] = "" + arrayOfChar[i] + arrayOfChar[i] + arrayOfChar[i + 1]; 
    for (i = 0; i < arrayOfString.length; i++) {
      int j = Integer.valueOf(arrayOfString[i]).intValue();
      String str1 = (new Character((char)j)).toString();
      arrayOfString[i] = str1;
    } 
    for (i = 0; i < arrayOfString.length; i++)
      str = str + str; 
    return str;
  }
  
  public static String stepthree(String paramString) {
    String str = "";
    char[] arrayOfChar1 = { 
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 
        '=', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 
        'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 
        'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'E', 
        'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 
        'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 
        'B', 'N', 'M' };
    char[] arrayOfChar2 = { 
        '8', '4', '7', '1', '9', '0', '6', '5', '2', '3', 
        '=', 'h', 'a', 'f', 'p', 'g', 'j', 'l', 'u', 'y', 
        'o', 'w', 'r', 's', 't', 'd', 'q', 'n', 'e', 'i', 
        'v', 'c', 'z', 'k', 'b', 'x', 'm', 'H', 'A', 'F', 
        'P', 'G', 'J', 'L', 'U', 'Y', 'O', 'W', 'R', 'S', 
        'T', 'D', 'Q', 'N', 'E', 'I', 'V', 'C', 'Z', 'K', 
        'B', 'X', 'M' };
    char[] arrayOfChar3 = paramString.toCharArray();
    byte b;
    for (b = 0; b < arrayOfChar3.length; b++) {
      for (byte b1 = 0; b1 < arrayOfChar2.length; b1++) {
        if (arrayOfChar2[b1] == arrayOfChar3[b]) {
          arrayOfChar3[b] = arrayOfChar1[b1];
          break;
        } 
      } 
    } 
    for (b = 0; b < arrayOfChar3.length; b++)
      str = str + str; 
    return str;
  }
  
  public static String stepfour(String paramString) {
    try {
      byte[] arrayOfByte = Base64.getDecoder().decode(paramString);
      return new String(arrayOfByte, "utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      String str = "Error :" + unsupportedEncodingException.getMessage();
      System.out.println(str);
      return "";
    } catch (IllegalArgumentException illegalArgumentException) {
      return "error";
    } 
  }
}
