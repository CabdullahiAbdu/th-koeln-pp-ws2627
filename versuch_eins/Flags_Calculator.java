package versuch_eins;

public class Flags_Calculator {
    short flags;
    byte k;

    public Flags_Calculator(short flags, byte k) {
        this.flags = flags;
        this.k = k;
    }

    private int calculatePos() {
        int b = (flags >> k) & 1;
        return b;
    }

    public static void main(String[] args)
    {
        
        Flags_Calculator fc = new Flags_Calculator((short)29204,(byte)2);
        int state = fc.calculatePos();
        System.out.println("The State of the: "+ fc.k + " Bit is:" + state);

        String lampState = (state == 1) ? "Lamp is on"  : "Lamp is off";
        System.out.println("The State of the bit:" + lampState);
    }    
}
