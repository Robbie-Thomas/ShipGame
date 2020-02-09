
public class ManOWar extends Ship
{
    /**
     * declaring the fields for ManOWar class
     */
    private int cannonLevel;
    private int marines;
    private int commFee;
    private int battleSkill;

    /**
     * Creating a ManOWar Object
     * @param name Ships name
     * @param captain Captains name
     * @param bs The battleskill level
     * @param canLvl Number of cannon levels
     * @param mar Number of marines
     */
    public ManOWar(String name, String captain, int bs, int
            canLvl, int mar)
    {
        super( "Man-o-War", name, captain);
        cannonLevel = canLvl;
        marines = mar;
        battleSkill = bs;

        commFee = 500;
        if (cannonLevel == 2)
            commFee = 200;
    }
    /**
     * Returns the commissioning fee of the ManOWar	 * @return An int
     * representation of the commissioning fee
     */
    public int getCommFee()
    {
        return commFee;
    }
    /**
     * Returns the cannon level of the ManOWar
     * @return an int representation of the cannonlevel
     */
    public int getCannonLevel()
    {
        return cannonLevel;
    }
    /**
     * Returns the amount of marians of the ManOWar
     * @return an int representation of the marines
     */
    public int getMarines()
    {
        return marines;
    }
    /**
     * Returns the battle skill of the ManOWar
     * @return an int representation of the battleskill
     */
    public int getBattleSkill()
    {
        return battleSkill;
    }

    /**
     * looks to see if the ship can fight an type of encounter
     * @param type Encounter Type
     * @return true if the sjip can fight the encounter
     */
    public boolean canEncounter(EncounterType type)
    {
        if(type != EncounterType.SKIRMISH)
        {
            return true;
        }
        return false;
    }
    /**
     * Returns a string of the ManOWar Class
     * @return a String representation of the ManOWar Class
     */
    public String toString()
    {
        return super.toString() + "Commission Fee: " + commFee + "\nCannon "
                + "Levels: " + getCannonLevel() + "\nBattle Skill: "
                + getBattleSkill() + "\nMarines: " + getMarines() +"\n\n";
    }
}
