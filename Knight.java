public class Knight extends Piece{
    public Knight(String color){
        super(color);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        int row=toRow-fromRow;
        int col=toCol-fromCol;
        if (row==1 && col==-2 || row==-2 && col==-1
        || row==-2 && col==-1 || row==-2 && col==1
        || row==-1 && col==2 || row==1 && col==2
        || row==2 && col==1 || row==2 && col==-1){
            if (board.getPiece(toRow, toCol).getColor().equals(p.getColor()))
                return true;
        }
        return false;
    }
    public String toString(){
        return "Knight";
    }
}