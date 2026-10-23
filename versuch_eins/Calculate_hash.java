package versuch_eins;

import java.util.Scanner;

public class Calculate_hash 
{
    final char c1;
    final char c2;
    final char c3;
    final char c4;
    final int mod; 

    public Calculate_hash(char C1, char C2, char C3, char C4,int m)
    {
        this.c1 = C1;
        this.c2 = C2;
        this.c3 = C3;
        this.c4 = C4;
        this.mod = m;
    }

    private int createHashValue()
    {
        int charValue = this.c1 + this.c2 + this.c3 + this.c4;
        int hash =  charValue  % this.mod;

        String hexSum = Integer.toHexString(charValue).toUpperCase();
        String hashSum = Integer.toHexString(hash).toUpperCase();

        System.out.println("Decimal sum of your Word " + charValue + " (Hex: 0x" + hexSum + ")");
        System.out.println("Decimal sum of your Hash: " + hash + " (Hex: 0x" + hashSum + ")");

        return hash;
    }

    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        String inputWord = readValidString(scanner, "Type in your Word");
        char c1 = inputWord.charAt(0); 
        char c2 = inputWord.charAt(1);
        char c3 = inputWord.charAt(2);
        char c4 = inputWord.charAt(3);
        int modulo = readValidenInteger(scanner, "Type in your Modolu Integer", 1);

        Calculate_hash ch = new Calculate_hash(c1, c2, c3, c4,modulo);
        int hashValue = ch.createHashValue();
        System.out.println("Calculated Hashvalue is:" + hashValue);


    }
    
    private static String readValidString(Scanner scanner, String outputPrompt)
    {
        while(true)
        {
            try
            {
                System.out.println(outputPrompt);
                String word = scanner.nextLine();
                if(word.length() != 4){throw new IllegalArgumentException("Length Error");}

                boolean isValidWord = true;
                for(int i = 0; i < word.length(); i++)
                {
                    char c = word.charAt(i);
                    boolean isCaps = (c >= 'A' && c <= 'Z');
                    boolean isLowerCase = (c >= 'a' && c <= 'z');
                    boolean isMutVowel = (c == 'ä' || c == 'ö' || c == 'ü' || c == 'Ä' || c == 'Ö' || c == 'Ü' || c == 'ß');

                    if(!isCaps && !isLowerCase && !isMutVowel)
                    {
                        isValidWord = false; 
                        break;
                    }
                }
                if(!isValidWord)
                    {
                        throw new java.util.InputMismatchException("Character Error");
                    }
                return word;
            }
            catch (IllegalArgumentException e) 
            {
                System.out.println("Error: The Word needs to be excactly 4 Characters long.");
            } 
            catch (java.util.InputMismatchException e) 
            {
                System.out.println("Error: Restricted Characters.");
            }
        }
    }
    private static int readValidenInteger(Scanner scanner, String outputPrompt, int minValue) 
    {
        while(true)
        {
            try
            {
                System.out.println(outputPrompt);
                String input = scanner.nextLine();
                int correctNumber = Integer.parseInt(input);

                if (correctNumber >= minValue) {return correctNumber;}
                else{System.out.println("Integer to low");}
            }
            catch(NumberFormatException e)
            {
                System.out.println("Type in a correct Integer");
            }
        }
    }
}