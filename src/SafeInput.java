import java.util.Scanner;

public class SafeInput
{
    /**
     *
     * @param pipe Scanner used for input
     * @param prompt Message displayed to the user
     * @return A non-empty string
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String input;

        do
        {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
        }
        while(input.length() == 0);

        return input;
    }

    /**
     *
     * @param pipe Scanner used for input
     * @param prompt Message displayed to the user
     * @return A valid integer
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int value;

        while(true)
        {
            System.out.print(prompt + ": ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();
                return value;
            }
            else
            {
                System.out.println("Invalid integer. Try again.");
                pipe.nextLine();
            }
        }
    }

    /**
     *
     * @param pipe Scanner used for input
     * @param prompt Message displayed to the user
     * @return A valid double
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double value;

        while(true)
        {
            System.out.print(prompt + ": ");

            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                pipe.nextLine();
                return value;
            }
            else
            {
                System.out.println("Invalid double. Try again.");
                pipe.nextLine();
            }
        }
    }

    /**
     *
     * @param pipe Scanner used for input
     * @param prompt Message displayed to the user
     * @param low Lowest acceptable value
     * @param high Highest acceptable value
     * @return An integer within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value;

        do
        {
            value = getInt(pipe, prompt + " [" + low + "-" + high + "]");

            if(value < low || value > high)
            {
                System.out.println("Value must be between " + low + " and " + high);
            }
        }
        while(value < low || value > high);

        return value;
    }

    /**
     *
     * @param pipe Scanner used for input
     * @param prompt Message displayed to the user
     * @param low Lowest acceptable value
     * @param high Highest acceptable value
     * @return A double within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double value;

        do
        {
            value = getDouble(pipe, prompt + " [" + low + "-" + high + "]");

            if(value < low || value > high)
            {
                System.out.println("Value must be between " + low + " and " + high);
            }
        }
        while(value < low || value > high);

        return value;
    }

    /**
     *
     * @param pipe Scanner used for input
     * @param prompt Message displayed to the user
     * @return true for Y, false for N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print(prompt + " [Y/N]: ");

            response = pipe.nextLine().trim().toUpperCase();

            if(response.equals("Y"))
            {
                return true;
            }

            if(response.equals("N"))
            {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
        while(true);
    }

    /**
     *
     * @param pipe Scanner used for input
     * @param prompt Message displayed to the user
     * @param regEx Regular expression to validate input
     * @return A string matching the regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input;

        do
        {
            System.out.print(prompt + ": ");

            input = pipe.nextLine();

            if(input.matches(regEx))
            {
                return input;
            }

            System.out.println("Invalid format.");
        }
        while(true);
    }

    /**
     *
     * @param msg Message to display in the header
     */
    public static void prettyHeader(String msg)
    {
        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();

        int spaces = (54 - msg.length()) / 2;

        System.out.print("***");

        for(int i = 0; i < spaces; i++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for(int i = 0; i < (54 - spaces - msg.length()); i++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();
    }


}