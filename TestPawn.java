/**
 * Tests if the pawn works correctly
 */
public class TestPawn{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        
        
       
        
        Player p1=Player.getPlayer("white");
        Player p2=Player.getPlayer("black");        
        //System.out.println(p1.getKingRow()+"\n"+p1.getKingCol());
        
        Piece p=board.getPiece(1, 4);
       
        
        System.out.println(p.move(board, p, 1, 4, 3, 4));//true
                
        p=board.getPiece(4, 1);
        System.out.println(p.move(board, p, 4, 1, 4, 3));//true  
        
        p=board.getPiece(12, 4);
        
        System.out.println(p.move(board, p, 12, 4, 10, 4));//true  
        System.out.println(p.move(board, p, 12, 4, 11, 4));//true
        
                
        //System.out.println(p1.getKingRow()+"\n"+p1.getKingCol());  
        
        p=board.getPiece(1, 4);
        if(p.move(board, p, 1, 4, 3, 4)){
           p.doMove(board, p, 1, 4, 3, 4);
        }
           
           
        //System.out.println(p1.getKingRow()+"\n"+p1.getKingCol());
           
        p=board.getPiece(3, 4);
        System.out.println(p.move(board, p, 3, 4, 5, 4));//false
        
        board.setSquare(2, 6, new Pawn("blue"));
        p=board.getPiece(1, 5);
        System.out.println(p.move(board, p, 1, 5, 2, 6));//true
        System.out.println(p.move(board, p, 1, 5, 2, 4));//false
        
        board.setSquare(2, 6, new Pawn("white"));
        p=board.getPiece(1, 5);
        System.out.println(p.move(board, p, 1, 5, 2, 6));//false
        for (int x=0; x<board.getBoard().length; x++){
            for (int y=0; y<board.getBoard()[0].length; y++){
                if (board.getPiece(x, y)==null)
                    System.out.print("          ");
                else 
                    System.out.print(board.getPiece(x, y).toString()+"    ");
            }
            System.out.println();
        } 
        
       
        System.out.println("\n\n\n\n");
        board.setSquare(12, 4, new Pawn("white"));
        
        p=board.getPiece(12, 4);
        
        System.out.println(p.move(board, p, 12, 4, 13, 3));//true*******************
        p.doMove(board, p, 12, 4, 13, 3, new Bishop("white"));
        
        board.setSquare(1, 4, new Pawn("black"));
        p=board.getPiece(1, 4);
        System.out.println(p.move(board, p, 1, 4, 0, 3));//true //
        p.doMove(board, p, 1, 4, 0, 3);        
        
        
       /*
       
        board.setSquare(11, 8, new Pawn("blue"));
        Piece p=board.getPiece(11, 8);
        //board.setSquare(2, 4, new Pawn("black"));
        System.out.println(p.move(board, p, 11, 8, 12, 7));//true;
        
        for (int x=0; x<board.getBoard().length; x++){
            for (int y=0; y<board.getBoard()[0].length; y++){
                if (board.getPiece(x, y)==null)
                    System.out.print("          ");
                else 
                    System.out.print(board.getPiece(x, y).toString()+"    ");
            }
            System.out.println();
        }
        */
    }
}