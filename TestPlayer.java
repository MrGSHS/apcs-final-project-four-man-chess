public class TestPlayer{
    public static void main(String[] args){
        Board b=new FourChessBoard();
        //System.out.println(Player.getPlayer(2).getColor());//"black"
        //System.out.println(Player.getPlayer("yellow").getName());//2
        System.out.println(Player.getPlayer("white").getKingRow());
        System.out.println(Player.getPlayer("white").getKingCol());
    }
}