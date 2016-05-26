import java.util.*;
/**
 * contains a complete set of pieces used at the start of a game, 
 * makes sure each player starts with a full set of pieces
 */
public class PieceSet{
    private Piece[][] set=new Piece[2][8];
    public PieceSet(String c){
        set[0][0]=new Rook(c);
        set[0][1]=new Knight(c);
        set[0][2]=new Bishop(c);
        set[0][3]=new Queen(c);
        set[0][4]=new King(c);
        set[0][5]=new Bishop(c);
        set[0][6]=new Knight(c);
        set[0][7]=new Rook(c);
        for (int x=0; x<8; x++){
            set[1][x]=new Pawn(c);
        }
    }
    
    public Piece getPiece(int row, int col){
        return set[row][col];
    }
}