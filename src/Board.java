public class Board
{
    private int rowAndCol;
    private int blockAmount;
    private int x,y;
    private String[][] board;


    //Constructor
    public Board(int rowAndCol)
    {
        this.rowAndCol = rowAndCol;
        this.blockAmount = rowAndCol*rowAndCol;
        this.board = new String[rowAndCol][rowAndCol];
    }

    //Instance methods
    public void newBoard()
    {
        for(int i = 0;i<rowAndCol;i++)
            for(int j = 0; j<rowAndCol;j++)
                board[i][j]=" ";

        this.blockAmount = rowAndCol*rowAndCol;
    }

    public void printBoard()
    {
        System.out.println();
        System.out.println("Enjoy your game,and good luck!");
        System.out.println();
        System.out.print("    ");
        for(int i=0;i<board.length;i++)
        {
            System.out.print(" Y:"+(i+1)+" ");
        }
        System.out.println();

        System.out.print("    ");
        for(int i=0;i<board.length;i++)
        {
            System.out.print(" ----");
        }
        System.out.println();

        for(int i=0;i<board.length;i++)
        {

            System.out.print("X:"+(i+1)+" ");
            for(int j=0;j<board.length;j++)
            {
                System.out.print("| "+board[i][j]+"  ");
            }
            System.out.println("|  ");
            System.out.print("    ");
            for(int k=0;k<board.length;k++)
            {
                System.out.print(" ----");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void getChess(Player p)
    {
        p.setCoordinateX();
        p.setCoordinateY();

        //System.out.println("Player's X and Y in getChess : "+p.getX()+" "+p.getY());

        while(!board[p.getX()][p.getY()].equals(" ") && !board[p.getX()][p.getY()].isEmpty())
        {
            //System.out.println("Player's X and Y in getChess inside while-loop : "+p.getX()+" "+p.getY());

            if(!p.isPlayerIsMachine())
            {
                System.out.println(p.getName()+", place your chose is taken, try again.");
            }else
            {
                System.out.println("Machine has chosen a taken place. And machine is trying again.");
            }
            p.setCoordinateX();
            p.setCoordinateY();
        }
        System.out.println("Name is "+p.getName()+"And input is "+p.getX()+" "+p.getY());
        board[p.getX()][p.getY()]=p.getChessLabel();
    }

    public String playerMove(Player p)
    {

        getChess(p);
        blockAmount--;
        printBoard();
        System.out.println("Block Amount on board"+blockAmount);
        System.out.println("Player's X and Y: "+p.getX()+" "+p.getY());
        if(!checkWinnerHorizontally(p).equals("")) {
            p.setPoint();
            return checkWinnerHorizontally(p);
        }
        if(!checkWinnerVertically(p).equals("")) {
            p.setPoint();
            return checkWinnerVertically(p);
        }
        if(!checkWinnerDiagonallySlash(p).equals("")) {
            p.setPoint();
            return checkWinnerDiagonallySlash(p);
        }
        if(!checkWinnerDiagonallyBackSlash(p).equals("")) {
            p.setPoint();
            return checkWinnerDiagonallyBackSlash(p);
        }
        return "";
    }

    public String checkWinnerHorizontally(Player p)
    {
        int i=0;
        while(i<rowAndCol)
        {
            int k=0;
            for (int j = 0; j < rowAndCol; j++)
            {
                if(!board[i][j].equals(p.getChessLabel()))
                {
                    break;
                }else
                {
                  k++;
                }
            }
            if(k==rowAndCol){
                return p.getName();
            }
            i++;
        }
        return "";
    }

    public String checkWinnerVertically(Player p)
    {
        int i=0;
        while(i<rowAndCol)
        {
            int k=0;
            for (int j = 0; j < rowAndCol; j++)
            {
                if(!board[j][i].equals(p.getChessLabel()))
                {
                    break;
                }else
                {
                    k++;
                }
            }
            if(k==rowAndCol){
                return p.getName();
            }
            i++;
        }
        return "";
    }

    public String checkWinnerDiagonallySlash(Player p)
    {
            int k=0;
            for (int i = 0; i < rowAndCol; i++)
            {
                if(!board[i][rowAndCol-i-1].equals(p.getChessLabel()))
                {
                    break;
                }else
                {
                    k++;
                }
            }
            if(k==rowAndCol){
                return p.getName();
            }else{
                return "";
            }
    }

    public String checkWinnerDiagonallyBackSlash(Player p)
    {
        int k=0;
        for (int i = 0; i < rowAndCol; i++)
        {
            if(!board[i][i].equals(p.getChessLabel()))
            {
                break;
            }else
            {
                k++;
            }
        }
        if(k==rowAndCol){
            return p.getName();
        }else{
            return "";
        }
    }

    public void setBlockAmount(int blockAmount) {
        this.blockAmount = blockAmount;
    }

    public int getBlockAmount() {
        return blockAmount;
    }
}
