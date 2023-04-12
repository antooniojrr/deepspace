/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class GameUniverse {
    private static final int WIN = 10;
    private int currentStationIndex;
    private int turns;
    
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations; 
    private Dice dice; 
    private EnemyStarShip currentEnemy;
    private GameStateController gameState;
    
    public GameUniverse(){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
        currentStation=null;
        spaceStations=null;
        currentEnemy=null;
        currentStationIndex=-1;
    }
    
    public boolean haveAWinner() {
        return (currentStation.getNMedals() >= WIN);
    }
    
    public void mountWeapon(int i) {
        currentStation.mountWeapon(i);
    }
    
    public void mountShieldBooster(int i) {
        currentStation.mountShieldBooster(i);
    }
    
    public void discardHangar() { currentStation.discardHangar(); }
    
    public void discardShieldBoosterInHangar(int i) {
        currentStation.discardShieldBoosterInHangar(i);
    }
    
    public void discardWeaponInHangar(int i) {
        currentStation.discardShieldBoosterInHangar(i);
    }
    
    public GameState getState() {
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIVersion() {
        return new GameUniverseToUI(currentStation,currentEnemy);
    }
}
