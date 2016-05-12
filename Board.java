public class Board{
    
    private Piece[][] board;
    public Board(int numRows, int numCols){
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
        return board.length;
    }
    public int getCols(){
        return board[0].length;
    }
}