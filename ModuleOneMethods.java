
// required imports
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

// ModuleOneMethods which contains the required methods
public class ModuleOneMethods {
   // private variables utilized in many methods in the class
   private final int remainderZero = 0;
   private final int remainderOne = 1;
   private final int remainderTwo = 2;
   private final int remainderThree = 3;
   private final int filledBracket = 4;

   /**
    * toUpper method takes in a string of characters,
    * returns the string passed in as all upper case characters
    * 
    * @param input - string of characters
    * @return - string passed in all upper case characters
    */
   public String toUpper(String input) {
      char[] inputCharacters = input.toCharArray();
      String upper = "";
      for (int i = 0; i < inputCharacters.length; i++) {
         upper += inputCharacters[i] &= '_';
      }
      return upper;
   }

   /**
    * toLower method takes in string of characters,
    * returns the string passed in as all lower case characters
    * 
    * @param input - string of characters
    * @return - string passed in all lower case characters
    */
   public String toLower(String input) {
      char[] inputCharacters = input.toCharArray();
      String lower = "";
      for (int i = 0; i < inputCharacters.length; i++) {
         lower += inputCharacters[i] |= ' ';
      }
      return lower;
   }

   /**
    * groupsOfFour method takes in binary number as string, pads ArrayList with
    * 0's, if needed
    * 
    * @param input - string representation of the binary number
    * @return - padded ArrayList
    */
   public ArrayList<Character> groupsOfFour(String input) {
      char[] charArr = input.toCharArray();
      ArrayList<Character> charArrList = new ArrayList<>();
      // REMAINDER ONE, APPEND THREE ZEROES TO FRONT OF ARRAYLIST, RETURN UPDATED
      if ((charArr.length % filledBracket) == remainderOne) {
         for (int i = 0; i < (filledBracket - remainderOne); i++) {
            charArrList.add('0');
         }
         for (int j = 0; j < charArr.length; j++) {
            charArrList.add(charArr[j]);
         }
      }
      // REMAINDER TWO, APPEND TWO ZEROES TO FRONT OF ARRAYLIST, RETURN UPDATED
      if ((charArr.length % filledBracket) == remainderTwo) {
         for (int i = 0; i < (filledBracket - remainderTwo); i++) {
            charArrList.add('0');
         }
         for (int j = 0; j < charArr.length; j++) {
            charArrList.add(charArr[j]);
         }
      }
      // REMAINDER THREE, APPEND ONE ZERO TO FRONT OF ARRAYLIST, RETURN UPDATED
      if ((charArr.length % filledBracket) == remainderThree) {
         for (int i = 0; i < (filledBracket - remainderThree); i++) {
            charArrList.add('0');
         }
         for (int j = 0; j < charArr.length; j++) {
            charArrList.add(charArr[j]);
         }
      }
      // REMAINDER ZERO, RETURN ARRAYLIST AS IS
      if ((charArr.length % filledBracket) == remainderZero) {
         for (int j = 0; j < charArr.length; j++) {
            charArrList.add(charArr[j]);
         }
      }
      return charArrList;
   }

   /**
    * hexIntegerValues method iterates through groupsOfFour ArrayList,
    * adds the corresponding value based on position, as well as binary number is 0
    * or 1,
    * returns string representation of int value for each group
    * 
    * @param input - string representation of the binary number
    * @return - int value of each group of four
    */
   public ArrayList<String> hexIntegerValues(String input) {
      ArrayList<Character> groupsOfFour = groupsOfFour(input);
      int value = 0;
      ArrayList<String> output = new ArrayList<>();
      for (int i = 0; i < groupsOfFour.size(); i++) {
         if (((i % filledBracket) == remainderZero) && groupsOfFour.get(i) == '1') {
            value += 8;
         } else if (((i % filledBracket) == remainderOne) && groupsOfFour.get(i) == '1') {
            value += 4;
         } else if (((i % filledBracket) == remainderTwo) && groupsOfFour.get(i) == '1') {
            value += 2;
         } else if (((i % filledBracket) == remainderThree) && groupsOfFour.get(i) == '1') {
            value += 1;
         } else {
            value += 0;
         }
         if ((i % filledBracket) == remainderThree) {
            output.add(value + "");
            value = 0;
         }
      }
      return output;
   }

   /**
    * hexTable method creates the hex table
    * 
    * @return - Hashtable representation of the hex table
    */
   public Hashtable<String, String> hexTable() {
      Hashtable<String, String> hexTable = new Hashtable<>();
      int hexTableSize = 16;
      for (int i = 0; i < hexTableSize; i++) {
         if (i <= 9) {
            hexTable.put(i + "", i + "");
         } else {
            for (char alphabet = 'A'; alphabet <= 'F'; alphabet++) {
               hexTable.put(i + "", alphabet + "");
               i++;
            }
         }
      }
      return hexTable;
   }

   /**
    * binaryToHex method utilizes the hexIntegerValues and hexTable methods
    * to correlate each int value with its appropriate hex value
    * 
    * @param input - string representation of the binary number
    * @return - string representation of the binary to hex conversion
    */
   public String binaryToHex(String input) {
      ArrayList<String> hexIntegerValues = hexIntegerValues(input);
      Hashtable<String, String> hexTable = hexTable();
      String output = "";
      // FOR LOOP TO POPULATE HASHTABLE
      for (int i = 0; i < hexIntegerValues.size(); i++) {
         for (Map.Entry<String, String> entry : hexTable.entrySet()) {
            if (hexIntegerValues.get(i).equals(entry.getKey())) {
               output += entry.getValue();
            }
         }
      }

      return output;
   }

   /**
    * asciiToEachIntValue method takes in string of characters,
    * sums the corresponding integer value for each character,
    * outputs the result for each character, as well as sum of all characters
    * 
    * @param input - string of characters
    * @return - the integer value of each ASCII character, as well as sum of all
    *         characters
    */
   public String asciiToEachIntValue(String input) {
      char[] charArr = input.toCharArray();
      int intValue = 0;
      String value = "";
      for (int i = 0; i < charArr.length; i++) {
         value += "Character " + charArr[i] + " has an integer value of: " + (int) charArr[i] + "\n";
         intValue += (int) charArr[i];
         if (i == charArr.length - 1) {
            value += "The total integer value is: " + intValue;
         }
      }
      return value;
   }

}
