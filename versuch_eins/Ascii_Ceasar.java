package versuch_eins;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ascii_Ceasar 
{
    final char c;

    public Ascii_Ceasar(char C)
    {
        this.c = C;
    }

    private char ceasarMove()
    {
        char shiftedChar = (char) (((c - 'A' + 2) % 26)+ 'A');
        return shiftedChar;
    }


    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        char tInput = readValidString(scanner, "Please type in your Uppercase Character");
        Ascii_Ceasar ac = new Ascii_Ceasar(tInput);
        System.out.println("The Letter 2 steps after " + tInput + " is " + ac.ceasarMove());


    }

    private static char readValidString (Scanner sc, String outputPrompt )
    {
        while(true)
        {
            try
            {
                System.out.println(outputPrompt);
                String input = sc.nextLine();

                if(input.length() == 1)
                {
                    char c = input.charAt(0);
                    if(c >= 'A' && c <= 'Z')
                    {
                    return c;
                    }
                }
                
                if(input.length() != 1)
                {
                    throw new IllegalArgumentException("Input is too long. Should be One Character");
                }
                else
                {
                    throw new InputMismatchException("Input is not Uppercase");
                }
            }
            catch (IllegalArgumentException e) 
            {
                System.out.println("Error: The Input needs be an Uppercase Character");
            } 
            catch (java.util.InputMismatchException e) 
            {
                System.out.println("Error: Restricted Characters.");
            }
        }
    }

}
