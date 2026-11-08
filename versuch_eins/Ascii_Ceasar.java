package versuch_eins;

import java.util.Scanner;

public class Ascii_Ceasar {
    private char c;

    public Ascii_Ceasar(char c) {
        this.c = c;
    }

    public char ceasarMove() {
        char shiftedChar = (char) (((c - 'A' + 2) % 26) + 'A');
        return shiftedChar;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char tInput = readValidCharacter(scanner, "Please type in your Uppercase Character");
            Ascii_Ceasar ac = new Ascii_Ceasar(tInput);
            System.out.println("The Letter 2 steps after " + tInput + " is " + ac.ceasarMove());
        }
    }

    // Sub Methods
    private static char readValidCharacter(Scanner scanner, String outputPrompt) {
        while (true) {
            System.out.println(outputPrompt);
            String input = scanner.nextLine();

            if (input.matches("[A-Z]")) {
                return input.charAt(0);
            }

            System.out.println("Error: The input needs to be an uppercase character.");
        }
    }

}
