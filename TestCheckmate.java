public class TestCheckmate{
    public static void main(String[] args){
        
        /*
        Board b=new Board(4, 4, true);
        
        Piece bKing=new King("black");
        Piece wQueen=new Queen("white");
        Piece wKing=new King("white");
                
        //b.setSquare(1, 0, new King("black"));
        //b.setSquare(1, 1, new Queen("white"));
        //b.setSquare(1, 2, new King("white"));
        
        wQueen.doMove(b, wQueen, 1, 1);
        bKing.doMove(b, bKing, 1, 0);
        wKing.doMove(b, wKing, 1, 2);    
        //wQueen.doMove(b, wQueen, 2, 0);
        Piece p=b.getPiece(1, 0);
        System.out.println(p.move(b, p, 1, 0, 1, 1));//false      
        
        Player p1=Player.getPlayer("white");
        Player p2=Player.getPlayer("black");
        
        System.out.println(p1.isCheckmate(b)+"\n"+p2.isCheckmate(b));//false \n true
        
        
        for (int x=0; x<b.getRows(); x++){
            for (int y=0; y<b.getCols(); y++){
                if (b.getPiece(x, y)==null)
                    System.out.print("null         ");
                else 
                    System.out.print(b.getPiece(x, y).toString()
                    +b.getPiece(x, y).getColor()+"  ");
            }
            System.out.println();
        } 
        
        */
        
        Board board=new FourChessBoard();
        
        Player p=Player.getPlayer("white");
        Player p2=Player.getPlayer("black");
        
        board.setSquare(11, 8, new Knight("white"));
        board.setSquare(12, 7, new Knight("black"));
        board.setSquare(12, 9, new Knight("black"));
        board.setSquare(13, 9, new Bishop("black"));
        
        //System.out.println(p.getKingRow()+"\n"+p.getKingCol());
        System.out.println(p.isCheckmate(board));//false
        System.out.println(p2.isCheckmate(board));//true
        //System.out.println(p.getKingRow()+"\n"+p.getKingCol());
        for (int x=0; x<board.getBoard().length; x++){
            for (int y=0; y<board.getBoard()[0].length; y++){
                if (board.getPiece(x, y)==null)
                    System.out.print("            ");
                else 
                    System.out.print(board.getPiece(x, y).toString()+" "
                    +board.getPiece(x, y).getColor());
            }
            System.out.println();
        }  
        
       
        //player has no pieces
        
        //if King is in check run isCheckmate
            //if false, nothing happens
            //if true, remove player, player's pieces
        
    }
}