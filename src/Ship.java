import java.awt.*;
import javax.swing.*;

public class Ship {
    int row=16;
    int column=16;
    int tileSize=32;
    int boardWidth= tileSize*column;
    int boardHeight=tileSize*row; //512px
    
    int dx=0;
    int x=tileSize*column/2 -tileSize;
    int y=boardHeight-tileSize*4;
    int width=tileSize*2;
    int height=tileSize*2;
    Image shipImg;
    
    public Ship() {
        //this.x=x;
        //this.y=y;
        //this.width=width;
        //this.height=height;
        this.shipImg=new ImageIcon(getClass().getResource("./ship.png")).getImage();
    }

    protected void paintShip(Graphics g) {
    if (this.shipImg != null) {
        g.drawImage(this.shipImg, this.x, this.y, this.width, this.height, null);
        }
    }

    public void move() {
        x = x + dx;
    }

    public void setDx(int newDx) {
        this.dx = newDx;
    }

    

}
