public class FourChessBoard extends Board{
    private PieceSet set1=new PieceSet("white");
    private PieceSet set2=new PieceSet("yellow");
    private PieceSet set3=new PieceSet("black");
    private PieceSet set4=new PieceSet("blue");  
    public FourChessBoard(){
        super(14, 14, false);
        Player pA=new Player("p1", "white", 1, 0);
        Player pB=new Player("p2", "yellow", 0, 1);
        Player pC=new Player("p3", "black", -1, 0);
        Player pD=new Player("p4", "blue", 0, -1);
        
        Piece pa;
        Piece pb;
        Piece pc;
        Piece pd;
        for (int x=0; x<2; x++){
            for (int y=0; y<8; y++){
                pa=set1.getPiece(x, y);
                pb=set2.getPiece(x, y);
                pc=set3.getPiece(x, y);
                pd=set4.getPiece(x, y);
                
                super.setSquare(x, y+3, pa);
                //pA.addPiece(x, y+3, pa);
                super.setSquare(y+3, x, pb);
                //pB.addPiece(y+3, x, pb);
                
                if (x==0){
                    super.setSquare(13, y+3, pc);
                    //pC.addPiece(13, y+3, pc);
                    super.setSquare(y+3, 13, pd);
                    //pD.addPiece(y+3, 13, pd);
                }
                else { 
                    super.setSquare(12, y+3, pc);
                    //pC.addPiece(12, y+3, pc);
                    super.setSquare(y+3, 12, pd);
                    //pD.addPiece(y+3, 12, pd);
                }
            }
        }
        Player.getPlayer("white").setKingRow(0);
        Player.getPlayer("white").setKingCol(7);
        
        Player.getPlayer("yellow").setKingRow(7);
        Player.getPlayer("yellow").setKingRow(0);
        
        Player.getPlayer("black").setKingRow(13);
        Player.getPlayer("black").setKingRow(7);
        
        Player.getPlayer("blue").setKingRow(7);
        Player.getPlayer("blue").setKingRow(13);
    }
}