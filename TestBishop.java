/**
 * Tests if the Bishop works correctly
 */
public class TestBishop{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        board.remove(1, 4);
        Piece p=board.getPiece(0, 5);
        System.out.println(p.move(board, p, 0, 5, 1, 4));//true
        System.out.println(p.move(board, p, 0, 5, 1, 5));//false
        System.out.println(p.move(board, p, 0, 5, 1, 6));//false
        System.out.println(p.move(board, p, 0, 5, 2, 7));//false
        System.out.println(p.move(board, p, 0, 5, 2, 3));//true
        System.out.println(p.move(board, p, 0, 5, -1, 4));//false
        
        if (p.move(board, p, 0, 5, 1, 4)){
            p.doMove(board, p, 0, 5, 1, 4);
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