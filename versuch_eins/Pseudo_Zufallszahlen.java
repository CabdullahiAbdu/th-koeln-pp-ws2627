package versuch_eins;

import java.util.Random;
import java.util.Scanner;

public class Pseudo_Zufallszahlen 
{
    final int a;
    final int b;
    final int m;
    Random rg = new Random();
    private int z = rg.nextInt();

    public Pseudo_Zufallszahlen(int a, int b, int m)
    {
        this.a = a;
        this.b = b;
        this.m = m;
    }
    
    public void berechneZufallszahl()
    {
        for(int i = 0; i < 100; i++)
        {
            int zf = (int) ((((long)this.a * this.z) + this.b) % this.m);
            this.z = zf;
            System.out.println(zf);
        }
    }

    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int a = leseValidenInteger(scanner, "Bitte Ganzzahl Variable a eingeben", 0);
        int b = leseValidenInteger(scanner, "Bitte Ganzzahl Variable b eingeben", 0);
        int m = leseValidenInteger(scanner, "Bitte Ganzzahl Variable m eingeben", 1);

        Pseudo_Zufallszahlen generator = new Pseudo_Zufallszahlen(a, b, m);
        generator.berechneZufallszahl();
        scanner.close();
    }

    private static int leseValidenInteger(Scanner scanner, String eingabePrompt, int minValue) 
    {
        while(true)
        {
            try
            {
                System.out.println(eingabePrompt);
                String eingelesen = scanner.nextLine();
                int korrekteZahl = Integer.parseInt(eingelesen);

                if (korrekteZahl >= minValue) {return korrekteZahl;}
                else{System.out.println("Wert ist zu klein.");}
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bitte eine korrekte Ganzzahl einegeben");
            }
        }
    }
}