/**
 * Creates a queen piece that can move side to side, up and down, and diagonally
 * unless a piece is in its way.
 */
public class Queen extends Piece{
    public Queen(String c){
        super(c);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        boolean a=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!a) return false;
        if ((toRow!=fromRow || toCol!=fromCol) && board.getPiece(fromRow, fromCol)!=null
        &&  board.getPiece(fromRow, fromCol)!=p)
            return false;
        if (/*fromRow==toRow && p==board.getPiece(fromRow, fromCol) || */(toRow-fromRow!=0 || toCol-fromCol!=0)
        && board.getPiece(fromRow, fromCol)!=null &&  board.getPiece(fromRow, fromCol)!=p)
            return false;
        if (fromRow==toRow && fromCol==toCol){
            if (board.getPiece(fromRow, fromCol)!=null 
            && board.getPiece(toRow, toCol).getColor().equals(p.getColor()))
                return false;
            return true;
        }
        
        int dirRow=toRow-fromRow;
        int dirCol=toCol-fromCol;
        
        if (dirRow>0 && dirCol>0){
            return move(board, p, fromRow+1, fromCol+1, toRow, toCol);
        }
        if (dirRow>0 && dirCol==0)
           return move(board, p, fromRow+1, fromCol, toRow, toCol);
        if (dirRow>0 &&dirCol<0)
            return move(board, p, fromRow+1, fromCol-1, toRow, toCol);
        if (dirRow==0 && dirCol<0)
            return move(board, p, fromRow, fromCol-1, toRow, toCol);
        if(dirRow<0 && dirCol<0)
            return move(board, p, fromRow-1, fromCol-1, toRow, toCol);
        if(dirRow<0 && dirCol==0)
            return move(board, p, fromRow-1, fromCol, toRow, toCol);
        if (dirRow<0 && dirCol>0)
            return move(board, p, fromRow-1, fromCol+1, toRow, toCol);
        return move(board, p, fromRow, fromCol+1, toRow, toCol);
    }
    public String toString(){
        return "Queen ";
    }
}