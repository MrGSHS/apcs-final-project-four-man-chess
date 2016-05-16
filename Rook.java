public class Rook extends Piece{
    public Rook(String c){
        super(c);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        boolean a=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!a) return false;        
        
        int total;
        if ((toRow-fromRow!=0 || toCol-fromCol!=0) && board.getPiece(fromRow, fromCol)!=null &&  board.getPiece(fromRow, fromCol)!=p)
            return false;
        if (toRow-fromRow!=0 && toCol-fromCol!=0)
            return false;
        
        if (fromRow==toRow && fromCol==toCol){
            if (board.getPiece(fromRow, fromCol)!=null 
            && board.getPiece(toRow, toCol).getColor()==p.getColor())
                return false;
            return true;
        }
        if (fromRow-toRow==0){
            total=Math.abs(fromCol-toCol);
        }
        else 
            total=Math.abs(fromRow-toRow);
            
        if (toRow-fromRow!=0){
            if (toRow-fromRow<0)
                return move(board, p, fromRow-1, fromCol, toRow, toCol);
            else
                return move(board, p, fromRow+1, fromCol, toRow, toCol);
        }
        else{
            if (toCol-fromCol<0)
                return move(board, p, fromRow, fromCol-1, toRow, toCol);
            else 
                return move(board, p, fromRow, fromCol+1, toRow, toCol);
        }
        
        
    }
    public String toString(){
        return "Rook  ";
    }
}