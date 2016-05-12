public class Knight extends Piece{
    public Knight(String color){
        super(color);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        boolean a=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!a) return false;  
        
        int row=toRow-fromRow;
        int col=toCol-fromCol;
        if (row==1 && col==-2 || row==-2 && col==-1
        || row==-2 && col==1 || row==-1 && col==2
        || row==1 && col==2 || row==2 && col==1
        || row==2 && col==-1 || row==-1 && col==-2){
            if (board.getPiece(toRow, toCol)!=null 
            && board.getPiece(toRow, toCol).getColor().equals(p.getColor()))
                return false;
            return true;
        }
        return false;
    }
    public String toString(){
        return "Knight";
    }
}