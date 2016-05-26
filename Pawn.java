import java.util.*;

/**
 * creates a pawn piece that moves in a constant direction across the board
 * (it can move one or two squares forward on the first turn and one square forward
 * after that).  It can also capture diagonally.  If it reaches the other end 
 * of the board, it promotes to a queen.
 */
public class Pawn extends Piece{
    int dirRow;
    int dirCol;
    public Pawn(String c){
        super(c);
    }

    public boolean capture(){
        return false;
    }

    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol)
    {

        //Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());        
        int[] a=new int[2];
        Player p1;
        /*List<int[]> list=new ArrayList<int[]>();
        for (int x=0; x<board.getRows(); x++){
            p1=Player.getPlayer(x);
            a[0]=p1.getKingRow();
            a[1]=p1.getKingCol();
            list.add(a);
        }
        */
        boolean c=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!c) return false;

        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        int[] newVal=new int[2];
        int[] newValues=new int[2];        
        Player player=Player.getPlayer(p.getColor());
        int dirRow=player.getDirRow();
        int dirCol=player.getDirCol(); 
        int moved=player.hasMovedTo(fromRow, fromCol);

        int fromTheRow, fromTheCol, toTheRow, toTheCol;
        //above's the prob  
        
        /*for (int x=0; x<b.getRows(); x++){
            p1=Player.getPlayer(x);
            int[] z=list.get(x);
            p1.setKingLoc(a[0], a[1]);
        }
        */
        b=board;
        fromTheRow=fromRow;
        fromTheCol=fromCol;
        toTheRow=toRow;
        toTheCol=toCol;       
       
        if (dirRow<0){
            Piece piece=b.getPiece(fromTheRow-1, toTheCol);
            Piece temp=b.getPiece(toTheRow, toTheCol);
            if (moved<0 && toTheCol-fromTheCol==0 && toTheRow-fromTheRow==-2 && piece==null
            && temp==null
            || toTheRow-fromTheRow==-1 && toTheCol-fromTheCol==0 && piece==null
           
            || toRow-fromTheRow==-1 && Math.abs(toCol-fromCol)==1 && temp!=null
            && !temp.getColor().equals(p.getColor())){     
                return true;
            }
        }
        else{
            if (dirRow>0){
                Piece piece=b.getPiece(fromRow+1, toCol);
                Piece temp=b.getPiece(toRow, toCol);
                if (moved<0 && toCol-fromCol==0 && toRow-fromRow==2 && piece==null
                && temp==null
                || toRow-fromRow==1 && toCol-fromCol==0 && piece==null
               
                || toRow-fromRow==1 && Math.abs(toCol-fromCol)==1 && temp!=null
                && !temp.getColor().equals(p.getColor())){     
                    return true;
                }    
            }
            else if (dirCol>0){
                Piece piece=b.getPiece(toRow, fromCol+1);
                Piece temp=b.getPiece(toRow, toCol);
                if (moved<0 && toCol-fromCol==2 && toRow-fromRow==0 && piece==null
                && temp==null
                || toRow-fromRow==0 && toCol-fromCol==1 && piece==null
               
                || toCol-fromCol==1 && Math.abs(toRow-fromRow)==1 && temp!=null
                && !temp.getColor().equals(p.getColor())){     
                    return true;
                }       
            }
            else if (dirCol<0){
                Piece piece=b.getPiece(toRow, fromCol-1);
                Piece temp=b.getPiece(toRow, toCol);
                if (moved<0 && toCol-fromCol==-2 && toRow-fromRow==0 && piece==null
                && temp==null
                || toRow-fromRow==0 && toCol-fromCol==-1 && piece==null
               
                || toCol-fromCol==-1 && Math.abs(toRow-fromRow)==1 && temp!=null
                && !temp.getColor().equals(p.getColor())){     
                    return true;
                }     
            }              
            fromTheRow=newVal[0];
            fromTheCol=newVal[1];
            toTheRow=newValues[0];
            toTheCol=newValues[1]; 
        }
        
        /*
        Piece piece=b.getPiece(fromTheRow-1, toTheCol);
        Piece temp=b.getPiece(toTheRow, toTheCol);
        if (moved<0 && toTheCol-fromTheCol==0 && toTheRow-fromTheRow==-2 && piece==null
        && temp==null
        || toTheRow-fromTheRow==-1 && toTheCol-fromTheCol==0 && piece==null
       
        || toRow-fromTheRow==-1 && Math.abs(toCol-fromCol)==1 && temp!=null
        && !temp.getColor().equals(p.getColor())){     
            return true;
        }
        */
        
        //en pessan    
        /*
        Player thePlayer=null;
        if (temp!=null)
            thePlayer=Player.getPlayer(temp.getColor());

        
        if (toRow-fromTheRow==-1 && Math.abs(toCol-fromCol)==1 && thePlayer!=null 
        /*&& temp.toString().equals("Pawn  ")
        && Player.getPreviousPlayer(thePlayer).
        getMove(thePlayer.getLength()-1)==newValues)
        {
            return true;
        }
        */
        
        return false;
    }
    
    /*
    private Board rotate(Board board, int numClockwise){
        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        Board temp=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        int rotations=0;
        //Piece temp;
        
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                b.setSquare(x, y, board.getPiece(x, y));
            }
        }        

        while(rotations<numClockwise){
            //temp=new FourChessBoard();

            for (int x=0; x<temp.getRows(); x++){
                for (int y=0; y<temp.getCols(); y++){
                    temp.setSquare(x, y, b.getPiece(x, y));
                }
            }   

            for (int x=0; x<b.getRows(); x++){
                for (int y=0; y<b.getCols(); y++){
                    b.setSquare(x, y, temp.getPiece(board.getCols()-1-y, x));
                }
            }         
            rotations++;
        }
        
        return b;
    }

    private int[] rowCol(Board board, int row, int col, int rotations){
        int[] ret=new int[2];
        int x=0; 
        while (x<rotations){
            int temp=row;
            row=col;
            col=board.getRows()-1-temp;
            x++;
        }
        ret[0]=row;
        ret[1]=col;
        return ret;
    }    
    */
    
    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        
        if (toRow==0 || toRow==board.getRows()-1 || toCol==0
        || toCol==board.getCols()-1){
              board.setSquare(fromRow, fromCol, null);
              board.setSquare(toRow, toCol, new Queen(p.getColor()));
              Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        }
        
        else
            super.doMove(board, p, fromRow, fromCol, toRow, toCol);
    }

    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol, Piece newPiece){
        
        if (toRow==0 || toRow==board.getRows()-1 || toCol==0
        || toCol==board.getCols()-1){
            board.setSquare(fromRow, fromCol, null);
            board.setSquare(toRow, toCol, newPiece);
            Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        }
        
        else
            super.doMove(board, p, fromRow, fromCol, toRow, toCol);
    }
    
    /*
    public boolean promote(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        if ((p.move(board, p, fromRow, fromCol, toRow, toCol))
        && (toRow==0 || toRow==board.getRows()-1 || toCol==0
        || toCol==board.getCols()-1)){
            return true;
            //board.setSquare(fromRow, fromCol, null);
            //board.setSquare(toRow, toCol, newPiece);
            //Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        }
        
        else
            return false;
    }
    */
    
    public String toString(){
        return "Pawn  ";
    }
}