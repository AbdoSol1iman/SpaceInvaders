import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class MainPanel extends JPanel implements ActionListener{

    final int row=16;
    final int column=16;
    final int tileSize=32;
    final int boardWidth= tileSize*column;
    final int boardHeight=tileSize*row; //512px

    Ship ship=new Ship();
    Chickens chickens=new Chickens();



    MainPanel() {

        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.black);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new Controlers());

        Timer gameLoop=new Timer(1000/60, this); //60fps
        gameLoop.start();


    }

    
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g); 
    ship.paintShip(g); 
    chickens.paintChickens(g);
    }


        @Override
    public void actionPerformed(ActionEvent e) {
        ship.move(); 
        repaint(); 
    }

    
    
    public class Controlers implements KeyListener {


        // for controling the ship movement
        private int dx = ship.x; 
        private int dy = ship.y;
        private final int SPEED = 2*tileSize;

    

    // 4. ميثودز الـ KeyListener الإجبارية
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT&& ship.x-tileSize*2 > 0) {
            ship.setDx(-5);
        } else if (keyCode == KeyEvent.VK_RIGHT&& ship.x+tileSize*4 < boardWidth) {
            ship.setDx(5); 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // لما تسيب السهم، وقف السفينة مكانها عشان متفضلش تجري
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            ship.setDx(0);
        }
    }
    
        @Override
        public void keyTyped(KeyEvent e) {
            // Left empty intentionally
        }
    
    
        }
    
}
