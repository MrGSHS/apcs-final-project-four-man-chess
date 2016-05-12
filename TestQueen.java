public class TestQueen{
    public static void main(String[] args){
        for (int x=0; x<10; x++)
            System.out.println("\n\n");
        Board board=new FourChessBoard();
        board.remove(1, 6);
        board.remove(1, 5);
        Piece p=board.getPiece(0, 6);
       
        System.out.println(p.move(board, p, 0, 6, 0, 5));//false
        System.out.println(p.move(board, p, 0, 6, 1, 5));//true
        System.out.println(p.move(board, p, 0, 6, 1, 6));//true
        System.out.println(p.move(board, p, 0, 6, 5, 6));//true
        System.out.println(p.move(board, p, 0, 6, 2, 8));//false
        System.out.println(p.move(board, p, 0, 6, -1, 8));//false
        System.out.println(p.move(board, p, 0, 6, 0, 14));//false
        
        if (p.move(board, p, 0, 6, 5, 6)){
            p.doMove(board, p, 0, 6, 5, 6);
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