import java.util.Scanner;

public class Game {

    public static void main(String[] args)
    {
        int rowAndCol;
        String winner = "";
        int blockAmount;

        //Create a game board
        rowAndCol = rowAmount();
        blockAmount = rowAndCol*rowAndCol;
        Board board = new Board(rowAndCol);

        //Create players
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();
        gamePattern();
        System.out.println("Decide your game pattern please?(0-3)");
        Scanner scanner = new Scanner(System.in);
        int choice=inputGameChoice(scanner);
        switch (choice)
        {
            case 1:
                player1 = new HumanPlayer(rowAndCol);
                player2 = new MachinePlayer(rowAndCol,true);
                player2.setPlayerIsMachine();
                break;
            case 2:
                player1 = new HumanPlayer(rowAndCol);
                player2 = new HumanPlayer(rowAndCol);
                break;
            case 3:
                player1 = new MachinePlayer(rowAndCol,true);
                player2 = new MachinePlayer(rowAndCol,true);
                break;
            case 0:
                System.exit(0);
        }

        //Set name and chess label to the players
        configurePlayer(player1);
        configurePlayer(player2);

        while(winner.equals(""))
        {
            //Print new game board
            board.newBoard();
            board.printBoard();
            while(blockAmount!=0)
            {
                /*
                *  System.out.println("BlockAmount is "+blockAmount);
                winner = board.playerMove(player1);
                System.out.println("Winner at player1' round is "+winner);
                board.printBoard();
                if (winner.equals(player1.getName()))
                {
                    gameResult(player1, player2, winner, blockAmount);
                break;
                }
                blockAmount--;
                if(blockAmount==0)
                {
                    gameResult(player1, player2, winner, blockAmount);
                    break;
                }

                winner = board.playerMove(player2);
                System.out.println("Winner at player2' round is "+winner);
                board.printBoard();
                if (winner.equals(player2.getName()))
                {
                    gameResult(player1, player2, winner, blockAmount);
                    break;
                }
                blockAmount--;
                if(blockAmount==0)
                {
                    gameResult(player1, player2, winner, blockAmount);
                    break;
                }
                */
                checkPlayer(player1,player2,winner,blockAmount,board,rowAndCol);
                checkPlayer(player2,player1,winner,blockAmount,board,rowAndCol);
            }
            winner = "";
            blockAmount=rowAndCol*rowAndCol;
        }


    }
    private static void checkPlayer(Player player,Player otherPlayer,String winner, int blockAmount,Board board,int rowAndCol)
    { winner = board.playerMove(player);
        System.out.println("Winner at player2' round is "+winner);
        board.printBoard();
        if (winner.equals(player.getName()))
        {
            gameResult(player,otherPlayer, winner, blockAmount);
            restartGame(player, otherPlayer);
        }
        blockAmount--;
        if(blockAmount==0)
        {
            gameResult(player, otherPlayer, winner, blockAmount);
            restartGame(player, otherPlayer);
        }

    }

    private static void restartGame(Player player,Player otherPlayer)
    {
        System.out.println("Game continues?(Y/N");
        Scanner scanner = new Scanner(System.in);
        if(scanner.next().toLowerCase().equals("n"))
        {
            System.out.println("Game is over!"+"\n"+
                    player.getName()+" won "+ player.getPoint()+" times."+"\n"+
                    otherPlayer.getName()+" won "+ otherPlayer.getPoint()+" times."+"\n");
            System.exit(0);
        }
    }

    private static void configurePlayer(Player player){
        player.setName();
        player.setChessLabel();
    }

    private static void gameResult(Player player1,Player player2 ,String winner,int blockAmount)
    {
        if(!winner.equals(""))
        {
            System.out.println("Winner is "+ winner +"\n"+
            player1.getName()+" wins "+ player1.getPoint()+" times."+"\n"+
            player2.getName()+" wins "+ player2.getPoint()+" times."+"\n");
        }else if(blockAmount==0)
        {
            System.out.println("No winner this round"+"\n"+
                    player1.getName()+" wins "+ player1.getPoint()+" times."+"\n"+
                    player2.getName()+" wins "+ player2.getPoint()+" times."+"\n");
        }
    }

    private static void gameRestart(String winner,int blockAmount)
    {

    }


    private static void gamePattern()
    {
        System.out.println("Choose your game pattern as follow:");
        System.out.println("Input 1 to play with a machine.");
        System.out.println("Input 2 to play with your friend.");
        System.out.println("Input 3 to see two machines play with each other.");
        System.out.println("Input 0 to quit the game.");
    }

    private static int inputGameChoice(Scanner sc)
    {
        while(true)
        {
            try {
                String str = sc.nextLine();
                int value = Integer.parseInt(str);
                if (value >= 0 && value <= 3) {
                    return value;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Input a number as required, please.");
            }
        }
    }

    private static int rowAmount()
    {
        System.out.println("How many rows do you want to have on the board?(A number >= 3)");
        Scanner scanner = new Scanner(System.in);
        return inputRowAndCol(scanner);

    }

    private static int inputRowAndCol(Scanner sc)
    {
        while(true)
        {
            try
            {
                String str = sc.nextLine();
                int value = Integer.parseInt(str);
                if(value >=3)
                {
                    return value;
                }else {
                    throw new Exception();
                }
            } catch (Exception e)
            {
                System.out.println("Input a number which is bigger or equals 3.");
            }
        }

    }

}
