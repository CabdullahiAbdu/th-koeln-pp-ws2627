package versuch_eins;

import java.util.Scanner;

public class Calculate_hash 
{
    char c1;
    char c2;
    char c3;
    char c4;
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
        return hash;
    }

    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in)) {
        
        String inputWord = readValidString(scanner, "Type in your Word");
        char c1 = inputWord.charAt(0); 
        char c2 = inputWord.charAt(1);
        char c3 = inputWord.charAt(2);
        char c4 = inputWord.charAt(3);
        final int modulo = readValidInteger(scanner, "Type in your Modolu Integer", 1);

        Calculate_hash ch = new Calculate_hash(c1, c2, c3, c4,modulo);
        int hashValue = ch.createHashValue();
        System.out.println("Calculated Hashvalue is:" + hashValue);
        }
    }
    
    //Sub Methods
    private static String readValidString(Scanner scanner, String outputPrompt)
    {
        while(true)
        {
            System.out.println(outputPrompt);
            String word = scanner.nextLine();

            if (word.matches("[a-zA-ZäöüÄÖÜß]{4}")) {
                return word;
            }

            System.out.println("Error: Enter exactly four valid letters.");
        }
    }
    
    private static int readValidInteger(Scanner scanner, String eingabePrompt, int minValue) 
    {
        while(true)
        {
            System.out.println(eingabePrompt);
            if (scanner.hasNextInt()) {
                int korrekteZahl = scanner.nextInt();
                scanner.nextLine();

                if (korrekteZahl >= minValue) {
                    return korrekteZahl;
                }

                System.out.println("Value is too short");
            } else {
                System.out.println("Please enter a Valdi Integer");
                scanner.next();
            }
        }
    }
}