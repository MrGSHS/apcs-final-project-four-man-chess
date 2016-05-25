/**
 * creates a king piece that can move one square in any direction but cannot be
 * put in a place where it can be captured.
 */
public class King extends Piece{
    public King(String c){
        super(c);
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, 
    int toRow, int toCol){
        boolean a=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!a) return false;
        
        int row=toRow-fromRow;
        int col=toCol-fromCol;
        if (Math.abs(row)<2 && Math.abs(col)<2 && (row!=0 || col!=0)){
            if (board.getPiece(toRow, toCol)!=null 
            && board.getPiece(toRow, toCol).getColor().equals(p.getColor()))
                return false;
            if (p.isInCheck(board, p, fromRow, fromCol, toRow, toCol))
            //if (Player.getPlayer(p.getColor()).isInCheck(board, p, fromRow, 
            //fromCol, toRow, toCol))
                return false;
            return true;
        }
        return false;

    }
    public String toString(){
        return "King  ";
    }
    
    
    public boolean isInCheck(Board board, Piece p, int fromRow, int fromCol,
    int row, int col){
        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        for (int x=0; x<b.getRows(); x++){
            for (int y=0; y<b.getCols(); y++){
                b.setSquare(x, y, board.getPiece(x, y));
            }
        }
        Piece piece=board.getPiece(row, col);
        p=board.getPiece(fromRow, fromCol);
        board.setSquare(fromRow, fromCol, null);
        board.setSquare(row, col, null);
        
        Piece temp;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                temp=board.getPiece(x, y);
                if ( temp==null || p==null || temp.getColor().equals(p.getColor())){}
                else if (temp.move(board, temp, x, y, row, col)){
                    board.setSquare(row, col, piece);
                    board.setSquare(fromRow, fromCol, p);
                    return true;
                }
            }
        }
        board.setSquare(row, col, piece);
        board.setSquare(fromRow, fromCol, p);
        return false;
    }
    
    
    /*public boolean isInCheck(Board board, String color){
        Piece king=null;
        Piece p5;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                p5=board.getPiece(x, y);
                if (p5!=null && p5.toString().equals("King  ") && 
                p5.getColor().equals(color)){
                    king=(King)p5;
                    
                }
            }
        } 
        //if (king!=null && king.isInCheck(board, king, fromRow, fromCol, toRow, toCol))
        //    return false;
    }
    */
   
    //public Board doMove (Board board, Piece p, int fromRow, int fromCol,
    //int toRow, int toCol){
    //    super.doMove
    //    Player.getPlayer(p.getColor()).setKingLoc(toRow, toCol);
    //}
       
}