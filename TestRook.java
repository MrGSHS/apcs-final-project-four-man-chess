public class TestRook{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        board.remove(1, 3);
        Piece p=board.getPiece(0, 3);
        System.out.println(p.move(board, p, 0, 3, 2, 3));
        System.out.println(p.move(board, p, 0, 3, 0, 4));
        System.out.println(p.move(board, p, 0, 3, 1, 5));
        
        if (p.move(board, p, 0, 3, 2, 3)){
            p.doMove(board, p, 0, 3, 2, 3);
        }
        for (int x=0; x<board.getBoard().length; x++){
            for (int y=0; y<board.getBoard()[0].length; y++){
                if (board.getPiece(x, y)==null)
                    System.out.print("       ");
                else 
                    System.out.print(board.getPiece(x, y).toString()+"   ");
            }
            System.out.println();
        }
    }
}