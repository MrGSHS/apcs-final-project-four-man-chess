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
            p1=new Player("1", "white", 1, 0);
            p2=new Player("2", "yellow", 0, 1);
            p3=new Player("3", "black", -1, 0);
            p4=new Player("4", "blue", 0, -1);            
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
        board[row][col]=p;
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
    
    
    
    public Board rotate(Board board, int numClockwise){
        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        
        int rotations=0;
        //Piece temp;
        while(rotations<numClockwise){
            for (int x=0; x<b.getRows(); x++){
                for (int y=0; y<b.getCols(); y++){
                    b.setSquare(x, y, board.getPiece(board.getCols()-1-y, x));
                }
            }
            rotations++;
        }
        return b;
    }
    
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