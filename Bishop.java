public class Bishop extends Piece{
    public Bishop(String c){
        super(c);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol,
    int toRow, int toCol){
        boolean a=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!a) return false;
        if (toRow-fromRow!=0 && board.getPiece(fromRow, fromCol)!=null &&  board.getPiece(fromRow, fromCol)!=p)
            return false;
        if (Math.abs(toRow-fromRow)!=Math.abs(toCol-fromCol) || fromRow==toRow 
        && p==board.getPiece(fromRow, fromCol))
            return false;
        if (fromRow==toRow){
            if (board.getPiece(fromRow, fromCol)!=null 
            && board.getPiece(toRow, toCol).getColor().equals(p.getColor()))
                return false;
            return true;
        }
        
        boolean dirRow=(toRow-fromRow>0);
        boolean dirCol=(toCol-fromCol>0);
        if (dirRow && dirCol){
            return move(board, p, fromRow+1, fromCol+1, toRow, toCol);
        }
        if (dirRow)
           return move(board, p, fromRow+1, fromCol-1, toRow, toCol);
        if (dirCol)
            return move(board, p, fromRow-1, fromCol+1, toRow, toCol);
        return move(board, p, fromRow-1, fromCol-1, toRow, toCol);
    }
    public String toString(){
        return "Bishop";
    }
}