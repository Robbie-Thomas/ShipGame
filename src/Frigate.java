public class Frigate extends Ship
{
    /**
     * Declares the fields for a frigate
     */
    private int cannons;
    private boolean pinnace;
    private int commFee;
    private int battleSkill;

    /**
     * Creates a freigate object
     * @param nam Name of the ship
     * @param cap Captains name
     * @param bat Battle Skill of the ship
     * @param can Amount of cannons on board
     * @param pin If the ship has a pinnace
     */
    public Frigate(String nam, String cap, int bat, int	can, boolean pin)
    {
        super("Frigate", nam, cap);
        cannons = can;
        pinnace = pin;
        commFee = can * 10;
        battleSkill = bat;
    }

    /**
     * Returns the commission fee of the sloop
     * @return an int representation of the commission fee
     */
    public int getCommFee()
    {
        return commFee;
    }
    /**
     * Returns the amount of cannons on board
     * @return an int representation of the cannons on board
     */
    public int getCannons()
    {
        return cannons;
    }
    /**
     * Returns the battle skill of the frigate
     * @return an int representation of the battle skill
     */
    public int getBattleSkill()
    {
        return battleSkill;
    }
    /**
     * Looks to see if the frigate has a pinnace
     * @return true if the ship has a pinnace
     */
    public boolean hasPinnace()
    {
        return pinnace;
    }

    /**
     * looks to see if the ship can fight an type of encounter
     * @param type Encounter Type
     * @return true if the sjip can fight the encounter
     */
    public boolean canEncounter(EncounterType type)
    {
        if(hasPinnace())
            return true;
        else if(type != EncounterType.BLOCKADE)
            return true;

        return false;
    }
    /**
     * Creates a string of the frigate
     * @return a string representation of the frigate object
     */
    public String toString()
    {
        return super.toString() + "Commission Fee: "+ commFee +"\nCannons: "
                + getCannons() +"\nBattle Skill: "+ getBattleSkill()
                +"\nPinnace: "+ hasPinnace() +"\n\n";
    }
}
