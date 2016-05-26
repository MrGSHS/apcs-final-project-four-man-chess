import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Polygon;

/**
 * full functional four man chess game.  Applet that draws a board with the pieces on it
 * and rotates players to move following the rules of four man chess.
 */
public class FourChessGUI extends Applet implements MouseListener{
    private final int APPLET_WIDTH = 700;
    private final int APPLET_HEIGHT = 700;
    private JButton[] buttons=new JButton[14*14];
    private JLabel  label;
    private JPanel appletPanel;
    //private GUI drawing;
    private int count=0, xPos, yPos;
    private Piece piece=null;

    private Font myFont=new Font("TimesRoman", 1, 20);

    private Board board=new FourChessBoard();   
    private int fromRow=0, fromCol=0, toRow=0, toCol=0;
    private Player turn=Player.getPlayer("white");
    private int numPlayers=Player.getNumPlayers();
    private String c=turn.getColor(), color;
    private Player temp=turn.getNextPlayer(turn);
    
    public void init(){
        appletPanel=new JPanel();
        //drawing=new GUI();
        //appletPanel.add(drawing);
        //getContentPane().add (appletPanel);

        setSize (APPLET_WIDTH, APPLET_HEIGHT);    
        setBackground(Color.white);
        addMouseListener(this);
        //setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));      

    }

    public void paint (Graphics g){
        super.paint(g);
        //g.setColor(Color.yellow);
        g.setFont(myFont);
        drawBoard(g);
    }   

    public void drawBoard(Graphics g){
        ///if (turn.isCheckmate(
        
        
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
        Piece piece;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                Piece p=board.getPiece(x, y);
                //String str=p.toString();
                if (p!=null){
                    if (p.getColor().equals("white"))
                        g.setColor(Color.white);
                    else if (p.getColor().equals("yellow"))
                        g.setColor(Color.yellow);
                    else if (p.getColor().equals("black"))
                        g.setColor(Color.black);
                    else if (p.getColor().equals("blue"))
                        g.setColor(Color.blue);

                    if (p.toString().equals("Rook  ")){
                        g.fillRect(x*50+10, y*50+10, 30, 30);
                        g.setColor(Color.black);
                        g.drawRect(x*50+10, y*50+10, 30, 30);
                    }
                    else if (p.toString().equals("Pawn  ")){
                        g.fillOval(x*50+15, y*50+15, 20, 20);
                        g.setColor(Color.black);
                        g.drawOval(x*50+15, y*50+15, 20, 20);
                    }
                    else if (p.toString().equals("King  ")){
                        g.fillOval(x*50, y*50, 50, 50);
                        g.setColor(Color.black);
                        g.drawOval(x*50, y*50, 50, 50);
                    }
                    else if (p.toString().equals("Bishop")){
                        drawBishop(x*50, y*50, 50, 50, g);
                    }
                    else if (p.toString().equals("Queen ")){
                        drawQueen(x*50, y*50, 50, 50, g);
                    }
                    else if (p.toString().equals("Knight")){
                        drawKnight(x*50, y*50, 50, 50, g);
                    }
                    else{
                        g.fillOval(x*50, y*50, 50, 50);
                        g.setColor(Color.black);
                        g.drawOval(x*50, y*50, 50, 50);
                    }                    
                }
            }
        }

        g.setColor(Color.green);
        g.fillOval(xPos/50*50, yPos/50*50, 20, 20);        
        if (numPlayers==1){
            g.setColor(Color.green);
            g.drawString(turn.getColor()
                +" wins!", 0,100);
        }
        else{
            g.setColor(Color.green);
            g.drawString(turn.getColor()+"'s turn", 0, 100);
        }
        //g.fillRect(0, 0, 150, 150);

    }   

    public void drawBishop(int x, int y, int w, int h, Graphics g){
        Polygon b=new Polygon();
        b.addPoint(x+w/2,y);
        b.addPoint(x, y+h);
        b.addPoint(x+h, y+w);
        g.fillPolygon(b);
        g.setColor(Color.black);
        g.drawPolygon(b);
    }

    public void drawQueen(int x, int y, int w, int h, Graphics g){
        Polygon q=new Polygon();
        q.addPoint(x+w/2, y);
        q.addPoint(x, y+h*3/4);
        q.addPoint(x+w, y+h*3/4);

        Polygon p=new Polygon();
        p.addPoint(x+w/2, y+h);
        p.addPoint(x, y+h/4);
        p.addPoint(x+w, y+h/4);

        g.fillPolygon(q);
        g.fillPolygon(p);
        g.setColor(Color.black);
        g.drawPolygon(q);
        g.drawPolygon(p);
    }

    public void drawKnight(int x, int y, int w, int h, Graphics g){
        Polygon n=new Polygon();
        n.addPoint(x+w/4, y+h/4);
        n.addPoint(x+w*3/4, y);
        n.addPoint(x+w*3/4, y+h);
        n.addPoint(x+w/3, y+h);
        n.addPoint(x+w/3, y+h/2);
        n.addPoint(x+w/4, y+h/2);
        g.fillPolygon(n);
        g.setColor(Color.black);
        g.drawPolygon(n);
    }
    
    /**
     * first click selects a piece and the second click moves the piece on the board
     * to that square if it's a legal move (otherwise, they try to do a legal move
     * again.  If the player lost his king, then he is out of the game and the 
     * remaining players continue playing until there's one player left.
     */
    public void mouseClicked(MouseEvent me){

        xPos=me.getX();//from realapplets.com
        yPos=me.getY();//

        if (count==0){
            c=turn.getColor();
            fromRow=xPos/50;
            fromCol=yPos/50;
            piece=board.getPiece(fromRow, fromCol);
            if (piece==null || !piece.getColor().equals(c)){}
            else
                count++;
        }
        else if (count==1){
            toRow=xPos/50;
            toCol=yPos/50;

            if (!piece.getColor().equals(turn.getColor())){}
            else if (piece.move(board, piece, fromRow, fromCol, toRow, toCol)){
                piece.doMove(board, piece, fromRow, fromCol, toRow, toCol);
                turn=Player.getNextPlayer(turn);
                //temp=turn.getNextPlayer(turn);
                
                if (turn.isCheckmate(board)){
                    //turn=turn.getNextPlayer(turn);
                    turn=Player.getPlayer(c);
                    turn=turn.getNextPlayer(turn);
                    //turn=temp;
                }
                
                numPlayers=Player.getNumPlayers();

            }
            count=0;
            fromRow=0;
            toRow=0;

        }
        repaint();
    }

    public void mouseReleased(MouseEvent me){}

    public void mouseEntered(MouseEvent me){}

    public void mouseExited(MouseEvent me){}

    public void mousePressed(MouseEvent me){}
}