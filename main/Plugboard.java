package main;

public class Plugboard {

    char[] we;

    public Plugboard(String toPlug) throws EnigmaException {
        if (toPlug.length() >= 26) {
            throw new EnigmaException("Too many plug");
        }
        if (toPlug.length() % 2 != 0) {
            throw new EnigmaException("Uneven number of plug");
        }
        we = new char[toPlug.length()];
        System.arraycopy(toPlug.toUpperCase().toCharArray(), 0, we, 0, toPlug.length());
    }

    public char output(char character) {
        for (int i = 0; i < we.length; i++) {
            if (we[i] == character) {
                if (i % 2 == 0) {
                    return we[i++];
                } else {
                    return we[i--];
                }
            }
        }
        return character;
    }
}
