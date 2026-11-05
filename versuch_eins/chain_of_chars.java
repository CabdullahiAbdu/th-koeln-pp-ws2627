package versuch_eins;

import java.util.Scanner;

public class chain_of_chars {

    String s1;
    String s2;
    String s3;

    public chain_of_chars(String x1, String y2) {
        this.s1 = x1;
        this.s2 = y2;
    }

    public void concat() {
        s3 = s1 + (char) 32 + s2;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String firstWord = readValidString(scanner, "Type in your first Word:");
            String secondWord = readValidString(scanner, "Type in your second Word:");

            chain_of_chars coc = new chain_of_chars(firstWord, secondWord);
            coc.concat();
            System.out.println(coc.s3);
        }
    }

    private static String readValidString(Scanner scanner, String outputPrompt) {
        while (true) {
            try {
                System.out.println(outputPrompt);
                String word = scanner.nextLine();

                if (word.isEmpty() || !word.matches("^[a-zA-ZäöüÄÖÜß]+$")) {
                    throw new IllegalArgumentException();
                }

                return word;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Restricted Characters or empty input. Try again.");
            }
        }
    }
}
