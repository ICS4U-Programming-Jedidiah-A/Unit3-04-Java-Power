import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This program reverses integers.
*
* @author  Jedidiah Alfred
* @version 1.0
* @since   2023-05-11
*/

public final class RecPow {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
    */
    private RecPow() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) {
        // Initialize variables
        String line;
        final String err = "Error";
        try {
            // New object file
            final File baseFile = new File("base.txt");
            final File expFile = new File("exp.txt");

            // Creating the writer
            final FileWriter output = new FileWriter("output.txt");

            try {
                // Creating the scanner.
                final Scanner scanner1 = new Scanner(baseFile);
                final Scanner scanner2 = new Scanner(expFile);

                // ArrayList for the lines
                final ArrayList<String> lines1 = new ArrayList<>();
                final ArrayList<String> lines2 = new ArrayList<>();

                // Getting the input from file
                while (scanner1.hasNextLine()) {

                    // Getting next line
                    line = scanner1.nextLine();
                    lines1.add(line);
                }
                while (scanner2.hasNextLine()) {
                    line = scanner2.nextLine();
                    lines2.add(line);
                }

                // Manipulate the data using a function.
                for (int i = 0; i < lines1.size() - 1; i++) {
                    if (lines1.get(i).length() == 0
                        || lines2.get(i).length() == 0) {

                        // writing to file
                        output.write("ERROR: line is empty\n");
                    } else {
                        try {

                            // convert string to int
                            final int base = Integer.parseInt(lines1.get(i));
                            final int exp = Integer.parseInt(lines2.get(i));
                            if (exp < 0) {
                                output.write("ERROR: This exponent cannot be"
                                    + " negative. \n");
                            } else {
                                final int power = RecPow(base, exp);
                                output.write(base + "^" + exp + " = " + power
                                    + "\n");
                            }
                        } catch (NumberFormatException error) {
                            output.write("ERROR: Invalid input \n");
                        }
                    }
                }
            } catch (IOException error) {
                System.out.println(err + error.getMessage());
            }

            // closes the writer
            output.close();
        } catch (IOException error) {
            System.out.println(err + error.getMessage());
        }
    }
    /**
    * This is the method recPow the string.
    *
    * @param base This is the base of the power
    * @param exp This is the exponent
    * @return the solution
    */

    public static int RecPow(int base, int exp) {
        if (exp == 0) {

            // Any int to the power of 0 is 1
            return 1;
        } else {
            return base * RecPow(base, exp - 1);
        }
    }
}
