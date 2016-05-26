import java.util.*;
/**
 * abstract class that can be any of the chess pieces but not a generic piece 
 * because a chess board only hold chess pieces, which are children of the 
 * Piece class, so the board can hold all of the pieces, but the pieces still
 * behave/move differently
 */
public abstract class Piece{
    private String color;
    private int row;
    private int col;
    public Piece(String c){
        color=c;
    }

    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        if (board==null || p==null)
            return false;
        //if King is in Check when piece is at toRow, toCol
        //    return false;
        if (board.getCols()==14 && board.getRows()==14){
            if ((toRow<3 || toRow>10)&&(toCol<3 || toCol>10))
                return false;
        }
        int rows=board.getRows();
        int cols=board.getCols();
        if (toRow>=rows || toCol>=cols || fromRow>=rows || fromCol>=cols
        || toRow<0 || toCol<0 || fromRow<0 || fromCol<0)
            return false;

        //if (p.isInCheck(board, p, fromRow, fromCol, toRow, toCol))
        //    return false;
        
        //int kingRow, kingCol;

        return true;
    }

    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol, Piece newPiece){
        //public abstract boolean capture(/*Board board, int fromRow, int fromCol, 
        //  int toRow, int toCol*/);

    }

    public void setColor(String c){
        color= c;
    }

    public abstract String toString();

    public String getColor(){
        return color;
    }

    /*public boolean move(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol, Piece newPiece){
    Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
    board.setSquare(toRow, toCol, board.remove(fromRow, fromCol));
    }
     */

    public Board doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol, int a){
        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                b.setSquare(x, y, board.getPiece(x, y));
            }
        }
        //Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        b.setSquare(fromRow, fromCol, null);
        b.setSquare(toRow, toCol, p);
        //b.setSquare(toRow, toCol, b.remove(fromRow, fromCol));
        /*
        if (p.toString().equals("King  ")){
        Player player=Player.getPlayer(p.getColor());
        player.setKingRow(toRow);
        player.setKingCol(toCol);
        }*/
        return b;

    }

    public void doMove(Board board, Piece p, int toRow, int toCol){
        board.setSquare(toRow, toCol, p);
        /*
        if (p.toString().equals("King  ")){
        Player player=Player.getPlayer(p.getColor());
        player.setKingLoc(toRow, toCol);
        }   ]*/             
    }

    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        board.setSquare(toRow, toCol, board.remove(fromRow, fromCol));
        //in king class
        /*
        if (p.toString().equals("King  ")){
        Player player=Player.getPlayer(p.getColor());
        player.setKingRow(toRow);
        player.setKingCol(toCol);
        }
         */
    } 
    
    
    public boolean isInCheck(Board board, Piece p, int fromRow, int fromCol, 
    int row, int col){
        /*
        Piece king=null;
        Piece p5;
        int kingRow=0, kingCol=0;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                p5=board.getPiece(x, y);
                if (p5!=null && p5.toString().equals("King  ") && 
                p5.getColor().equals(color)){
                    king=(King)p5;
                    kingRow=x;
                    kingCol=y;
                }
            }
        }
        
        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        for (int x=0; x<b.getRows(); x++){
            for (int y=0; y<b.getCols(); y++){
                b.setSquare(x, y, board.getPiece(x, y));
            }
        }
        Piece piece=board.getPiece(row, col);
        p=board.getPiece(fromRow, fromCol);
        board.setSquare(fromRow, fromCol, null);
        board.setSquare(row, col, null);

        Piece temp;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                temp=board.getPiece(x, y);
                if ( temp==null || p==null || temp.getColor().equals(p.getColor())){}
                else if (temp.move(board, temp, x, y, kingRow, kingCol)){
                    board.setSquare(row, col, piece);
                    board.setSquare(fromRow, fromCol, p);
                    return true;
                }
            }
        }
        board.setSquare(row, col, piece);
        board.setSquare(fromRow, fromCol, p);
        */

        /*
        Piece king=null;
        Piece p5;
        //int kingRow=0, kingCol=0;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                p5=board.getPiece(x, y);
                if (p5!=null && p5.toString().equals("King  ") && 
                p5.getColor().equals(color)){
                    king=(King)p5;
                    //kingRow=x;
                    //kingCol=y;
                }
            }
        }
        if (king==null){return true;}
        
        return king.isInCheck(board, p, fromRow, fromCol, row, col);
        */
       return false;
    }
    
    
   
    //public boolean isInCheck(Board board, String color){
    //    return false;
    //}

    public boolean promote(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        return false;
    }
    //public abstract List<int>/*toRow, toCol*/ getMoves(Board board, Piece piece);
}