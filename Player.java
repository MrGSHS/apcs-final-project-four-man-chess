import java.util.*;
public class Player{
    private int kingRow, kingCol;
    private int dirRow, dirCol;
    private String name, color;
    private static List<Player> players=new ArrayList<Player>();
    private List<int[]> moves=new ArrayList<int[]>();
    private static int playerNumber=0;
    private int playerNum;
    private List<Piece> pieces=new ArrayList<Piece>();
    public Player(String name, String color, int dirRow, int dirCol){
        this.dirRow=dirRow;
        this.dirCol=dirCol;
        this.name=name;
        this.color=color;
        playerNum=playerNumber;
        players.add(playerNumber, this);
        playerNumber++;
    }
    public void addMove(int fromRow, int fromCol, int toRow, int toCol){
        int[] temp=new int[4];
        temp[0]=fromRow;
        temp[1]=fromCol;
        temp[2]=toRow;
        temp[3]=toCol;
        moves.add(temp);
    }
    
    public void remove(Piece p){
        for (int x=0; x<pieces.size(); x++){
            if (pieces.get(x)==p)
                pieces.remove(p);
        }
    }
    public void addPiece(int row, int col, Piece p){
        pieces.add(p);
        if (p.toString().equals("King  ")){
            kingRow=row;
            kingCol=col;
        }
    }
    
    public static int getNumPlayers(){
        return playerNumber;
    }
    public void setKingLoc(int row, int col){
        kingRow=row;
        kingCol=col;
    }
    public void setKingRow(int row){
        kingRow=row;
    }    
    public void setKingCol(int col){
        kingCol=col;
    }
    public int getKingCol(){
        return kingCol;
    }
    public int getKingRow(){
        return kingRow;
    }
    
    public int[] getMove(int ind){
        int[] temp=new int[4];
        if (ind<0 || ind>=moves.size())
            return null;
        for (int x=0; x<4; x++){
            temp[x]=moves.get(ind)[x];
        }
        return temp;
    }
    public int getLength(){
        return moves.size();
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public int getDirRow(){
        return dirRow;
    }
    public int getDirCol(){
        return dirCol;
    }
    public boolean move(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        if (p.getColor()!=color)
            return false;
        return p.move(board, p, fromRow, fromCol, toRow, toCol);
        //return false;
    }
    
    public static Player getPlayer(int num){
        if (playerNumber<num || num<0)
            return null;
        else
            return players.get(num);
    }
    public static Player getPlayer(String color){
        for (int x=0; x<players.size(); x++){
            if (players.get(x).getColor().equals(color))
                return players.get(x);
        }
        return null;
    }
    
    public static Player getPreviousPlayer(String color){
        int num=getPlayer(color).playerNumber;
        if (num==0)
            return players.get(players.size()-1);
        return players.get(num-1);
    }
    public static Player getPreviousPlayer(Player player){
        int num=player.playerNumber;
        if (num==0)
            return players.get(players.size()-1);
        return players.get(num-1);
    }
    
    public static Player getPreviousPlayer(int number){
        int num=getPlayer(number).playerNumber;
        if (num==0)
            return players.get(players.size()-1);
        return players.get(num);
    }    
    
    public int hasMovedTo(int row, int col){
        for (int x=0; x<moves.size(); x++){
            if (moves.get(x)[2]==row && moves.get(x)[3]==col)
                return x;
        }
        return -1;
    }
    
    public String toString(){
        return "Player "+playerNum;
    }
    
    public boolean isCheckmate(Board b){
        Piece piece=b.getPiece(kingRow, kingCol);
        //if (piece==null || !piece.toString().equals("King  "))
        //    return true;
        
        King king=(King)(b.getPiece(kingRow, kingCol));
        Player player=Player.getPlayer(king.getColor());
        if(!player.isInCheck(b))
            return false;
        //check all same color pieces
            //check all possible moves and if (!is in check after the move)   //
                //return false
        //return true;
        
        Piece p;
        Board board;
        
        for (int x=0; x<b.getRows(); x++){
            for (int y=0; y<b.getCols(); y++){
                p=b.getPiece(x, y);
                if (p!=null && p.getColor().equals(king.getColor())){
                    for (int row=0; row<b.getRows(); row++){
                        //or make List<int[]> getMoves Piece method
                        for (int col=0; col<b.getCols(); col++){
                           
                             if (p.move(b, p, x, y, row, col)){
                                 board=p.doMove(b, p, x, y, row, col, 1);
                                 if (!king.isInCheck(board, king, kingRow, kingCol))
                                     return false;
                             }
                        }
                    }
                }
            }
        }
        
        return true;
    }
    /*
    public Board takeBack(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
        moves.remove(moves.size()-1);
        
    }*/
    public boolean isInCheck(Board board){
        King king=(King)(board.getPiece(kingRow, kingCol));
        return king.isInCheck(board, king, kingRow, kingCol);
    }
}