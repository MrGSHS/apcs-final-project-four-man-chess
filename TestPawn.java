public class TestPawn{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        //board.add
        Piece p=board.getPiece(1, 4);
        System.out.println(p.move(board, p, 1, 4, 3, 4));//true
        System.out.println(p.move(board, p, 1, 4, 3, 4));//true
        
        p=board.getPiece(4, 1);
        System.out.println(p.move(board, p, 4, 1, 4, 3));//true  
        
        p=board.getPiece(12, 4);
        System.out.println(p.move(board, p, 12, 4, 10, 4));//true  
        System.out.println(p.move(board, p, 12, 4, 11, 4));//true
        //if(p.move(board, p, 1, 4, 3, 4))
        //   p.doMove(board, p, 1, 4, 3, 4);
            
        //System.out.println(p.move(board, p, 3, 4, 5, 4));//false
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