public class ModuleOne {

   public static void main(String[] args) {
      // instance of class to access its methods
      ModuleOneMethods moduleOneMethods = new ModuleOneMethods();
      // Ask user for name, binaryNumbers
      // System.out.println("Please enter a name: " + args[0]);
      // System.out.println("Please enter a binary number: " + args[1]);
      // // string used as parameter for UPPER/LOWER, ASCII TO INTEGEER
      // String name = args[0];
      // // String used as parameter for BINARY TO HEX
      // String binaryNumbers = args[1];
      /* --------------------------- */
      /* STRING TO UPPER/LOWER */
      System.out.println("Name to upper: " + moduleOneMethods.toUpper(args[0]));
      System.out.println("Name to lower: " + moduleOneMethods.toLower(args[0]));
      /* --------------------------- */
      /* ASCII TO INTEGER */
      System.out.println(moduleOneMethods.asciiToEachIntValue(args[0]));
      /* --------------------------- */
      /* BINARY TO HEX */
      System.out.println("The binary number " + args[1] + " equates to "
            + moduleOneMethods.binaryToHex(args[1]) + " in hex");
   }
}