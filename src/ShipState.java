import java.io.*;
public enum ShipState implements Serializable
{
    RESERVE(" In Reserves"), ACTIVE(" Active"), RESTING(" Resting"), SUNK (" "
        + "Sunk/Lost");
    private String state;

    private ShipState(String st)
    {
        state = st;
    }

    public String toString()
    {
        return state;
    }
}
