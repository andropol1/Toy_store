import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ToyBox toybox = new ToyBox();
        ToysPrize toysprize = new ToysPrize();
        Menu menu = new Menu(toybox, toysprize);
        menu.start();

    }
}