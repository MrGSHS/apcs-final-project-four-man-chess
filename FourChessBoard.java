public class FourChessBoard extends Board{
    PieceSet set=new PieceSet("white");
    Piece temp;
    public FourChessBoard(){
        super(14, 14);
        for (int x=0; x<2; x++){
            for (int y=0; y<8; y++){
                temp=set.getPiece(x, y);
                setSquare(x, y+3, set.getPiece(x, y));
                setSquare(y+3, x, set.getPiece(x, y));
                getBoard()[y+3][x].setColor("yellow"); 
                
                if (x==0){
                    setSquare(y+3, 13, set.getPiece(x, y));
                    getBoard()[y+3][13].setColor("blue"); 
                
                    setSquare(13, y+3, set.getPiece(x, y));
                    getBoard()[13][y+3].setColor("black");
                }
                else { 
                    setSquare(y+3, 12, set.getPiece(x, y));
                    getBoard()[y+3][12].setColor("blue"); 
                
                    setSquare(12, y+3, set.getPiece(x, y));
                    getBoard()[12][y+3].setColor("black");
                }
            }
        }
    }
    Player white=new Player("1", "white");
    Player yellow=new Player("2", "yellow");
    Player black=new Player("3", "black");
    Player blue=new Player("4", "blue");
}