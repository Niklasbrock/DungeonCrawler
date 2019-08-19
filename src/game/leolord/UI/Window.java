package game.leolord.UI;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame frame;
    private Container content;

    public Window(){
        frame = new JFrame("Dungeon Crawler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1280,720);
        frame.setResizable(false);
    }
}
