/**
 * Tests if the knight works correctly
 */
public class TestKnight{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        
        Player p1=Player.getPlayer("white");
        Player p2=Player.getPlayer("black");        
        //System.out.println(p1.getKingRow()+"\n"+p1.getKingCol());        
        
        board.remove(1, 6);
        Piece p=board.getPiece(0, 4);
        System.out.println(p.move(board, p, 0, 4, 1, 6));//true
        System.out.println(p.move(board, p, 0, 9, 1, 7));//false
        System.out.println(p.move(board, p, 0, 4, 2, 5));//true
        System.out.println(p.move(board, p, 0, 4, -1, 6));//false
        
        if (p.move(board, p, 0, 4, 1, 6)){
            p.doMove(board, p, 0, 4, 1, 6);
        }
               
        for (int x=0; x<board.getBoard().length; x++){
            for (int y=0; y<board.getBoard()[0].length; y++){
                if (board.getPiece(x, y)==null)
                    System.out.print("          ");
                else 
                    System.out.print(board.getPiece(x, y).toString()+"    ");
            }
            System.out.println();
        }
    }
}