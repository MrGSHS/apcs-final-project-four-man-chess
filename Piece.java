import java.util.*;
public abstract class Piece{
    private String color;
    private int row;
    private int col;
    public Piece(String c){
        color=c;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
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
        Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        b.setSquare(toRow, toCol, b.remove(fromRow, fromCol));
        if (p.toString().equals("King  ")){
            Player player=Player.getPlayer(p.getColor());
            player.setKingRow(toRow);
            player.setKingCol(toCol);
        }
        return b;
    }
    
    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        board.setSquare(toRow, toCol, board.remove(fromRow, fromCol));
        if (p.toString().equals("King  ")){
            Player player=Player.getPlayer(p.getColor());
            player.setKingRow(toRow);
            player.setKingCol(toCol);
        }
    }    
    
    //public abstract List<int>/*toRow, toCol*/ getMoves(Board board, Piece piece);
}