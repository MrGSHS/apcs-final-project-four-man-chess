public class TestRotate{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        board.remove(1, 4);
        //Piece p=board.getPiece(1, 5);
        Board b=board.rotate(board, 1);
        int[] arr=board.rowCol(board, 1, 4, 1);
        
        //if (p.move(board, p, 0, 5, 1, 4)){
        //    p.doMove(board, p, 0, 5, 1, 4);
        //}
        
        for (int x=0; x<b.getRows(); x++){
            for (int y=0; y<b.getCols(); y++){
                if (b.getPiece(x, y)==null)
                    System.out.print("          ");
                else 
                    System.out.print(b.getPiece(x, y).toString()+"    ");
            }
            System.out.println();
        }
        System.out.println(arr[0]+"\n"+arr[1]);//4, 12
        
        
        int[] arr2=board.rowCol(board, 1, 4, 2);
        System.out.println(arr2[0]+"\n"+arr2[1]);//12, 9
        
        int[] arr3 =board.rowCol(board, 1, 4, 3);
        System.out.println(arr3[0]+"\n"+arr3[1]);//9, 1
    }
}