public class TestKing{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        board.remove(1, 6);
        board.remove(1, 7);
        board.remove(1, 8);
        board.remove(0, 6);
        
        board.remove(3, 1);
        
        Piece p=board.getPiece(0, 7);
        Player p1=Player.getPlayer("white");
        //System.out.println(p1.getKingRow()+"  "+p1.getKingCol());
        
        //rotates once b/c kingRow, kingCol
        System.out.println(p.move(board, p, 0, 7, 1, 7));//true
        
        //doesn't rotate b/c not kingRow, kingCol anymore
        
        //System.out.println(p1.getKingRow()+"  "+p1.getKingCol());
        
        System.out.println(p.move(board, p, 0, 7, 1, 6));//true
        
        //System.out.println(p1.getKingRow()+"  "+p1.getKingCol());
        
        System.out.println(p.move(board, p, 0, 7, 1, 8));//true
        System.out.println(p.move(board, p, 0, 7, -1, 6));//false
        System.out.println(p.move(board, p, 0, 7, 2, 7));//false
        System.out.println(p.move(board, p, 0, 7, 0, 8));//false
        
        System.out.println(p.move(board, p, 0, 7, 0, 8));//false;
        
        if (p.move(board, p, 0, 7, 1, 7)){
            p.doMove(board, p, 0, 7, 1, 7);
        }
        
        if (p.move(board, p, 1, 7, 2, 7))
            p.doMove(board, p, 1, 7, 2, 7);
        
        System.out.println(p.move(board, p, 2, 7, 3, 7));//false
        System.out.println(board.getPiece(3, 0).move(board, board.getPiece(3, 0), 3, 0, 3, 7));//true;
        
        System.out.println(p.getColor()+" "+p.toString()+"   "
        +board.getPiece(3, 0).getColor()+" "+board.getPiece(3, 0).toString());
        for (int x=0; x<board.getBoard().length; x++){
            for (int y=0; y<board.getBoard()[0].length; y++){
                if (board.getPiece(x, y)==null)
                    System.out.print("          ");
                else 
                    System.out.print(board.getPiece(x, y).toString()+"    ");
            }
            System.out.println();
        }
        //System.out.println(Player.getPlayer("white").getKingRow());
        //System.out.println(Player.getPlayer("white").getKingCol());
        
        Piece queen=new Queen("black");
        board.setSquare(2, 5, queen);
        //System.out.println(Player.getPlayer("black").isInCheck(board));
    }
}