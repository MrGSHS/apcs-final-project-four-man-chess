public class Pawn extends Piece{
    int dirRow;
    int dirCol;
    public Pawn(String c){
        super(c);
    }
    public boolean capture(){
        return false;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        boolean a=super.move(board, p, fromRow, fromCol, toRow, toCol);
        if (!a) return false;
        
        
        Board b=new FourChessBoard();
        int[] newVal=new int[2];
        int[] newValues=new int[2];        
        Player player=Player.getPlayer(p.getColor());
        int dirRow=player.getDirRow();
        int dirCol=player.getDirCol(); 
        int moved=player.hasMovedTo(fromRow, fromCol);
        
        if (dirRow>0){
            b=rotate(board, 2);
            newVal=rowCol(board, fromRow, fromCol, 2);
            newValues=rowCol(board, toRow, toCol, 2);        
        }
        else if (dirRow<0){
            b=rotate(board, 0);
            newVal=rowCol(board, fromRow, fromCol, 0);
            newValues=rowCol(board, toRow, toCol, 0); 
        }
        else if (dirCol>0){
            b=rotate(board, 3);
            newVal=rowCol(board, fromRow, fromCol, 3);
            newValues=rowCol(board, toRow, toCol, 3);
        }
        else if (dirCol<0){ 
            b=rotate(board, 3);
            newVal=rowCol(board, fromRow, fromCol, 1);
            newValues=rowCol(board, toRow, toCol, 1);
        }
        fromRow=newVal[0];
        fromCol=newVal[1];
        toRow=newValues[0];
        toCol=newValues[1];
        
        Piece piece=b.getPiece(fromRow-1, toCol);
        Piece temp=b.getPiece(toRow, toCol);
        if (moved<0 && toCol-fromCol==0 && toRow-fromRow==-2 && piece==null
        && b.getPiece(toRow, toCol)==null
        || toRow-fromRow==-1 && (toCol-fromCol==0 && piece==null
        || Math.abs(toCol-fromCol)==1 && temp!=null)
        && !temp.getColor().equals(p.getColor()))
            return true;
        
        /*
        Player thePlayer=null;
        if (temp!=null)
            thePlayer=Player.getPlayer(temp.getColor());
        
        
        //en pessan
        if (toRow-fromRow==-1 && Math.abs(toCol-fromCol)==1 && thePlayer!=null 
        && temp.toString().equals("Pawn  ")
        && Player.getPreviousPlayer(thePlayer.getColor()).
        getMove(thePlayer.getLength()-1)==newValues)
        {
            return true;
        }
        */
        
       
        
        return false;
    }
    
    private Board rotate(Board board, int numClockwise){
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
    
    private int[] rowCol(Board board, int row, int col, int rotations){
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
    
    public void doMove(){
        // if promote
    }
    public String toString(){
        return "Pawn  ";
    }
}