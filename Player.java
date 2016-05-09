import java.util.*;
public class Player{
    private String name, color;
    private List<String> moves=new ArrayList<String>();
    public Player(String name, String color){
        this.name=name;
        this.color=color;
    }
    public void add(String s){
        moves.add(s);
    }
    public String getString(int ind){
        return moves.get(ind);
    }
    public int getLength(){
        return moves.size();
    }
}