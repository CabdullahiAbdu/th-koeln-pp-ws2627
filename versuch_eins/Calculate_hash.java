package versuch_eins;

import java.util.Scanner;

public class Calculate_hash {
    private char c1;
    private char c2;
    private char c3;
    private char c4;
    private final int m;

    public Calculate_hash(char c1, char c2, char c3, char c4, int m) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.m = m;
    }

    private int createHashValue() {
        int charValue = this.c1 + this.c2 + this.c3 + this.c4;
        int hash = charValue % this.m;
        return hash;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String inputWord = readValidString(scanner, "Type in your Word");
            char c1 = inputWord.charAt(0);
            char c2 = inputWord.charAt(1);
            char c3 = inputWord.charAt(2);
            char c4 = inputWord.charAt(3);
            final int modulo = readValidInteger(scanner, "Type in your Modulo Integer", 1);

            Calculate_hash ch = new Calculate_hash(c1, c2, c3, c4, modulo);
            int hashValue = ch.createHashValue();
            System.out.println("Calculated Hashvalue is:" + hashValue);
        }
    }

    // Sub Methods
    private static String readValidString(Scanner scanner, String outputPrompt) {
        while (true) {
            System.out.println(outputPrompt);
            String word = scanner.nextLine();

            if (word.matches("[a-zA-ZäöüÄÖÜß]{4}")) {
                return word;
            }

            System.out.println("Error: Enter exactly four valid letters.");
        }
    }

    private static int readValidInteger(Scanner scanner, String outputPrompt, int minValue) {
        while (true) {
            System.out.println(outputPrompt);
            String input = scanner.nextLine();

            try {
                int validNumber = Integer.parseInt(input);
                if (validNumber >= minValue) {
                    return validNumber;
                }
                System.out.println("Error: Value is too small.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }
}