import java.awt.*;
import javax.swing.JPanel;
public class GUI extends JPanel{
   private final int PANEL_WIDTH = 700;
   private final int PANEL_HEIGHT = 700;
   private Board board=new FourChessBoard();
   public GUI(){
       setBackground(Color.black);
       setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }
   public void paint (Graphics g){
       super.paint(g);
       g.setColor(Color.yellow);
       
       drawBoard(g);
   }
   
   public void drawBoard(Graphics g){
       for (int x=0; x<board.getRows(); x++){
           for (int y=0; y<board.getCols(); y++){
                if ((x<3||x>10) && (y<3 || y>10))
                    g.setColor(Color.black);
                else if (x%2==0 && y%2==1 || x%2==1 && y%2==0)
                    g.setColor(Color.white);
                else
                    g.setColor(Color.red);
                
                g.fillRect(x*50, y*50, 50, 50);
           }
       }
       g.fillRect(0, 0, 150, 150);
   }
}