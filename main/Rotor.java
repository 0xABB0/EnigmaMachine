package main;

public class Rotor {

    static final String INPUT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final Rotor I = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "R");
    public static final Rotor II = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", "F");
    public static final Rotor III = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", "W");
    public static final Rotor IV = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", "K");
    public static final Rotor V = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", "A");

    public static final Rotor VI = new Rotor("JPGVOUMFYQBENHZRDKASXLICTW", "AN");
    public static final Rotor VII = new Rotor("NZJHGRCXMYSWBOUFAIVLPEKQDT", "AN");
    public static final Rotor VIII = new Rotor("FKQHTLXOCBJSPDZRAMEWNIUYGV", "AN");

    public static final Rotor BETA = new Rotor("LEYJVCNIXWPBQMDRTAKZGFUHOS");
    public static final Rotor GAMMA = new Rotor("FSOKANUERHMBTIYCWLQPZXVGJD");

    private String connections;
    private String rConnections;
    private String notches;

    private int offset;

    private Rotor(String connections, String notches) {
        this.connections = connections;
        this.notches = notches;
        initRConn();
        offset = 0;
    }

    private Rotor(String connections) {
        this.connections = connections;
        initRConn();
        this.notches = "";
    }

    private void initRConn() {
        char[] revArr = new char[26];
        for (int i = 0; i < this.connections.length(); i++) {
            revArr[(int) this.connections.charAt(i) - 65] = (char) (i + 65);
        }
        String ro = "";
        for (char c : revArr) {
            ro += String.valueOf(c);
        }
        rConnections = ro;
    }

    public char output(char in) {
        int index = in - 'A' + offset;
        char a = connections.charAt(index % 26);
        char b = (char) ((a - 'A' - offset + 26) % 26 + 'A');
        return b;
    }

    public char outputInv(char in) {
        int index = in - 'A' + offset;
        char a = rConnections.charAt(index % 26);
        char b = (char) ((a - 'A' - offset + 26) % 26 + 'A');
        return b;
    }

    boolean turn() {
        offset = (offset + 1) % 26;
        return notches.indexOf((char) ('A' + offset) % 26) != -1;
    }

    public String getConnections() {
        return connections;
    }

    public String getNotches() {
        return notches;
    }

    public int getIndex() {
        return offset;
    }

    public void setIndex(int index) {
        this.offset = index;
    }

    private String getrConnections() {
        return rConnections;
    }

}
