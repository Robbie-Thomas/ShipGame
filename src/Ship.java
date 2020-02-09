public abstract class Ship
{
    /**
     * creates the fields for sjip
     */
    private String name;
    private String captain;
    private String shipType;

    public ShipState state;

    /**
     * creates a ship object
     * @param typ Ship type
     * @param nam Ship name
     * @param cap Ship captain
     */
    public Ship(String typ, String nam, String cap )
    {
        name = nam;
        captain = cap;
        shipType = typ;
        state = ShipState.RESERVE;

    }

    /**
     * Returns the ships name
     * @return string representation of the ships name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the captains name
     * @return string representation of the captains name
     */
    public String getCaptain()
    {
        return captain;
    }

    /**
     * returns the battle skill
     * @return an int representation of the battle skill
     */
    public abstract int getBattleSkill();

    /**
     * returns if the ship can fight a encounter tpye
     * @param type encounter type
     * @return true if it can fight the encounter type
     */
    public abstract boolean canEncounter(EncounterType type);

    /**
     * sets the ship state
     * @param ste ship state
     */
    public void setState(ShipState ste)
    {
        state = ste;
    }

    /**
     * returns the shipstate
     * @return the ship state
     */
    public ShipState getState()
    {
        return state;
    }

    /**
     * returns the state as a string
     * @return a string representation as a string
     */
    public String getStateName()
    {
        return state.toString();
    }

    /**
     * returns the commissioning fee
     * @return a int representation of the commissioning fee
     */
    public abstract int getCommFee();

    /**
     * returns the ship type
     * @return a string representation of a shipType
     */
    public String getShipType()
    {
        return shipType;
    }

    /**
     * returns the ship
     * @return a string representation of the ship object
     */
    public String toString()
    {
        return "\nName: " + name + "\nCaptain: " + captain + "\nShip Type: "
                + getShipType() + "\nState: " + getStateName()  +"\n";
    }
}
