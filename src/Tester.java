public class Tester
{
    private WAM Fred;

    public void doTest()
    {
        Fred = new Admiral("Fred");
        /**
         * Should show Player Name, 1000 in War Chest, All ships in Reserve
         */
        System.out.println(Fred.isDefeated());
        System.out.println(Fred.toString());
        /**
         * Checks how much money is in the war chest
         */
        System.out.println("£" + Fred.getMoney());
        System.out.print("\n");
        /**
         * Prints out a string representation of the fleet
         */

        System.out.println(Fred.getFleet());
        System.out.print("\n");
        /**
         * prints out a string representation of the reserves
         */
        System.out.println(Fred.getReserves());
        /**
         * Commissions a series of ships to test the commission ship method
         */
        System.out.println(Fred.commissionShip("Victory"));
        System.out.println(Fred.commissionShip("Sophie"));
        System.out.println(Fred.commissionShip("Jupiter"));
        System.out.println(Fred.commissionShip("Jupiter"));
        System.out.println(Fred.commissionShip("Alpha"));
        System.out.println(Fred.commissionShip("Beast"));
        System.out.print("\n");
        /**
         * Checks to see if a ship is in the fleet
         */
        System.out.println(Fred.isInAdmiralsFleet("Victory"));
        System.out.println(Fred.isInAdmiralsFleet("Alpha"));
        /**
         * Checks to see war chest balance after the ships has been commissioned
         */
        System.out.println("£" + Fred.getMoney());
        /**
         * Tests to see if you can decommission a ship
         */
        Fred.decommissionShip("Sophie");
        Fred.decommissionShip("Alpha");
        /**
         * Looks to see how much money has been added after decommissioning a ship
         */
        System.out.println(Fred.getMoney());
        /**
         * Returns a string representation of the fleet
         */
        System.out.println(Fred.getFleet());
        /**
         * Looks for ship "Beast" in the reserve
         */
        System.out.println(Fred.findShipInReserve("Beast"));
        /**
         * Returns a string representation of the reserves after ships have been
         * added to the fleet
         */
        System.out.println(Fred.getReserves());
        /**
         * Test fightEncounter()
         */
        System.out.println(Fred.fightEncounter(1));
        System.out.println(Fred.fightEncounter(3));
        System.out.println(Fred.fightEncounter(1));

        Fred.recommissionShip("Victory");
        /**
         * Tests isEncounter()
         */
        Fred.isEncounter(1);

        /**
         *  returns a String representation of encounter 1
         */
        Fred.getEncounter(1);
        /**
         * returns a string representation of all the encounters
         */
    }

    public static void main(String args[]) throws Exception
    {
        Tester newTest = new Tester();
        newTest.doTest();
    }
}
