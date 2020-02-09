import java.io.*;

public enum EncounterType implements Serializable
{
    BLOCKADE(" Blockade"), BATTLE(" Battle"), SKIRMISH (" Skirmish");
    private String type;

    EncounterType(String ty)
    {
        type = ty;
    }

    public String toString()
    {
        return type;
    }
}
