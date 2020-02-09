public class Sloop extends Ship
{
    /**
     * Creates the fields for Sloop
     */
    private boolean doctor;
    private int commFee;
    private int battleSkill;

    /**
     * Creates a sloop object
     * @param nam Name of the ship
     * @param cap Name of the captain
     * @param fee The commision fee of the sloop
     * @param doc If the ship has a doctor on board
     */
    public Sloop(String nam, String cap, int fee, boolean doc)
    {
        super("Sloop", nam, cap);
        doctor = doc;
        commFee = fee;
        battleSkill = 5;
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
     * Returns the battle skill of the sloop
     * @return an int representation of the battle skill
     */
    public int getBattleSkill()
    {
        return battleSkill;
    }

    /**
     * Looks to see if the sloop has a doctor
     * @return true if the ship has a doctor on board
     */
    public boolean hasDoctor()
    {
        return doctor;
    }
    /**
     * looks to see if the ship can fight an type of encounter
     * @param type Encounter Type
     * @return true if the sjip can fight the encounter
     */
    public boolean canEncounter(EncounterType type)
    {
        if(type != EncounterType.BLOCKADE)
        {
            return true;
        }
        return false;
    }

    /**
     * Creates a string of the sloop
     * @return a string representation of the sloop object
     */
    public String toString()
    {
        return super.toString() + "Commission Fee: "+ commFee
                +"\nBattle Skill: "+ getBattleSkill()
                +"\nDoctor: "+ hasDoctor() +"\n\n";
    }
}
