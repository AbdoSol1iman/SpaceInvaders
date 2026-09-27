import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;


public class Chickens {

    int row=16;
    int column=16;
    int tileSize=32;
    int boardWidth= tileSize*column;
    int boardHeight=tileSize*row; //512px
    
    int x=tileSize*column/2 -tileSize;
    int y=tileSize*2;
    int width=tileSize*2;
    int height=tileSize*2;
    Image whiteChickenImg;
    Image redChickenImg;
    ArrayList <Image> chickensImgs=new ArrayList<>();

    Image randomImg;

    Chickens() {
        whiteChickenImg=new ImageIcon(getClass().getResource("./chicken2.png")).getImage();
        redChickenImg=new ImageIcon(getClass().getResource("./chicken1.png")).getImage();
        chickensImgs.add(redChickenImg);
        chickensImgs.add(whiteChickenImg);

        Random random=new Random();
        randomImg =this.chickensImgs.get(random.nextInt(2)); 

    }

    protected void paintChickens(Graphics g) {
        if ( randomImg!=null) {
        g.drawImage(randomImg, this.x, this.y, this.width, this.height, null);
        }
    }


    public class Eggs{
        
    }


}
