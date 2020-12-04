//Version History:
//1.0: Made program
//2.0: Added more comments, another step, shortened the ciphertext, modified the colemak dictionary, standardized the comments so they all are at the top, and changed the verison number
//for base64
import java.util.Base64;
import java.util.UUID;
import java.io.UnsupportedEncodingException;
//for input
import java.util.Scanner; 
//for converting from text to base 35
import java.math.BigInteger;
import java.lang.Integer;
/**
* @author PeacefulPotato
* @version 2.0
*/
class Encode {
  /**
  * @param plaintext
  * @return ciphertext
  * @since 1.0
  */
  public static void main(String[] args) {
    //input plaintext
    Scanner input = new Scanner(System.in); 
    System.out.print("Enter message to encode: ");
    String plaintext = input.nextLine();
    input.close();
    //call encoding subprograms and print ciphertext
    System.out.println("Your encoded message: "+stepfour(stepthree(steptwo(stepone(plaintext))))+"==");
  }
  /**
  * @param input
  * @return base64encodedString
  * @throws UnsupportedEncodingException
  * @since 1.0
  */
  public static String stepone(String input) {
      //encode to base64
      try {
         String base64encodedString = Base64.getEncoder().encodeToString(
            input.getBytes("utf-8"));
         return base64encodedString;
      //necessary to prevent code from breaking
      } catch(UnsupportedEncodingException e) {
         String error = ("Error :" + e.getMessage());
         return error;
      }
  }
  /**
  * @param stepone (qwerty)
  * @return steptwo (modified colemak)
  * @since 1.0
  */
public static String steptwo(String stepone) {
  String steptwo="";
 //dictionaries for qwerty and colemak
  char[] qwerty = {'1','2','3','4','5','6','7','8','9','0','=','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m','Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
  //I swapped ; and o in the colemak layout to make it more realistic
  //I swapped a bunch of letters and numbers to make sure all numbers and letters are modified
  char[] colemak = {'8','4','7','1','9','0','6','5','2','3','=','h','a','f','p','g','j','l','u','y','o','w','r','s','t','d','q','n','e','i','v','c','z','k','b','x','m','H','A','F','P','G','J','L','U','Y','O','W','R','S','T','D','Q','N','E','I','V','C','Z','K','B','X','M'};
  //convert the string to an array and change each character to its "colemak" counterpart.
  char[] encode = stepone.toCharArray();
  for (int x=0; x<encode.length; x++) {
    for (int y=0; y<qwerty.length; y++) {
      if(qwerty[y]==encode[x]) {
        encode[x]=colemak[y];
        break;
      }
    }
  }
  //convert back to string and return
  for (int x=0; x<encode.length; x++) {
    steptwo=steptwo+encode[x];
  }
  return steptwo;
  }
  /**
  * @param steptwo (text)
  * @return stepthree (base 35 with delimeter z)
  * @since 1.0
  */
public static String stepthree(String steptwo) {
  String str = steptwo;
  //convert string to char array and create new String array
  char[] magicasciipowers = str.toCharArray();
  String[] numbersgohere = new String
  [magicasciipowers.length];
  //convert each character to its corresponding ascii value
  for(int i=0; i<magicasciipowers.length; i++) {
    int temp=magicasciipowers[i];
    temp = (int)temp;
    if (temp<100) {
      numbersgohere[i]="0"+Integer.toString(temp);
    }
    else {
      numbersgohere[i]=Integer.toString(temp);
    }
  }
  //convert numbers into string
  String numbers = "";
  for (int i=0; i<numbersgohere.length; i++) {
    numbers=numbers+numbersgohere[i];
  }
  //convert to base 35
  BigInteger mInt = new BigInteger(numbers);
  String baseninevalue = mInt.toString(35);
  //move to another array so that string can be generated with delimeter
  char[] timefordelimeter = baseninevalue.toCharArray();
  //insert the letter z every two letters
  String stepthree = "";
  for (int i=0; i<=timefordelimeter.length-2; i=i+2) {
    stepthree=stepthree+timefordelimeter[i]+timefordelimeter[i+1]+"z";
  }
  //this takes care of any stragglers caused by deletion of a zero and/or base conversion
  int l = timefordelimeter.length;
  int j = (l-(l%2));
  for (int i=j; i<timefordelimeter.length; i++) {
    stepthree=stepthree+timefordelimeter[i];
  }
  return stepthree;
}
/**
* @param stepthree (forwards)
* @return stepfour (backwards)
* @since 2.0
*/
public static String stepfour(String stepthree) {
  String stepfour = "";
  //reverse the string and return
  char[] forwards = stepthree.toCharArray();
  char[] backwards = new char[forwards.length];
  for(int i=0;i<forwards.length;i++) {
    backwards[(forwards.length-1)-i]=forwards[i];
  }
  for (int i=0; i<backwards.length; i++) {
    stepfour=stepfour+backwards[i];
  }
  return stepfour;
}
}
//input code from https://www.geeksforgeeks.org/scanner-class-in-java/#:~:text=Scanner%20is%20a%20class%20in,and%20strings.&text=next()%20function%20returns%20the,first%20character%20in%20that%20string.
//base64 code from https://www.tutorialspoint.com/java8/java8_base64.htm
