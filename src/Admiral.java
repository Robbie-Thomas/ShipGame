import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Admiral implements WAM
{

    HashMap<String, Ship> shipList = new HashMap<String, Ship>();
    HashMap<String, Ship> myFleet = new HashMap<String, Ship>();

    HashMap<Integer, Encounter> encounters = new HashMap<Integer, Encounter>();

    private String fileName;

    private double warChest;
    private String playerName;

    public Admiral(String nam)
    {
        playerName = nam;
        warChest = 1000;
        setUpEncounters();
        setUpShips();

    }

    public Admiral(String nam, String file)
    {
        playerName = nam;
        warChest = 1000;
        fileName = file;
        try
        {
            readShips();
        } catch (FileNotFoundException e)
        {
            System.err.println("File not found");
        }
        readEncounters();

    }

    public Admiral(String nam, double chest, HashMap<String, Ship> fleet,
                   HashMap<String, Ship> res)
    {
        playerName = nam;
        warChest = chest;
        myFleet = fleet;
        shipList = res;
    }


    /**
     * Returns a String representation of the state of the game,
     * including the name of the admiral, state  ofthe warChest,
     * whether defeated or not, and the ships currently in the
     * fleet,(or, "No ships" if fleet is empty)
     *
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the warChest,
     * whether defeated or not, and the ships currently in the
     * fleet,(or, "No ships" if fleet is empty)
     */

    public String toString()
    {
        if(!isDefeated())
        {
            return "Name: " + playerName + "\nMoney in War Chest: " + getMoney()
                    + "\nShips in Reserve: " + "\n" + getReserves()
                    + "\n\nShips in your fleet: " + getFleet();
        }
        return  "YOU HAVE BEEN DEFEATED!!!!"+"\nName: " +
                playerName + "\nMoney in War Chest: " + getMoney()
                + "\nShips in Reserve: " + "\n" + getReserves()
                + "\n\nShips in your fleet: " + getFleet();
    }

    /**
     * returns true if War Chest <=0 and the admiral's fleet has no
     * ships which can be decommissioned.
     *
     * @returns true if War Chest <=0 and the admiral's fleet has no
     * ships which can be decommissioned.
     */
    public boolean isDefeated()
    {

        boolean restFlag = false;

        Collection<Ship> cTemp = myFleet.values();
        for (Ship temp : cTemp)
        {
            //returns false if there are any ships that can be decommissioned
            if (temp.getState() == ShipState.ACTIVE)
            {
                return false;
            }
            else if (temp.getState() == ShipState.RESTING)
            {
                restFlag = true;
            }
        }
        //Returns false if there are any ships that can be recommissioned
        if (restFlag)
        {
            return false;
        }
        //returns false if there is not enough money to commission the
        // cheapest ship
        if (warChest >= getLowestCommFee())
        {
            return false;
        }

        return true;
    }

    /**
     * Returns the commissioning fee of the ship in the reserves with the
     * lowest commissioning fee
     *
     * @return min Lowest Commissioning fee of a ship
     */
    private double getLowestCommFee()
    {
        Collection<Ship> cTemp = shipList.values();
        double min = Double.MAX_VALUE;

        for (Ship temp : cTemp)
        {
            if (temp.getCommFee() < min)
                min = temp.getCommFee();
        }
        return min;
    }

    private Ship getMyShip(String nme)
    {
        if (myFleet.containsKey(nme))
        {
            return myFleet.get(nme);
        }
        return null;
    }

    /**
     * returns the amount of money in the War Chest
     *
     * @returns the amount of money in the War Chest
     */
    public double getMoney()
    {
        return warChest;
    }

    /**
     * Returns a String representation of all ships in the reserves
     *
     * @return a String representation of all ships in the reserves
     */
    public String getReserves()
    {
        String sTemp = "";
        Collection<Ship> cTemp = shipList.values();
        for (Ship temp : cTemp)
        {
            sTemp += temp.toString();
        }
        return sTemp;
    }

    /**
     * Returns details of a reserve ship with the given name
     *
     * @return details of a reserve ship with the given name
     */
    public String findShipInReserve(String nme)
    {
        Ship temp = shipList.get(nme);
        if (temp != null)
        {
            return temp.toString();
        }
        return "Ship not Found";
    }

    /**
     * Returns details of any ship with the given name
     *
     * @return details of any ship with the given name
     */
    public String getShip(String nme)
    {
        String a = "Ship Not Found";

        if (myFleet.containsKey(nme))
        {
            a = getMyShip(nme).toString();
        }
        else if (shipList.containsKey(nme))
        {
            a = shipList.get(nme).toString();
        }
        return a;
    }

    // ***************** Fleet Ships ************************

    /**
     * Allows a ship to be comissioned to the admiral's fleet, if there
     * is enough money in the War Chest for the commission fee.The ship's
     * state is set to "active"
     *
     * @param nme represents the name of the ship
     * @return "Ship commissioned" if ship is commissioned, "Not found"
     * if ship not found, "Not available" if ship is not in the reserve,
     * "Not enough money" if not enough money in the warChest
     */
    public String commissionShip(String nme)
    {
        if (!isDefeated())
        {
            if (myFleet.containsKey(nme))
            {
                return "Not Available";
            }
            if (!shipList.containsKey(nme))
            {
                return "Not Found";
            }

            Ship temp = shipList.get(nme);

            if (warChest >= temp.getCommFee())
            {
                temp.setState(ShipState.ACTIVE);
                warChest -= temp.getCommFee();
                myFleet.put(nme, temp);
                shipList.remove(nme);
                return "Ship commissioned";
            }
            return "Not enough money";
        }
        return "You have been defeated!";
    }

    /**
     * Returns true if the ship with the name is in
     * the admiral's fleet, false otherwise.
     *
     * @param nme is the name of the ship
     * @return returns true if the ship with the name
     * is in the admiral's fleet, false otherwise.
     */
    public boolean isInAdmiralsFleet(String nme)
    {
        if (myFleet.containsKey(nme))
            return true;

        return false;
    }

    /**
     * Removes a ship from the fleet to the reserves, if they are in the fleet
     * pre-condition: isInAdmiralsFleet(nme)
     *
     * @param nme is the name of the ship
     */
    public void decommissionShip(String nme)
    {
        if (!isDefeated())
        {
            if (isInAdmiralsFleet(nme))
            {
                Ship temp = myFleet.get(nme);
                if (temp.getState() != ShipState.SUNK)
                {
                    temp.setState(ShipState.RESERVE);
                    myFleet.remove(nme);
                    shipList.put(nme, temp);
                    warChest = warChest + (temp.getCommFee() / 2);
                    System.out.println("Ship has been decommissioned");
                }
                else
                {
                    System.out.println("This ship is sunk.");
                }
            }
            else
                System.out.println("The ship is not in your fleet.");
        }
        else
            System.out.println("You have been defeated");
    }

    /**
     * Returns a String representation of the ships in the admiral's fleet
     * or the message "No ships hired"
     *
     * @return a String representation of the ships in the admiral's fleet
     */
    public String getFleet()
    {
        String a = "";
        if (!myFleet.isEmpty())
        {
            Collection<Ship> cTemp = myFleet.values();
            for (Ship temp : cTemp)
            {
                a = a + temp.toString();
            }
        }

        else
        {
            a = "No ships hired";
        }
        return a;
    }

    /**
     * Restores a ship to the fleet by setting their state to AVAILABLE
     *
     * @param nme name of the ship to be restored
     */
    public void recommissionShip(String nme)
    {
        if (myFleet.containsKey(nme))
        {
            Collection<Ship> cTemp = myFleet.values();

            for (Ship temp : cTemp)
            {
                if (temp.getName().equals(nme))
                {
                    if (temp.getState() == ShipState.RESTING)
                    {
                        temp.setState(ShipState.ACTIVE);
                        break;
                    }
                    else if (temp.getState() == ShipState.ACTIVE)
                        System.out.println("Ship is already active");
                    else
                        System.out.println("Cannot recommission a "
                                + "sunk ship");
                }
            }
        }
        else
            System.out.println("Ship not in fleet");
    }

    //**********************Encounters*************************

    /**
     * returns true if the number represents a encounter
     *
     * @param num is the number of the encounter
     * @returns true if the number represents a encounter
     */
    public boolean isEncounter(int num)
    {
        return encounters.containsKey(num);
    }

    /**
     * Retrieves the encounter represented by the encounter
     * number.Finds a ship from the fleet which can fight the
     * encounter. The results of fighting an encounter will be
     * one of the following: �Encounter won by...(ship reference and name)�
     * � add plunder to War Chest and ship's state is set to ShipState.RESTINGING,  �Encounter
     * lost as no ship available� � deduct plunder from the War Chest,�Encounter
     * lost on battle skill level and (ship name) sunk/lost" - deduct plunder from
     * War Chest and ship state set to sunk. If an encounter is lost and admiral
     * is completely defeated, add �You have been defeated � to the output.
     * Ensure that the state of the war chest is also included in the return message.
     *
     * @param encNo is the number of the encounter
     * @return a String showing the result of fighting the encounter
     */
    public String fightEncounter(int encNo)
    {
        if (!isDefeated())
        {
            if (isEncounter(encNo))
            {
                //Getting the encounter Type
                Encounter eTemp = encounters.get(encNo);

                Collection<Ship> cTemp = myFleet.values();
                for (Ship temp : cTemp)
                {
                    if (temp.canEncounter(eTemp.getEncounterType())
                            && temp.getState() == ShipState.ACTIVE)
                    {
                        if (temp.getBattleSkill() >= eTemp.getBattleSkill())
                        {
                            warChest += eTemp.getPlunder();

                            temp.setState(ShipState.RESTING);
                            return "Encounter won by " + temp.getName()
                                    + "! " + eTemp.getPlunder()
                                    + " Plunder added to chest";
                        }
                        else
                        {
                            String a = "";
                            warChest -= eTemp.getPlunder();
                            if (isDefeated())
                            {
                                a = "\nYou have been Defeated! " + eTemp
                                        .getPlunder()
                                        + " Plunder has been lost";
                            }
                            else
                                a = eTemp.getPlunder() + " Plunder has been "
                                        + "lost";
                            temp.setState(ShipState.SUNK);
                            return "Battle Lost on Skill Level " + a;
                        }
                    }

                }
                String a = "";
                warChest -= eTemp.getPlunder();
                if (isDefeated())
                {
                    a = "\nYou have been Defeated!";
                }

                return "Battle lost as no Ships available!" + a +" "+ eTemp
                        .getPlunder() +" Plunder lost";
            }
            return "Not a valid encounter";
        }
        return "You have been defeated!";
    }

    /**
     * Provides a String representation of an encounter given by
     * the encounter number
     *
     * @param num the number of the encounter
     * @return returns a String representation of a encounter given by
     * the encounter number
     */
    public String getEncounter(int num)
    {
        if (encounters.containsKey(num))
        {
            return encounters.get(num).toString();
        }
        return null;
    }

    /**
     * Provides a String representation of all encounters
     *
     * @return returns a String representation of all encounters
     */
    public String getAllEncounters()
    {
        String a = "";
        Collection<Encounter> eTemp = encounters.values();
        for (Encounter temp : eTemp)
        {
            a = a + temp.toString();

        }
        return a;
    }

    // These methods are not needed until Task 7
    // ***************   file write/read  *********************

    /**
     * Writes whole game to the specified file
     *
     * @param fname name of file storing requests
     */
    public void saveGame(String fname)
    {
        File save = new File(fname);

        if(save.exists())
        {
            System.out.println("File already exists");
        }
        else
        {
            String saveString = "";

            saveString += playerName +","+ warChest +"\n";


            Collection<Ship> cTemp = myFleet.values();

            for(Ship temp : cTemp)
            {
                saveString += temp.getName() +","+temp.getStateName().trim
                        ()+"\n";
            }

			/*cTemp = shipList.values();

			for(Ship temp : cTemp)
			{
				saveString += temp.getName() +","+temp.getStateName().trim
						()+"\n";
			}
*/
            try
            {
                FileOutputStream outs = new FileOutputStream(save, true);
                PrintStream writer = new PrintStream(outs);

                writer.append(saveString);

            }
            catch (IOException e)
            {
                System.err.println("Invalid Input");
            }
            System.out.println("Game Saved!");
        }
    }

    /**
     * reads all information about the game from the specified file
     * and returns an Admiral object
     *
     * @param fname name of file storing the game
     * @return the game (as a Admiral object)
     */
    public Admiral loadGame(String fname)
    {
        File load = new File(fname);
        Admiral temp = null;
        try
        {
            Scanner inFile = new Scanner(load);
            String pName;
            double chest = 0;
            String shipName, state = "", input = "";


            input = inFile.nextLine();
            String[] params = input.split(",");
            pName = params[0];
            chest = Double.parseDouble(params[1]);

            HashMap<String, Ship> fleetTemp = new HashMap<String, Ship>();
            HashMap<String, Ship> reserveTemp = shipList;
            while (inFile.hasNext())
            {
                input = inFile.next();
                params = input.split(",");


                shipName = params[0];
                state = params[1];

                if(state.equals("Active"))
                {
                    shipList.get(shipName).setState(ShipState.ACTIVE);
                    fleetTemp.put(shipName, shipList.get(shipName));
                    reserveTemp.remove(shipName);

                }
                else if(state.equals("Resting"))
                {
                    shipList.get(shipName).setState(ShipState.RESTING);
                    fleetTemp.put(shipName, shipList.get(shipName));
                    reserveTemp.remove(shipName);
                }
                else if(state.equals("Sunk/Lost"))
                {
                    shipList.get(shipName).setState(ShipState.SUNK);
                    fleetTemp.put(shipName, shipList.get(shipName));
                    reserveTemp.remove(shipName);
                }
            }
            temp = new Admiral(pName, chest, fleetTemp, reserveTemp);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File Not Found");
        }
        return temp;
    }

    /**
     * Sets up mock encounters
     */
    private void setUpEncounters()
    {
        EncounterType BATTLE = EncounterType.BATTLE;
        EncounterType SKIRMISH = EncounterType.SKIRMISH;
        EncounterType BLOCKADE = EncounterType.BLOCKADE;

        Encounter enc[] = new Encounter[9];

        enc[0] = new Encounter(1, BATTLE, 3, 300);
        enc[1] = new Encounter(2, SKIRMISH, 3, 120);
        enc[2] = new Encounter(3, BLOCKADE, 3, 150);
        enc[3] = new Encounter(4, BATTLE, 9, 200);
        enc[4] = new Encounter(5, BLOCKADE, 7, 90);
        enc[5] = new Encounter(6, SKIRMISH, 8, 45);
        enc[6] = new Encounter(7, BLOCKADE, 6, 130);
        enc[7] = new Encounter(8, BATTLE, 4, 100);
        enc[8] = new Encounter(9, SKIRMISH, 5, 200);

        for (int i = 0; i < enc.length; i++)
        {
            encounters.put(enc[i].getEncounterNum(), enc[i]);
        }

    }

    /**
     * Sets up mock Ships
     */
    private void setUpShips()
    {
        Ship shipArr[] = new Ship[9];
        shipArr[0] = new ManOWar("Victory", "Alan Aikin", 3, 3, 30);
        shipArr[1] = new Frigate("Sophie", "Ben Baggins", 8, 16, true);
        shipArr[2] = new ManOWar("Endeavour", "Col Cannon", 8, 2, 20);
        shipArr[3] = new Sloop("Arrow", "Dan Dare", 150, true);
        shipArr[4] = new ManOWar("Belerophone", "Ed Evans", 8, 3, 50);
        shipArr[5] = new Frigate("Surprise", "Fred Fox", 6, 10, false);
        shipArr[6] = new Frigate("Jupiter", "Gil Gamage", 7, 20, false);
        shipArr[7] = new Sloop("Paris", "Hal Henry", 200, true);
        shipArr[8] = new Sloop("Beast", "Ian Idle", 400, false);

        for (int i = 0; i < shipArr.length; i++)
        {
            shipList.put(shipArr[i].getName(), shipArr[i]);
        }

    }

    /**
     * sets up Ships from file
     * @throws FileNotFoundException
     */
    private void readShips() throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new FileReader(fileName));

        String type = "", name = "", cap = "", input = "";
        int battleSkill = 0, cannon = 0, marines = 0, commFee = 0;
        boolean pinnace = false, doctor = false;
        Ship temp;

        while (inFile.hasNext())
        {
            input = inFile.next();
            String[] params = input.split(",");

            if (params[0].equals("ManOWar"))
            {
                name = params[1];
                cap = params[2];
                battleSkill = Integer.parseInt(params[3]);
                cannon = Integer.parseInt(params[4]);
                marines = Integer.parseInt(params[5]);

                temp = new ManOWar(name, cap, battleSkill, cannon, marines);
                shipList.put(name, temp);
            }
            else if (params[0].equals("Frigate"))
            {
                name = params[1];
                cap = params[2];
                battleSkill = Integer.parseInt(params[3]);
                cannon = Integer.parseInt(params[4]);

                if (params[5].equals("true"))
                {
                    pinnace = true;
                }
                temp = new Frigate(name, cap, battleSkill, cannon, pinnace);
                shipList.put(name, temp);
            }
            else if (params[0].equals("Sloop"))
            {
                name = params[1];
                cap = params[2];
                battleSkill = Integer.parseInt(params[3]);
                commFee = Integer.parseInt(params[4]);

                if (params[5].equals("true"))
                {
                    doctor = true;
                }

                temp = new Sloop(name, cap, commFee, doctor);
                shipList.put(name, temp);
            }
        }
    }

    /**
     * sets up encounters from file
     */
    private void readEncounters()
    {
        try
        {
            Scanner inFile = new Scanner(new FileReader("encounters.txt"));

            String input = "";
            int encNo = 0, plunder = 0, battleSkill = 0;
            EncounterType encTyp;
            Encounter temp;

            while (inFile.hasNext())
            {
                input = inFile.next();
                String[] params = input.split(",");

                if (params[1].equals("Battle"))
                {
                    encNo = Integer.parseInt(params[0]);
                    encTyp = EncounterType.BATTLE;
                    battleSkill = Integer.parseInt(params[2]);
                    plunder = Integer.parseInt(params[3]);

                    temp = new Encounter(encNo, encTyp, battleSkill, plunder);
                    encounters.put(encNo, temp);
                }
                else if (params[1].equals("Skirmish"))
                {
                    encNo = Integer.parseInt(params[0]);
                    encTyp = EncounterType.SKIRMISH;
                    battleSkill = Integer.parseInt(params[2]);
                    plunder = Integer.parseInt(params[3]);

                    temp = new Encounter(encNo, encTyp, battleSkill, plunder);
                    encounters.put(encNo, temp);
                }
                else if (params[1].equals("Blockade"))
                {
                    encNo = Integer.parseInt(params[0]);
                    encTyp = EncounterType.BLOCKADE;
                    battleSkill = Integer.parseInt(params[2]);
                    plunder = Integer.parseInt(params[3]);

                    temp = new Encounter(encNo, encTyp, battleSkill, plunder);
                    encounters.put(encNo, temp);
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println("File not Found");
        }
    }
}