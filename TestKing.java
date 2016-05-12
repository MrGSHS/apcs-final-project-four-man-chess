public class TestKing{
    public static void main(String[] args){
        for (int x=0; x<10; x++)
            System.out.println("\n\n");
        Board board=new FourChessBoard();
        board.remove(1, 6);
        board.remove(1, 7);
        board.remove(1, 8);
        board.remove(0, 6);
        Piece p=board.getPiece(0, 7);
        System.out.println(p.move(board, p, 0, 7, 1, 7));//true
        System.out.println(p.move(board, p, 0, 7, 1, 6));//true
        System.out.println(p.move(board, p, 0, 7, 1, 8));//true
        System.out.println(p.move(board, p, 0, 7, -1, 6));//false
        System.out.println(p.move(board, p, 0, 7, 2, 7));//false
        System.out.println(p.move(board, p, 0, 7, 0, 8));//false
        
        if (p.move(board, p, 0, 7, 1, 7)){
            p.doMove(board, p, 0, 7, 1, 7);
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