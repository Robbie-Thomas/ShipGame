
import javax.swing.*;
import java.util.Random;


class GameGUI extends javax.swing.JFrame {

    private javax.swing.JButton clear;
    private javax.swing.JLabel currentFunc;
    private java.awt.TextArea displayArea;
    private javax.swing.JLayeredPane displayPane;
    private javax.swing.JButton encounter;
    private javax.swing.JButton gameState;
    private java.awt.TextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton quit;
    private javax.swing.JComboBox ships;
    private javax.swing.JButton submit;
    private WAM game = new Admiral("Fred");

    /**
     * Creates new form GameGUI
     */
    public GameGUI() {
        initComponents();
        hideComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        encounter = new javax.swing.JButton();
        gameState = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        ships = new javax.swing.JComboBox();
        clear = new javax.swing.JButton();
        currentFunc = new javax.swing.JLabel();
        displayPane = new javax.swing.JLayeredPane();
        input = new java.awt.TextField();
        submit = new javax.swing.JButton();
        displayArea = new java.awt.TextArea();

        jLabel1.setText("Welcome Admiral Fred");

        encounter.setText("Fight Encounter");

        JFrame.setDefaultLookAndFeelDecorated(false);
        gameState.setText("Game State");

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quitActionPerformed(evt);
            }
        });

        //Creates the combo box
        ships.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Select", "List Reserve Ships",
                        "List Admiral's Fleet", "Commission Ship",
                        "Decommission Ship", "Recommission Ship" }));
        ships.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                shipsActionPerformed(evt);
            }
        });

        //Action Listener for clear button
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearActionPerformed(evt);
            }
        });

        //Text Field Input
        input.setText("Enter Ship Name");
        input.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                inputMouseClicked(evt);
            }
        });
        //Submit Button
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                submitActionPerformed(evt);
            }
        });

        encounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encounterActionPerformed(evt);
            }
        });

        gameState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameStateActionPerformed(evt);
            }
        });

        //Setting Display Layout for JFrame
        javax.swing.GroupLayout displayPaneLayout = new javax.swing.GroupLayout(displayPane);
        displayPane.setLayout(displayPaneLayout);
        displayPaneLayout.setHorizontalGroup(
                displayPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(displayPaneLayout.createSequentialGroup()
                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
                        .addGroup(displayPaneLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(submit)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addGroup(displayPaneLayout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(displayArea,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, 255,
                                        Short.MAX_VALUE))
        );

        //Setting Vertical Layout
        displayPaneLayout.setVerticalGroup(
                displayPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(displayPaneLayout.createSequentialGroup()
                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submit)
                                .addGap(0, 200, Short.MAX_VALUE))
                        .addGroup(displayPaneLayout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(displayArea,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, 253,
                                        Short.MAX_VALUE))
        );
        //Layer Pane for
        displayPane.setLayer(input, javax.swing.JLayeredPane.DEFAULT_LAYER);
        displayPane.setLayer(submit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        displayPane.setLayer(displayArea,
                javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        false)
                                                        .addComponent(jLabel1)
                                                        .addComponent(encounter,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(quit,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(gameState,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(ships, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                layout.createSequentialGroup()
                                                                        .addComponent(
                                                                                currentFunc)
                                                                        .addGap(0, 255,
                                                                                Short.MAX_VALUE))
                                                        .addComponent(displayPane)))
                                        .addGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(clear,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                113,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(currentFunc,
                                                javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(ships,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        119, Short.MAX_VALUE)
                                                .addComponent(encounter)
                                                .addGap(4, 4, 4)
                                                .addComponent(gameState)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quit)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(displayPane,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))
                                .addComponent(clear)
                                .addGap(4, 4, 4))
        );

        pack();
    }

    /**
     * Actions performed on the ships combo box
     **/
    private void shipsActionPerformed(java.awt.event.ActionEvent evt)
    {
        //Shows all the ships in reserve
        if(ships.getSelectedIndex() == 1)
        {
            hideComponents();
            currentFunc.setText("All Ships in Reserves");
            displayPane.setVisible(true);
            displayArea.setVisible(true);
            clear.setVisible(true);
            displayArea.setText(game.getReserves());

            ships.setSelectedIndex(0);
        }
        //Shows all the ships in Admiral's Fleet
        else if(ships.getSelectedIndex() == 2)
        {
            hideComponents();
            currentFunc.setText("My Fleet");
            displayPane.setVisible(true);
            displayArea.setVisible(true);
            clear.setVisible(true);
            displayArea.setText(game.getFleet());

            ships.setSelectedIndex(0);
        }
        //Commission Ship
        else if(ships.getSelectedIndex() == 3)
        {
            hideComponents();
            currentFunc.setText("Commission Ship");

            ships.setSelectedIndex(0);

            displayPane.setVisible(true);
            input.setVisible(true);
            submit.setVisible(true);
        }
        //De-Commission Ship
        else if(ships.getSelectedIndex() == 4)
        {
            hideComponents();
            currentFunc.setText("De-Commission Ship");

            ships.setSelectedIndex(0);

            displayPane.setVisible(true);
            input.setVisible(true);
            submit.setVisible(true);
        }
        //Re-Commission Ship
        else if(ships.getSelectedIndex() == 5)
        {
            hideComponents();
            currentFunc.setText("Re-Commission Ship");

            ships.setSelectedIndex(0);

            displayPane.setVisible(true);
            input.setVisible(true);
            submit.setVisible(true);
        }
    }

    /**
     * When the submit button is pressed on the commission/ de-commission/
     * re-commission
     * @param evt
     */
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        displayArea.setVisible(true);
        input.setVisible(false);
        submit.setVisible(false);
        //Commission Ship
        if(currentFunc.getText().equals("Commission Ship"))
            displayArea.setText(game.commissionShip(input.getText()));
            //De-Commission Ship
        else if(currentFunc.getText().equals("De-Commission Ship"))
        {
            game.decommissionShip(input.getText());

        }
        else if(currentFunc.getText().equals("Re-Commission Ship"))
        {
            game.recommissionShip(input.getText());
        }
    }

    /**
     * Sets the visibilty of all components to false
     */
    private void hideComponents()
    {
        currentFunc.setText(null);
        input.setText("Enter Ship ");
        input.setVisible(false);
        submit.setVisible(false);
        clear.setVisible(false);

        displayArea.setText(null);
        displayArea.setVisible(false);

        displayPane.setVisible(false);
    }

    /**
     * Quit button. Quits application
     * @param evt
     */
    private void quitActionPerformed(java.awt.event.ActionEvent evt)
    {
        dispose();
        System.exit(0);
    }

    /**
     * Clears Text Area
     * @param evt
     */
    private void clearActionPerformed(java.awt.event.ActionEvent evt)
    {
        displayArea.setText(null);
    }

    /**
     * clears the text box when it is clicked on
     * @param evt
     */
    private void inputMouseClicked(java.awt.event.MouseEvent evt)
    {
        input.setText(null);
    }

    /**
     * Deals with encounters
     * @param evt
     */
    private void encounterActionPerformed(java.awt.event.ActionEvent evt)
    {
        hideComponents();

        Random randomGenerator = new Random();
        int randomInt = (randomGenerator.nextInt(9)+1);
        displayArea.setVisible(true);
        displayPane.setVisible(true);

        currentFunc.setText("Fighting Encounter");

        displayArea.setText("Fighting Encounter : "+randomInt+"\n" + game
                .fightEncounter(randomInt)) ;
    }

    /**
     * Shows Game State in Display Pane
     * @param evt
     */
    private void gameStateActionPerformed(java.awt.event.ActionEvent evt)
    {
        hideComponents();

        displayPane.setVisible(true);
        displayArea.setVisible(true);
        clear.setVisible(true);
        currentFunc.setText("Game State");
        displayArea.setText(game.toString());

    }

    public static void main(String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI().setVisible(true);
            }
        });
    }
}
