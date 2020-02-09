
public class Encounter
{
    /**
     * Creates the fields for encounter
     */
    private int plunder;
    private int battleSkill;
    private int encounterNum;

    EncounterType encounterType;

    /**
     * Creates an encounter object
     * @param enNum The encounter number
     * @param type The encounter type
     * @param bs The battle skill of the encounter
     * @param plun The plunder of the encounter
     */
    public Encounter(int enNum, EncounterType type, int bs, int plun)
    {
        encounterNum = enNum;
        plunder = plun;
        battleSkill = bs;
        encounterType = type;
    }

    /**
     * returns the plunder
     * @return an int representation of the plunder
     */
    public int getPlunder()
    {
        return plunder;
    }

    /**
     * returns the encounters battle skill
     * @return an int representation of the battleskill
     */
    public int getBattleSkill()
    {
        return battleSkill;
    }

    /**
     *returns the encounter number
     * @return an int representation of the encounter number
     */
    public int getEncounterNum()
    {
        return encounterNum;
    }

    /**
     * returns the encounter type
     * @return an encounterType representation of the encounter
     */
    public EncounterType getEncounterType()
    {
        return encounterType;
    }

    /**
     * Returns the encounter type
     * @return a string representation of the encounter type
     */
    public String getEncounterName()
    {
        return encounterType.toString();
    }

    /**
     * returns a string of the encounter
     * @return a string representation of the encounter
     */
    public String toString()
    {
        return "\nEncounter Number: " + getEncounterNum() + "\nBattle Skill Required: " + getBattleSkill() +
                "\n Encounter Type: " + getEncounterName() + "\nPlunder: " +
                getPlunder()+"\n\n";
    }
}
