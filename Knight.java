public class Knight extends Piece{
    public Knight(String color){
        super(color);
    }
    public String getColor(){
        return getColor();
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        return false;
    }
    public String toString(){
        return "Knight";
    }
}