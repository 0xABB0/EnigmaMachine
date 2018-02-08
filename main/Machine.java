package main;

public class Machine {

    Rotor first;
    Rotor second;
    Rotor third;
    
    Reflector reflector;

    Plugboard plugboard;

    public Machine(Rotor first, Rotor second, Rotor third, Plugboard plugboard,Reflector reflector) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.plugboard = plugboard;
        this.reflector = reflector;
    }

    public char output(char input) {
        if (input == ' ')
            return ' ';
        if (first.turn()) {
            if (second.turn()) {
                third.turn();
            }
        }
        char a = plugboard.output(input);
        //print(a);
        char b = first.output(a);
       // print(b);
        char c = second.output(b);
      //  print(c);
        char d = third.output(c);
     //   print(d);
        char e = reflector.output(d);
    //    print(e);
        char f = third.outputInv(e);
    //    print(f);
        char g = second.outputInv(f);
   //     print(g);
        char h = first.outputInv(g);
    //    print(h);
        char i = plugboard.output(h);
        return i;
    }
    
    
    public static void print(char a){
        System.out.print(" " + a);
    }
}
