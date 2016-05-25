import java.util.*;
/**
 * non-GUI game, runs the four man chess game played according to the rules until
 * there is one player remaining, the winner
 */
public class FourChessGame{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String theMove;
        int[] move=new int[4];
        //rotate players
        String lost="";
        String c;
        Player temp;
        Board board=new FourChessBoard();
        String color;
        //int turn=0;
        int numPlayers=Player.getNumPlayers();
        Player turn=Player.getPlayer(0);
        while(numPlayers>1){
            c=turn.getColor();
            System.out.println("        0         1         2         3         "
            +"4         5         6         7"
            +"         8         9         10        11        12        "
            +"13        \n");
            for (int x=0; x<board.getRows(); x++){
                for (int y=0; y<board.getCols(); y++){
                    Piece p=board.getPiece(x, y);
                    if (y==0){
                        if (x<10)
                            System.out.print(x+"       ");
                        else 
                            System.out.print(x+"      ");
                    }
                    if (p!=null){
                        color=p.getColor();
                        if (color.equals("white"))
                            System.out.print("wh");
                        else if (color.equals("yellow"))
                            System.out.print("yw");
                        else if (color.equals("black"))
                            System.out.print("bk");
                        else if (color.equals("blue"))
                            System.out.print("bu");
                        System.out.print(p.toString()+"  ");
                    }
                    else 
                        System.out.print("          ");
                }
                System.out.println("\n\n");
            }
            System.out.print(turn.getName()+": Your move(from row,from column,"
            +"to row,to column,): ");
            theMove=sc.next();
            move=numbers(theMove);
            
            System.out.println(theMove);
            for (int x=0; x<move.length; x++){
                System.out.println(move[x]);
            }
            
            Piece p=board.getPiece(move[0], move[1]);
            while(p==null || !p.getColor().equals(turn.getColor())
            ||!p.move(board, p, move[0], move[1], move[2], move[3])){
                System.out.println("Invalid move.  New move(from row,"
                +"from column,to row,to column): ");
                theMove=sc.next();
                move=numbers(theMove);
                p=board.getPiece(move[0], move[1]);
            }
            if (p.promote(board, p, move[0], move[1], move[2], move[3])){
                System.out.print("which piece?(rook, knight, bishop, or queen? ");            
                /*
                Piece newPiece=sc.next();
                if while (! piece)
                    ask again
                p.doMove(board, p, move[0], move[1], move[2], move[3], newPiece));
                */
            }
            //else{
            p.doMove(board, p, move[0], move[1], move[2], move[3]);
            //}
            
            
            turn=Player.getNextPlayer(turn);
            lost="Player "+turn.getName()+" loses.";
            System.out.println("\n\n\n");
            if (turn.isCheckmate(board)){
                System.out.println(lost);
                turn=Player.getPlayer(c);
                turn=turn.getNextPlayer(turn);
                
            }
            numPlayers=Player.getNumPlayers();
            
        }
        System.out.println("\n\n\nPlayer "+Player.getPlayer(0).getName()+" wins!");
    }
    
    public static int[] numbers(String str){
        int[] nums=new int[4];
        int count=0;
        int ind=0;
        for (int x=0; x<str.length(); x++){
            if (Character.isDigit(str.charAt(x))){
                count++;
            }
            if (!(Character.isDigit(str.charAt(x)))){
                if (count>0){
                    nums[ind]=Integer.parseInt(str.substring(x-count, x));
                    ind++;
                }
                count=0;
            }
        }
        return nums;
    }
    //if promote, prompt "which piece(rook, knight, bishop, or queen?): "
}