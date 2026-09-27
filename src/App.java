import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javazoom.jl.player.Player;


public class App {
    public static void main(String[] args) throws Exception {
        final int row=16;
        final int column=16;
        final int tileSize=32;
        final int boardWidth= tileSize*column;
        final int boardHeight=tileSize*row; //512px

        JFrame frame=new JFrame("Space Invaders");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        MainPanel mainPanel=new MainPanel();
        
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);//set visibility after adding the compnents
        playSound("./src/leezr.mp3");

    }
    public static void playSound(String filePath) {
       try {
            FileInputStream fis = new FileInputStream(filePath);
            Player player = new Player(fis);
            player.play(); // This blocks the thread until the song finishes
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
