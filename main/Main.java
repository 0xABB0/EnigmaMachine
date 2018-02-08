package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(System.in);
            Machine enigma = new Machine(Rotor.I, Rotor.II, Rotor.III, new Plugboard(""), Reflector.B);
            System.out.println("Enigma machine set with the following setup: FROM LEFT TO RIGHT Rotors type III II I, everyone in the starting position A, reflector type B and no plugs");
            System.out.println("Please provide the plaintext");
            String plaintext = reader.next().toUpperCase();
            char b;
            for (char a: plaintext.toCharArray()){
                b = enigma.output(a);
                System.out.print(b);
            }
            System.out.println("");
            System.out.println("End");
        } catch (EnigmaException ex) {
            System.out.println("ex " + ex);
        }
    }
}
