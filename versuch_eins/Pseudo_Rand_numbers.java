package versuch_eins;

import java.util.Random;
import java.util.Scanner;

public class Pseudo_Rand_numbers {
    private final int a;
    private final int b;
    private final int m;
    private Random rg = new Random();
    private int z = rg.nextInt(100);

    public Pseudo_Rand_numbers(int a, int b, int m) {
        this.a = a;
        this.b = b;
        this.m = m;
    }

    private void calculateRandomNummber() {
        // m + 2 runs so you can see when the sequence starts repeating
        for (int i = 0; i <= this.m + 1; i++) {
            int zf = Math.floorMod(((long) this.a * this.z) + this.b, this.m);
            this.z = zf;
            System.out.println(zf);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            final int a = readValidInteger(scanner, "Please type in Integer a", Integer.MIN_VALUE);
            final int b = readValidInteger(scanner, "Please type in Integer b", Integer.MIN_VALUE);
            final int m = readValidInteger(scanner, "Please type in Modulo m", 1);

            Pseudo_Rand_numbers generator = new Pseudo_Rand_numbers(a, b, m);
            generator.calculateRandomNummber();
        }
    }

    // Sub Methods
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