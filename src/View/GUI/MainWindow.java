
package View.GUI;


import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import View.DeepSpaceView;
import controller.Controller;

import deepspace.GameState;

/**
 * @brief Esta clase representa la vista gráfica principal del juego DeepSpace,
 * consta de dos paneles principales que hacen referencia a la estación espacial
 * actual y al enemigo actual.
 * 
 * Contiene tambien 3 botones con las siguientes acciones:
 *  -> COMBATIR : Se produce el combate
 *  -> SIGUIENTE TURNO : Se pasa de turno al siguiente jugador
 *  -> SALIR DEL JUEGO : Se sale del programa
 */
public class MainWindow extends JFrame implements DeepSpaceView{
    
    private static MainWindow instance = null;
    private String appName;
    
    private SpaceStationView stationView;
    private EnemyStarShipView enemyView;
    
    /**
     * @brief Obtiene la vista gráfica principal del juego
     * @return instance (Singleton)
     */
    public static MainWindow getInstance(){
        if(instance == null){
            instance = new MainWindow();
        }
        return instance;
    }
    
    /**
     * Constructor por defecto de la clase
     */
    private MainWindow() {
        initComponents();
        appName = "DeepSpace";
        setTitle(appName);
        
        stationView = new SpaceStationView();
        enemyView = new EnemyStarShipView();
        
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                Controller.getInstance().finish(0);
            }
        });
    }
    
    /**
     * @brief Obtiene el nombre del programa
     * @return appName
     */
    public String getAppName(){
        return appName;
    }
    
    /**
     * @brief Actualiza la vista gráfica del juego
     */
    @Override
    public void updateView() {
        
        stationView.setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());
        stationPanel.add(stationView);
        enemyView.setEnemy(Controller.getInstance().getUIversion().getCurrentEnemy());
        enemyPanel.add(enemyView);
        
        GameState gameState = Controller.getInstance().getState();
        if(gameState == GameState.INIT){
            //enemyPanel.setVisible(false);
            
            combatButton.setEnabled(true);
            nextTurnButton.setEnabled(false);
        }
        if(gameState == GameState.BEFORECOMBAT){
            //enemyPanel.setVisible(false);
            
            combatButton.setEnabled(true);
            nextTurnButton.setEnabled(false);
        }
        if(gameState == GameState.AFTERCOMBAT){
            //enemyPanel.setVisible(true);
            
            combatButton.setEnabled(false);
            nextTurnButton.setEnabled(true);
        }
        
        
        repaint();
        
    }

    /**
     * @brief Permite mostrar los elementos de la vista incrustados al usuario
     */
    @Override
    public void showView() {
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        combatButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        enemyPanel = new javax.swing.JPanel();
        stationPanel = new javax.swing.JPanel();
        nextTurnButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combatButton.setBackground(new java.awt.Color(255, 255, 204));
        combatButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        combatButton.setText("C O M B A T I R");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(255, 255, 204));
        exitButton.setText("SALIR DEL JUEGO");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        enemyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        stationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nextTurnButton.setBackground(new java.awt.Color(255, 255, 204));
        nextTurnButton.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        nextTurnButton.setText("SIGUIENTE TURNO");
        nextTurnButton.setToolTipText("");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(stationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nextTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(combatButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enemyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextTurnButton)
                            .addComponent(exitButton))
                        .addGap(17, 17, 17))
                    .addComponent(stationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        Controller.getInstance().finish(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        Controller.getInstance().combat();
        updateView();
        revalidate();
    }//GEN-LAST:event_combatButtonActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        Controller.getInstance().nextTurn();
        updateView();
        revalidate();
    }//GEN-LAST:event_nextTurnButtonActionPerformed

    /**
     * @brief Lee los nombres de los jugadores
     * @return ArrayList con los nombres de los jugadores
     */
    @Override
    public ArrayList<String> readNamePlayers() {
        NamesCapture namesCapture = new NamesCapture (this);
        
        return namesCapture.getNames();
    }
    
    /**
     * @brief Pregunta al usuario si quiere salir del programa
     * @return TRUE si quiere salir | FALSE en otro caso
     */
    @Override
    public boolean confirmExitMessage() {
        return (JOptionPane.showConfirmDialog(this, "¿Estás segur@ que deseas salir?", getAppName(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    /**
     * @brief Muestra por pantalla una ventana indicando que no se puede avanzar de turno
     */
    @Override
    public void nextTurnNotAllowedMessage() {
        JOptionPane.showMessageDialog(this, "No puedes avanzar de turno, \nno has cumplido tu castigo.", getAppName(), JOptionPane.ERROR_MESSAGE);
    }

    /**
     * @brief Muestra por pantalla una ventana indicando que se ha perdido el combate
     */
    @Override
    public void lostCombatMessage() {
        JOptionPane.showMessageDialog(this, "Has PERDIDO el combate. \nCumple tu castigo.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @brief Muestra por pantalla una ventana indicando que se ha huido del combate
     */
    @Override
    public void escapeMessage() {
        JOptionPane.showMessageDialog(this, "Has logrado ESCAPAR. \nEres un gallina espacial.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @brief Muestra por pantalla una ventana indicando que se ha ganado el combate
     */
    @Override
    public void wonCombatMessage() {
        JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @brief Muestra por pantalla una ventana indicando que se ha ganado el juego
     */
    @Override
    public void wonGameMessage() {
        JOptionPane.showMessageDialog(this, "ENHORABUENA!!. \nHas ganado el juego!!.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @brief Muestra por pantalla una ventana indicando que se ha ganado y además que se ha transformado a estación eficiente o a ciudad espacial
     */
    @Override
    public void conversionMessage() {
        if(Controller.getInstance().getUIversion().getCurrentEnemy().getLoot().isGetEfficient()){
            JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nAdemás te has CONVERTIDO en una estación EFICIENTE. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nAdemás te has CONVERTIDO en una CIUDAD ESPACIAL. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * @brief Muestra un mensaje indicando que no se puede combatir en este momento
     */
    @Override
    public void noCombatMessage() {
        JOptionPane.showMessageDialog(this, "No puedes combatir en este momento.", getAppName(), JOptionPane.ERROR_MESSAGE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JPanel enemyPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton nextTurnButton;
    private javax.swing.JPanel stationPanel;
    // End of variables declaration//GEN-END:variables
}
