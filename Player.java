import java.util.*;
public class Player{
    private int dirRow, dirCol;
    private String name, color;
    private static List<Player> players=new ArrayList<Player>();
    private List<int[]> moves=new ArrayList<int[]>();
    private static int playerNumber=0;
    private int playerNum;
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
        return false;
    }
}