import java.util.Scanner;

public class GameIO
{
    private WAM game;
    private Scanner in = new Scanner(System.in);

    /**
     * Runs the IO
     */
    public void runIO()
    {
        System.out.println("Enter your name: ");
        String name = in.nextLine();

        game = new Admiral(name);
        //game = new Admiral(name, "reserves.txt");
        int ch;
        int encNo;
        String fName;

        while (true)
        {
            System.out.println("\n0.\tQuit\n"
                    + "1.\tList ships in reserve\n"
                    + "2.\tList ships in the Admiral’s fleet\n"
                    + "3.\tView a ship\n"
                    + "4.\tCommission a ship into the Admiral’s fleet\n"
                    + "5.\tFight an encounter\n"
                    + "6.\tRecommission a ship\n"
                    + "7.\tDecommission a ship\n"
                    + "8.\tView the game’s state\n"
                    + "9.\tSave this game\n"
                    + "10.\tLoad a game\n");

            System.out.println("Enter your option: ");
            ch = in.nextInt();
            in.nextLine();

            if(ch == 0)
                break;

            switch (ch)
            {

                case 1:
                    System.out.println(game.getReserves());
                    break;

                case 2:
                    System.out.println(game.getFleet());
                    break;

                case 3:
                    System.out.println("Enter the Ship's Name: ");
                    name = in.nextLine();
                    System.out.println(game.getShip(name));
                    break;
                case 4:
                    System.out.println("Enter the Ship's Name: ");
                    name = in.nextLine();
                    System.out.println(game.commissionShip(name));
                    break;

                case 5:
                    System.out.println("Enter Encounter number: ");
                    encNo = in.nextInt();
                    System.out.println(game.fightEncounter(encNo));
                    break;

                case 6:
                    System.out.println("Enter the Ship's Name: ");
                    name = in.nextLine();
                    game.recommissionShip(name);
                    break;

                case 7:
                    System.out.println("Enter the Ship's Name: ");
                    name = in.nextLine();
                    game.decommissionShip(name);
                    break;

                case 8:
                    System.out.println(game.toString());
                    break;

                case 9:

                    System.out.println("Enter File name");
                    fName = in.nextLine();

                    game.saveGame(fName);
                    break;
                case 10:
                    System.out.println("Enter File name");
                    fName = in.nextLine();

                    game = game.loadGame(fName);
                    break;

                default:
                    System.out.println("Option does not exist");
            }
        }
        System.out.println("Thank you for Playing!");
    }

    public static void main(String args[])throws Exception
    {
        GameIO IO = new GameIO();
        IO.runIO();
    }
}
