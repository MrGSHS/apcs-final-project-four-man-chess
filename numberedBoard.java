public class numberedBoard{
    public static void main(String[] args){
        Board board=new FourChessBoard();
        String color;
        System.out.println("        0         1         2         3         "
        +"4         5         6         7"
        +"         8         9         10        11        12        13        \n");
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
    }
}