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
public class SpaceStation {
    private final float MAXFUEL = 100f; 
    private final float SHIELDLOSSPERUNITSHOT = 0.1f; 
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private Hangar hangar;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;    
    
    private void assignFuelValue(float f){
        if (f < MAXFUEL)
            fuelUnits = f; 
        else 
            fuelUnits = MAXFUEL;
    }
    
    private void cleanPendingDamage(){
        if (pendingDamage.hasNoEffect())
            pendingDamage = null;
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        name = n; 
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        shieldPower = supplies.getShieldPower();
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
        pendingDamage=null;
        hangar=null;
        nMedals=0;
        
    }
    
    public SpaceStation(SpaceStation station) {
        this(station.name, new SuppliesPackage(station.getAmmoPower(),
                                               station.getFuelUnits(),
                                               station.getShieldPower()));
    }
    
    public boolean receiveWeapon(Weapon w){
        boolean ret = false;
        if (hangar != null)
            ret = hangar.addWeapon(w);  
        return ret;
    }

    public boolean receiveShieldBooster(ShieldBooster s){
        boolean ret = false;
        if (hangar != null)
            ret = hangar.addShieldBooster(s);  
        return ret;
    }
        
    public void receiveHangar(Hangar h){
        if (hangar == null){
            hangar = h;
        }
    }
    
    public void discardHangar(){
        hangar = null;
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower += s.getAmmoPower();
        fuelUnits += s.getFuelUnits();
        shieldPower += s.getShieldPower();
    }
    
    public void setPendingDamage(Damage d){
        pendingDamage = d.adjust(weapons, shieldBoosters);
        
    }
    
    public void mountWeapon(int i){
        if (hangar != null){
            Weapon w = hangar.removeWeapon(i);
            if ( w != null)
                weapons.add(w);
        }
    }
    
    public void mountShieldBooster(int i){
        if (hangar != null){
            ShieldBooster s = hangar.removeShieldBooster(i);
            if (s != null)
                shieldBoosters.add(s);
        }
    }
    
    public void discardWeaponInHangar(int i){
        hangar.removeWeapon(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
        hangar.removeShieldBooster(i);
    }
    
    public float getSpeed(){
        return fuelUnits/MAXFUEL;
    }
    
    public void move(){
        if (fuelUnits-getSpeed() <= 0)
            fuelUnits = 0;
        else
            fuelUnits -= getSpeed();
    }
    
    public boolean validState(){
        return (pendingDamage == null || pendingDamage.hasNoEffect() == true);
    }
    
    public void cleanUpMountedItems(){
        for (int i = 0; i < weapons.size(); i++)
            if (weapons.get(i).getUses() == 0)
                weapons.remove(i);
        
        for (int i = 0; i < shieldBoosters.size(); i++)
            if (shieldBoosters.get(i).getUses() == 0)
                shieldBoosters.remove(i);
    }
    
    public float fire(){
        int size=weapons.size();
        float factor=1f;
        for (int i = 0; i < size; i++) {
            Weapon w = weapons.get(i);
            factor*=w.useIt();
         }
        return ammoPower*factor;
    }
    
    public float protection(){
        int size=shieldBoosters.size();
        float factor=1f;
        for (int i = 0; i < size; i++) {
            ShieldBooster s = shieldBoosters.get(i);
            factor*=s.useIt();
         }
        return shieldPower*factor;
    }
    
    public ShotResult receiveShot(float shot){
        float myProtection=protection();
        if (myProtection >=shot) {
            shieldPower-=SHIELDLOSSPERUNITSHOT*shot;
            shieldPower= (0.0f >= shieldPower) ? 0.0f : shieldPower;
            return ShotResult.RESIST;
        }
        else {
            shieldPower=0.0f;
            return ShotResult.DONOTRESIST;
        }
            
    }
    
    public Transformation setLoot(Loot loot){
        CardDealer dealer = CardDealer.getInstance();
        int h = loot.getNHangars();
        if (h>0) {
            Hangar hangar = dealer.nextHangar();
            receiveHangar(hangar);
        }
        int elements = loot.getNSupplies();
        
        for (int i = 0; i<elements; i++) {
            SuppliesPackage sup = dealer.nextSuppliesPackage();
            receiveSupplies(sup);
        }
        
        elements = loot.getNWeapons();
        
        for (int i = 0; i<elements; i++) {
            Weapon weap = dealer.nextWeapon();
            receiveWeapon(weap);
        }
        
        elements = loot.getNShields();
        
        for (int i = 0; i<elements; i++) {
            ShieldBooster sh = dealer.nextShieldBooster();
            receiveShieldBooster(sh);
        }
        
        nMedals+=loot.getNMedals();
        
        if (loot.spaceCity())
            return Transformation.SPACECITY;
        else if (loot.getEfficient())
            return Transformation.GETEFFICIENT;
        else
            return Transformation.NOTRANSFORM;
    }
    
    public void discardWeapon(int i){
        int size=weapons.size();
        if (i>=0 && i < size) {
            Weapon w = weapons.remove(i);
            if (pendingDamage!=null) {
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }
        }
            
    }
    
    public void discardShieldBooster(int i){
        int size=shieldBoosters.size();
        if (i>=0 && i < size) {
            shieldBoosters.remove(i);
            if (pendingDamage!=null) {
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }
        }
    }
    
    public float getAmmoPower(){return ammoPower;}
    public float getFuelUnits(){return fuelUnits;}
    public Hangar getHangar(){return hangar;}
    public String getName(){return name;}
    public int getNMedals(){return nMedals;}
    public Damage getPendingDamage(){return pendingDamage;}
    public ArrayList<ShieldBooster> getShieldBoosters(){return shieldBoosters;}
    public ArrayList<Weapon> getWeapons(){return weapons;}
    public float getShieldPower(){return shieldPower;}
    
    public SpaceStationToUI getUIversion(){
        
        return new SpaceStationToUI(this);
    }    
}
