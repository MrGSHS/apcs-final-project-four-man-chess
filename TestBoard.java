public class TestBoard{
    public static void main (String[] args){
        Board board=new FourChessBoard();
        Piece[][] sets=board.getBoard();
        for (int x=0; x<sets.length; x++){
            for (int y=0; y<sets[0].length; y++){
                if (sets[x][y]==null) System.out.print("       ");
                else System.out.print(sets[x][y].toString()+"  ");
            }
            System.out.println("\n\n");
        }
        board.setSquare(1, 4, null);
        //System.out.println(board.getPiece(0, 5).move(board, this, 0, 5, 1, 4));
    }
}