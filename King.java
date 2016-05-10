public class King extends Piece{
    public King(String c){
        super(c);
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
        return "King";
    }
    public String inCheck(){
        return "CHECK";
    }
}