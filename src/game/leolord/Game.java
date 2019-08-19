package game.leolord;


import game.leolord.UI.Window;

import java.util.Scanner;
import static game.leolord.Communication.*;

public class Game implements Runnable{
    private Player player;
    private Scanner input;
    private Thread thread;
    private Window gameWindow;

    public Game(){
//        Start of the program
//        TODO chance this to a proper menu with load game and start new game
        start();
    }
    public void start(){
//        Start of the game
        welcomePrint();
        enterNamePrint();
        input = new Scanner(System.in);
        String inputName = input.nextLine();
        player = new Player(inputName);
        startPrint(player);
        thread = new Thread();
        run();
    }
    public void stop(){
//        End of the game
        Runtime.getRuntime().exit(0);
    }
    public void run(){
        try{
            while(!player.isDead()){
//                  Main game loop
                dungeonMenuPrint();
                Event event = new Event(player, input.nextInt());
                Thread.sleep(3000);
                for(int i = 0; i < 50; i++){
                    Thread.sleep(50);
                    System.out.println(".");
                }
//                TODO add save feature here, so it saves after each event
//                TODO add "save and exit game"  option to dungeon menu
            }
            gameOverPrint();
            stop();
        }catch(Exception e){
            System.out.println("There is an error in the matrix: " + e);
        }

    }
}
