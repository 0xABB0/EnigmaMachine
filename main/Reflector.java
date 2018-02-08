package main;

public class Reflector {

    public static final String INPUT = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
    public static final Reflector B = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
    public static final Reflector C = new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");

    public char[] output = "zyxwvutsrqponmlkjihgfedcba".toUpperCase().toCharArray();
    public int offset;

    public char output(char input) {
        return output[INPUT.indexOf(input)];
    }

    private Reflector(String output) {
        this.output = output.toUpperCase().toCharArray();
    }
    
    public Reflector(Reflector reflector){
        this.output = reflector.output;
    }

    public void setOffset(char a) {
        offset = a - 'a';
    }
}
