public abstract class Piece{
    private String color;
    private int row;
    private int col;
    public Piece(String c){
        color=c;
    }
    public abstract boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol);
    public abstract boolean capture(/*Board board, int fromRow, int fromCol, 
      int toRow, int toCol*/);
    public void setColor(String c){
        color= c;
    }
    public abstract String toString();
    public String getColor(){
        return color;
    }
    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        
    }
}