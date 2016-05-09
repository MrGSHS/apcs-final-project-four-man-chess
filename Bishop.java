public class Bishop extends Piece{
    public Bishop(String c){
        super(c);
    }
    /*movement = 
    (row+x, col+x)
    (row+x, col-x)
    (row-x, col-x)
    (row-x, col+x)
    */
    public String getColor(){
        return getColor();
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        if (Math.abs(toRow-fromRow)!=Math.abs(toCol-fromCol) || fromRow==toRow 
        && p==board.getPiece(fromRow, fromCol))
            return false;
        if (fromRow==toRow){
            if (board.getPiece(fromRow, fromCol)!=null 
            && board.getPiece(toRow, toCol).getColor()==p.getColor())
                return false;
            return true;
        }
        int total=Math.abs(fromRow-toRow);
        boolean dirRow=(toRow-fromRow>0);
        boolean dirCol=(toCol-fromCol>0);
        for (int x=0; x<total; x++){
            if (dirRow && dirCol){
                return move(board, p, fromRow+1, fromCol+1, toRow, toCol);
            }
            if (dirRow)
                return move(board, p, fromRow+1, fromCol-1, toRow, toCol);
            if (dirCol)
                return move(board, p, fromRow-1, fromCol+1, toRow, toCol);
            return move(board, p, fromRow-1, fromCol-1, toRow, toCol);
        }
        return true;
    }
    public String toString(){
        return "Bishop";
    }
}