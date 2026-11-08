package versuch_eins;

import java.util.Random;
import java.util.Scanner;

public class Pseudo_Rand_numbers 
{
    final int a;
    final int b;
    final int m;
    Random rg = new Random();
    private int z = rg.nextInt();

    public Pseudo_Rand_numbers(int a, int b, int m)
    {
        this.a = a;
        this.b = b;
        this.m = m;
    }
    
    public void calculateRandomNummber()
    {
        for(int i = 0; i <= this.m+1; i++)
        {
            int zf = Math.floorMod(((long) this.a * this.z) + this.b, this.m);
            this.z = zf;
            System.out.println(zf);
        }
    }

    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in)) {

        final int a = readValidInteger(scanner, "Please type in Integer a", Integer.MIN_VALUE);
        final int b = readValidInteger(scanner, "Please type in Integer b", Integer.MIN_VALUE);
        final int m = readValidInteger(scanner, "Please type in Modulo m", 1);

        Pseudo_Rand_numbers generator = new Pseudo_Rand_numbers(a, b, m);
        generator.calculateRandomNummber();
        scanner.close();
        }
    }

    //Sub Methods
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