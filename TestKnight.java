public class TestKnight{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        board.remove(1, 4);
        Piece p=board.getPiece(0, 5);
        System.out.println(p.move(board, p, 0, 5, 1, 4));
        System.out.println(p.move(board, p, 0, 5, 1, 5));
        System.out.println(p.move(board, p, 0, 5, 1, 5));
        System.out.println(p.move(board, p, 0, 5, 1, 6));
        System.out.println(p.move(board, p, 0, 5, 2, 7));
        System.out.println(p.move(board, p, 0, 5, 2, 3));
        System.out.println(p.move(board, p, 0, 5, 2, 3));
        
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