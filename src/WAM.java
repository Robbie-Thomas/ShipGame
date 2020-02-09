import java.io.*;

public interface WAM extends Serializable
{
    //**************** WAM **************************

    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the warChest,
     * whether defeated or not, and the ships currently in the
     * fleet,(or, "No ships" if fleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the warChest,
     * whether defeated or not, and the ships currently in the
     * fleet,(or, "No ships" if fleet is empty)
     **/
    String toString();


    /** returns true if War Chest <=0 and the admiral's fleet has no
     * ships which can be decommissioned.
     * @returns true if War Chest <=0 and the admiral's fleet has no
     * ships which can be decommissioned.
     */
     boolean isDefeated();

    /** returns the amount of money in the War Chest
     * @returns the amount of money in the War Chest
     */
     double getMoney();


    /**Returns a String representation of all ships in the reserves
     * @return a String representation of all ships in the reserves
     **/
     String getReserves();


    /** Returns details of a reserve ship with the given name
     * @return details of a reserve ship with the given name
     **/
     String findShipInReserve(String nme);


    /** Returns details of any ship with the given name
     * @return details of any ship with the given name
     **/
     String getShip(String nme);


    // ***************** Fleet Ships ************************
    /** Allows a ship to be comissioned to the admiral's fleet, if there
     * is enough money in the War Chest for the commission fee.The ship's
     * state is set to "active"
     * @param nme represents the name of the ship
     * @return "Ship commissioned" if ship is commissioned, "Not found"
     * if ship not found, "Not available" if ship is not in the reserve,
     * "Not enough money" if not enough money in the warChest
     **/
     String commissionShip(String nme);


    /** Returns true if the ship with the name is in
     * the admiral's fleet, false otherwise.
     * @param nme is the name of the ship
     * @return returns true if the ship with the name
     * is in the admiral's fleet, false otherwise.
     **/
     boolean isInAdmiralsFleet(String nme);


    /** Removes a ship from the fleet to the reserves, if they are in the fleet
     * pre-condition: isInAdmiralsFleet(nme)
     * @param nme is the name of the ship
     **/
     void decommissionShip(String nme);


    /**Returns a String representation of the ships in the admiral's fleet
     * or the message "No ships hired"
     * @return a String representation of the ships in the admiral's fleet
     **/
     String getFleet();


    /**Restores a ship to the fleet by setting their state to AVAILABLE
     * @param nme is name of the ship to be restored
     */
     void recommissionShip(String nme);


//**********************Encounters*************************
    /** returns true if the number represents a encounter
     * @param num is the number of the encounter
     * @returns true if the number represents a encounter
     **/
     boolean isEncounter(int num);


    /** Retrieves the encounter represented by the encounter
     * number.Finds a ship from the fleet which can fight the
     * encounter. The results of fighting an encounter will be
     * one of the following: �Encounter won by...(ship reference and name)�
     * � add plunder to War Chest and ship's state is set to RESTING,  �Encounter
     * lost as no ship available� � deduct plunder from the War Chest,�Encounter
     * lost on battle skill level and (ship name) sunk/lost" - deduct plunder from
     * War Chest and ship state set to sunk. If an encounter is lost and admiral
     * is completely defeated, add �You have been defeated � to the output.
     * Ensure that the state of the war chest is also included in the return message.
     * @param encNo is the number of the encounter
     * @return a String showing the result of fighting the encounter
     */
     String fightEncounter(int encNo);


    /** Provides a String representation of an encounter given by
     * the encounter number
     * @param num the number of the encounter
     * @return returns a String representation of a encounter given by
     * the encounter number
     **/
     String getEncounter(int num);


    /** Provides a String representation of all encounters
     * @return returns a String representation of all encounters
     **/
     String getAllEncounters();
     // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
     void saveGame(String fname);

    /** reads all information about the game from the specified file
     * and returns an Admiral object
     * @param fname name of file storing the game
     * @return the game (as a Admiral object)
     */
     Admiral loadGame(String fname);
}
