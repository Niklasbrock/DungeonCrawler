package game.leolord;

public class Main {

    public static void main(String[] args) {
        Thread gameThread = new Thread(new Game());
    }
}
