public class Pawn extends Piece{
    public Pawn(String c){
        super(c);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }
    public String toString(){
        return "Pawn";
    }
}