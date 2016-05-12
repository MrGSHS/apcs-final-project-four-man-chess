public abstract class Piece{
    private String color;
    private int row;
    private int col;
    public Piece(String c){
        color=c;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        int rows=board.getRows();
        int cols=board.getCols();
        if (toRow>=rows || toCol>=cols || fromRow>=rows || fromCol>=cols
        || toRow<0 || toCol<0 || fromRow<0 || fromCol<0)
            return false;
        return true;
    }
    //public abstract boolean capture(/*Board board, int fromRow, int fromCol, 
    //  int toRow, int toCol*/);
    public void setColor(String c){
        color= c;
    }
    public abstract String toString();
    public String getColor(){
        return color;
    }
    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        board.setSquare(toRow, toCol, board.remove(fromRow, fromCol));
    }
}