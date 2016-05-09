public class Rook extends Piece{
    public Rook(String c){
        super(c);
    }
    public String getColor(){
        return getColor();
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }
    public String toString(){
        return "Rook";
    }
}