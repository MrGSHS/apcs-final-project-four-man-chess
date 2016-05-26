/**
 * creates an empty board to hold pieces
 */
public class Board{
    private int numRows;
    private int numCols;
    private Piece[][] board;
    private Player p1, p2, p3, p4;
    private boolean twoPlayers;
    public Board(int numRows, int numCols, boolean twoPlayers){
        this.numRows=numRows;
        this.numCols=numCols; 
        this.twoPlayers=twoPlayers;
        if (twoPlayers){
            p1=new Player("1", "white", 1, 0);
            p2=new Player("2", "black", -1, 0);
        }
        else{
            //p1=new Player("1", "white", 1, 0);
            //p2=new Player("2", "yellow", 0, 1);
            //p3=new Player("3", "black", -1, 0);
            //p4=new Player("4", "blue", 0, -1);            
        }
        board=new Piece[numRows][numCols];
    }
    
    public Piece getPiece(int row, int col){
        return board[row][col];
    }
    public Piece[][] getBoard(){
        return board;
    }
    public void setSquare(int row, int col, Piece p){
        //Piece piece =getPiece(row, col);
        //Player player;
        
        // if (piece!=null){
        //    player=Player.getPlayer(piece.getColor());            
            //player.remove(piece);
       // }
        
        //if (p!=null && p.toString().equals("King  ")){
            //Player.getPlayer(p.getColor()).setKingLoc(row, col);
            
            //if (p!=null)
            //    Player.getPlayer(p.getColor()).addPiece(row, col, getPiece(row, col));
        //}
        
        board[row][col]=p;
    }
    public void setSquare(Board b, int row, int col, Piece p){
        b.setSquare(row, col, p);
    }
    
    public Piece remove(int row, int col){
        Piece p=board[row][col];
        board[row][col]=null;
        return p;
    }
    public int getRows(){
        return numRows;
    }
    public int getCols(){
        return numCols;
    }
    public boolean getTwoPlayers(){
        return twoPlayers;
    }
    
    
    /**
     * rotates board 90 degrees
     */
    public Board rotate(Board board, int numClockwise){
        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        Board temp=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        int rotations=0;
        //Piece temp;
        
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                b.setSquare(x, y, board.getPiece(x, y));
            }
        }        
        
        while(rotations<numClockwise){
            //temp=new FourChessBoard();
            
            for (int x=0; x<temp.getRows(); x++){
                for (int y=0; y<temp.getCols(); y++){
                    temp.setSquare(x, y, b.getPiece(x, y));
                }
            }   
            
            for (int x=0; x<b.getRows(); x++){
                for (int y=0; y<b.getCols(); y++){
                    b.setSquare(x, y, temp.getPiece(board.getCols()-1-y, x));
                }
            }         
            rotations++;
        }
        return b;
    }
    
    /**
     * returns a location on the board after the board rotates 90 degrees
     */
    public int[] rowCol(Board board, int row, int col, int rotations){
        int[] ret=new int[2];
        int x=0; 
        while (x<rotations){
            int temp=row;
            row=col;
            col=board.getRows()-1-temp;
            x++;
        }
        ret[0]=row;
        ret[1]=col;
        return ret;
    }  
    
    
    
}