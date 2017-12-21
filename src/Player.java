import jdk.nashorn.internal.runtime.ECMAException;

import java.util.Scanner;

public abstract class Player {

    private String name;
    private String chessLabel;
    private int range;
    private int point;
    private int x,y;
    private boolean playerIsMachine;

    //Constructor
    public Player()
    {

    }

    public Player(int range)
    {
        this.range = range;
    }

    public Player(int range,boolean playerIsMachine)
    {
        this.range = range;
        this.playerIsMachine = true;
    }

    //Instance methods
    public abstract void setCoordinateX();

    public abstract void setCoordinateY();

    public boolean isPlayerIsMachine() {
        return playerIsMachine;
    }

    public void setPlayerIsMachine() {
        this.playerIsMachine = true;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName()
    {
        Scanner scanner = new Scanner(System.in);
        this.name=inputString(scanner);
    }

    public void setChessLabel()
    {
        Scanner scanner = new Scanner(System.in);
        this.chessLabel=inputString(scanner);
    }

    public String getName()
    {
        return name;
    }

    public void setPoint()
    {
        this.point++;
    }

    public int getPoint()
    {
        return point;
    }

    public String getChessLabel() {
        return chessLabel;
    }

    public int getRange()
    {
        return range;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private String inputString(Scanner sc)
    {
        while(true) {
            try {
                String str = sc.next();
                if (str==null||str.equals(""))
                {
                    throw new Exception();
                } else {
                    return str;
                }
            } catch (Exception e) {
                System.out.println("You can not input anything here.");
            }
        }
    }

    public  int inputRangedNumber(Scanner sc)
    {
        while(true)
        {
            try
            {
                String str = sc.nextLine();
                int a = Integer.parseInt(str);
                if(a >=1 && a <= range)
                {
                    return a;
                }
                else
                {
                    throw new Exception();
                }
            }catch (Exception e2)
            {
                System.out.println("Input a number between 1 and row amount, please.");
            }
        }
    }
}
