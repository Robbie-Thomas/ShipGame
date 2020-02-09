import java.io.*;
import java.util.Scanner;


public class EncounterSetup implements Serializable
{
    private int encNo = 0;
    private String encounterType;
    private String battleSkill;
    private String plunder;
    private char exit = 'y';

    private String toFile;
    private File outFile = new File("encounters.txt");

    /**
     * Takes the encounter as input from the user
     */
    public void runSetup()
    {
        Scanner in = new Scanner(System.in);

        while (exit == 'y')
        {
            toFile = "";

            System.out.println("Enter Encounter Type: ");
            encounterType = in.next();

            System.out.println("Enter Battle Skill: ");
            battleSkill = (in.next());

            System.out.println("Enter Plunder: ");
            plunder = in.next();

            encNo++;

            System.out.println("Press n to exit or y to continue: ");
            exit = in.next().charAt(0);

            toFile += encNo +","+ encounterType +","+ battleSkill +","+
                    plunder +"\n";
            writeToFile(toFile);
        }
    }

    /**
     * Writes the encounter to a file
     * @param toFile
     */
    public void writeToFile(String toFile)
    {
        try
        {
            FileOutputStream outs = new FileOutputStream(outFile, true);
            PrintStream writer = new PrintStream(outs);

            writer.append(toFile);

        }
        catch (IOException e)
        {
            System.err.println("Invalid Input");
        }
    }

    public static void main(String args[])throws Exception
    {
        EncounterSetup setup = new EncounterSetup();
        setup.runSetup();
    }
}
