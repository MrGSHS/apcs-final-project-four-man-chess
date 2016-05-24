import java.util.*;
public class Player{
    //private int kingRow, kingCol;
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

    //public void remove(Piece p){
    //    for (int x=0; x<pieces.size(); x++){
    //        if (pieces.get(x)==p)
    //            pieces.remove(p);
    //    }
    //}
    /*
    public void addPiece(int row, int col, Piece p){
    pieces.add(p);
    if (p.toString().equals("King  ")){
    kingRow=row;
    kingCol=col;
    }
    }
     */
    /*

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
     */

    public int getPlayerNum(){
        return playerNum;
    }

    public static int getNumPlayers(){
        return players.size();
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
        if (players.size()<=num || num<0)
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

    public static Player getNextPlayer(Player thePlayer){
        if (players.get(players.size()-1).getColor().equals(thePlayer.getColor())){
            return players.get(0);
        }
        //if (thePlayer.playerNum==playerNumber-1){
        //    return players.get(0);
        //}
        return players.get(thePlayer.playerNum+1);
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
    /*
    public boolean isInCheck(Board board, Piece p, int fromRow, int fromCol, 
    int row, int col){
        Piece king=null;
        Piece p5;
        int kingRow=0, kingCol=0;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                p5=board.getPiece(x, y);
                if (p5!=null && p5.toString().equals("King  ") && 
                p5.getColor().equals(color)){
                    king=(King)p5;
                    kingRow=x;
                    kingCol=y;
                }
            }
        }
        
        Board b=new Board(board.getRows(), board.getCols(), board.getTwoPlayers());
        for (int x=0; x<b.getRows(); x++){
            for (int y=0; y<b.getCols(); y++){
                b.setSquare(x, y, board.getPiece(x, y));
            }
        }
        Piece piece=board.getPiece(row, col);
        p=board.getPiece(fromRow, fromCol);
        board.setSquare(fromRow, fromCol, null);
        board.setSquare(row, col, null);

        Piece temp;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                temp=board.getPiece(x, y);
                if ( temp==null || p==null || temp.getColor().equals(p.getColor())){}
                else if (temp.move(board, temp, x, y, kingRow, kingCol)){
                    board.setSquare(row, col, piece);
                    board.setSquare(fromRow, fromCol, p);
                    return true;
                }
            }
        }
        board.setSquare(row, col, piece);
        board.setSquare(fromRow, fromCol, p);
        return false;
    }
    */
    
    public boolean isCheckmate(Board b){

        //Piece piece=b.getPiece(kingRow, kingCol);
        //if (piece==null || !piece.toString().equals("King  "))
        //    return true;

        
        //King king=(King)(b.getPiece(kingRow, kingCol));

        Piece king=null;
        Piece p5;
        int kingRow=0, kingCol=0;
        for (int x=0; x<b.getRows(); x++){
            for (int y=0; y<b.getCols(); y++){
                p5=b.getPiece(x, y);
                if (p5!=null && p5.toString().equals("King  ") && 
                p5.getColor().equals(color)){
                    king=(King)p5;
                    kingRow=x;
                    kingCol=y;
                }
            }
        }

        if (king==null){
            remove(b);
            return true;
        }
        if (!king.isInCheck(b, king, kingRow, kingCol, kingRow, kingCol)){
            return false;
        }
        //Player player=Player.getPlayer(king.getColor());
        //if(!king.isInCheck(b))
        //    return false;
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
                        for (int col=0; col<b.getCols(); col++){
                            if (p.move(b, p, x, y, row, col)){
                                board=p.doMove(b, p, x, y, row, col, 1);

                                if (!king.isInCheck(board, king, kingRow, kingCol, 
                                    kingRow, kingCol))
                                    return false;
                            }
                        }
                    }
                }
            }
        }
        //int[] a=b.rowCol(b, kingRow, kingCol, 1);
        //kingRow=a[0];
        //kingCol=a[1];
        //rotates kingLoc 3 times

        remove(b);

        return true;
    }
    /*
    public Board takeBack(Board board, Piece p, int fromRow, int fromCol, int toRow, int toCol){
    moves.remove(moves.size()-1);

    }*/
    /*
    public boolean isInCheck(Board board){
    King king=(King)(board.getPiece(kingRow, kingCol));
    return king.isInCheck(board, king, kingRow, kingCol);
    }
     */
    public void remove(Board board){
        Piece piece;
        Player player;
        int ind=0;
        for (int x=0; x<board.getRows(); x++){
            for (int y=0; y<board.getCols(); y++){
                piece=board.getPiece(x, y);
                if (piece!=null && piece.getColor().equals(color)){
                    board.setSquare(x, y, null);
                }
            }
        }
        for (int x=0; x<players.size(); x++){
            if (players.get(x).getColor().equals(color)){
                players.remove(x);
            }
        }
        playerNumber--;
    }
}