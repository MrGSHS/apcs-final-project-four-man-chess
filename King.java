public class King extends Piece{
    public King(String c){
        super(c);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        boolean a=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!a) return false;
        
        int row=toRow-fromRow;
        int col=toCol-fromCol;
        if (Math.abs(row)<2 && Math.abs(col)<2 && (row!=0 || col!=0)){
            if (board.getPiece(toRow, toCol)!=null 
            && board.getPiece(toRow, toCol).getColor().equals(p.getColor()))
                return false;
            return true;            
        }
        return false;
    }
    public String toString(){
        return "King  ";
    }
    public String inCheck(){
        return "CHECK";
    }
}