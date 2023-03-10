import java.io.*;

/** Methods for performing arithmetic calculations. */
class Arithmetic {
  public static float add(float num1, float num2) {
    return num1 + num2;
  }
  public static float subtract(float num1, float num2) {
    return num1 - num2;
  }

  public static float multiply(float num1, float num2) {
    return num1 * num2;
  }

  public static float division(float num1, float num2) {
    return num1 / num2;
  }
 
  public static float modulo(float num1, float num2) {
    return num1 % num2;
  }

  public static float square(float num1) {
    return num1 * num1;
  }

  public static float cube(float num1) {
    return (float) Math.pow(num1, 3);
  }
}

/** The calculator program. */
public class Calculator {
  public static void main(String[] args) {
    // Main loop to run calculator program
    while (true) {
      // getUserInput() behaves like python's input() function
      String input = getUserInput("Enter your equation:");
      // Input validation to check for empty input
      if (input == null) {
        System.out.println("Please enter an equation.");
        continue;
      }

      // Creates string array by splitting input on empty spaces
      String[] tokens = input.split(" ");

       // checks first index for operator, quits program if "q"
      String operator = tokens[0];
      if (operator.toLowerCase().equals("q")) {
        System.out.println("Quitting the program. Goodbye!");
        break;
      }

      // Declares variables
      Float num1, num2;

      // Tries to convert strings in array to floats
      try {
        num1 = Float.parseFloat(tokens[1]);

        //checks for second operand, sets to 0.0 if not
        if (tokens.length >= 3) {
          num2 = Float.parseFloat(tokens[2]);
        } else {
          num2 = 0f;
        }

        // Validates for no numbers being entered
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error: enter at least 1 number.");
        continue;

        // validates any other error
      } catch (NumberFormatException e) {
        System.out.println("Error: not able to parse the numbers you entered.");
        continue;
      }

      // declares result variable
      Float result;

      // switch to call the appropriate arithmetic operation functions
      switch (operator) {
        case "+":
          result = Arithmetic.add(num1, num2);
          break;

        case "-":
          result = Arithmetic.subtract(num1, num2);
          break;  

        case "*":
          result = Arithmetic.multiply(num1, num2);
          break;


        case "/":
          result = Arithmetic.division(num1, num2);
          break;


        case "%":
          result = Arithmetic.modulo(num1, num2);
          break;


        case "square":
          result = Arithmetic.square(num1);
          break;


        case "cube":
          result = Arithmetic.cube(num1);
          break;

        // validates if operation is supported
        default:
          result = null;
          break;
      }

      // displays results of operation, results in error message if operation not supported
      if (result == null) {
        System.out.println("Invalid operator.");
      } else {
        System.out.println("=> " + result);
      }
    }
  }

  /** Works exactly like Python's input() function. */
  static String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + " ");
    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0) {
        return null;
      }
    } catch (IOException e) {
      System.out.println("IOException: " + e);
    }
    return inputLine;
  }
}
