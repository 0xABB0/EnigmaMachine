package main;
public class EnigmaException extends Exception{
    String error;
    public EnigmaException(String error){
        this.error=error;
    }
}
