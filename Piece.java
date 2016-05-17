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
    
    public void doMove(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        Player.getPlayer(p.getColor()).addMove(fromRow, fromCol, toRow, toCol);
        board.setSquare(toRow, toCol, board.remove(fromRow, fromCol));
    }
}