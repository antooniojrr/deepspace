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
    private boolean haveSpaceCity;

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
        spaceStations = new ArrayList();
    }
/***************************************************************************/   
/* PRÁCTICA 4*/
    
    private void makeStationEfficient(){
        if (dice.extraEfficiency())
            currentStation = new BetaPowerEfficientSpaceStation(currentStation);
        else
            currentStation = new PowerEfficientSpaceStation(currentStation);
    }
    
    private void createSpaceCity(){
        if (haveSpaceCity == false){
            ArrayList<SpaceStation> collaborators = new ArrayList<>();
            collaborators = spaceStations; 
            collaborators.remove(currentStation);
            currentStation = new SpaceCity(currentStation, collaborators);
            haveSpaceCity = true;            
        }
    }
    
/****************************************************************************/
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
        currentStation.discardWeaponInHangar(i);
    }
    
    public void discardWeapon(int i) {
        if((GameState.INIT == gameState.getState()) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.discardWeapon(i);
    }
    
    public void discardShieldBooster(int i) {
        if((GameState.INIT == gameState.getState()) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.discardShieldBooster(i);
    }
    
    public GameState getState() {
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIversion() {
        return new GameUniverseToUI(currentStation,currentEnemy);
    }
    
    public void init(ArrayList<String> names){
        GameState state = gameState.getState();
        if (state == GameState.CANNOTPLAY){
            CardDealer dealer = CardDealer.getInstance();
            
            for (int i = 0; i < names.size(); i++){
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation(names.get(i), supplies);
                spaceStations.add(station);
                
                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                Loot lo = new Loot(0,nw,ns,nh,0);
                
                station.setLoot(lo);     
            }
            
            currentStationIndex = dice.whoStarts(names.size());
            currentStation = spaceStations.get(currentStationIndex);
            currentEnemy = dealer.nextEnemy();
            gameState.next(turns, spaceStations.size());
        }
    }
    
    public boolean nextTurn(){
        boolean next = false;
        GameState state = gameState.getState();
        
        if (state == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();
            if (stationState){
                currentStationIndex = (currentStationIndex+1) % spaceStations.size();
                turns++;
                
                currentStation = spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();
                gameState.next(turns,spaceStations.size());
                
                next = true;              
            }
        }
        
        return next;
    }
    
    public CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        CombatResult combatResult; 
        boolean enemyWins;
        ShotResult result;
        GameCharacter ch = dice.firstShot();
        if (ch == GameCharacter.ENEMYSTARSHIP){
            result = station.receiveShot(enemy.fire());
            if (result == ShotResult.RESIST){
                result = enemy.receiveShot(station.fire());
                enemyWins = (result == ShotResult.RESIST);
            }
            else enemyWins = true;            
        } else{
            result = enemy.receiveShot(station.fire());
            enemyWins = (result == ShotResult.RESIST);
        }
        
        if (enemyWins){
            float s = station.getSpeed();
            boolean moves = dice.spaceStationMoves(s);
            if (!moves){
                Damage damage = enemy.getDamage();
                station.setPendingDamage(damage);
                combatResult = CombatResult.ENEMYWINS;
            }
            else
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
        }
        else{
            Loot aLoot = enemy.getLoot();
            
            if (aLoot.getEfficient()){
                makeStationEfficient();
                combatResult = CombatResult.STATIONWINSANDCONVERTS;
            }
            else if (aLoot.spaceCity()){
                createSpaceCity();
                combatResult = CombatResult.STATIONWINSANDCONVERTS;
            }
            else
                combatResult = CombatResult.STATIONWINS;
                
            station.setLoot(aLoot);
        }
        
        gameState.next(turns, spaceStations.size());
        
        return combatResult;
    }
    
    
    public CombatResult combat(){
        GameState state = gameState.getState();
        
        if ((state == GameState.BEFORECOMBAT) || (state == GameState.INIT)){
            return combat(currentStation, currentEnemy);
        } else return CombatResult.NOCOMBAT;
    }
}
