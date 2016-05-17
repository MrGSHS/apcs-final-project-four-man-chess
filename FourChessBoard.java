public class FourChessBoard extends Board{
    private PieceSet set1=new PieceSet("white");
    private PieceSet set2=new PieceSet("yellow");
    private PieceSet set3=new PieceSet("black");
    private PieceSet set4=new PieceSet("blue");  
    public FourChessBoard(){
        super(14, 14, false);
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
                super.setSquare(y+3, x, pb);
                
                if (x==0){
                    setSquare(13, y+3, pc);
                    setSquare(y+3, 13, pd);
                }
                else { 
                    setSquare(12, y+3, pc);
                    setSquare(y+3, 12, pd);
                }
            }
        }
    }
}