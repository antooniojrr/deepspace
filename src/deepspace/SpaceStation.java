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
    private Damage pendingDamage = null;
    private Hangar hangar = null;
    private ArrayList<Weapon> weapons = null;
    private ArrayList<ShieldBooster> shieldBoosters = null;    
    
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
            weapons.add(hangar.removeWeapon(i));
        }
    }
    
    public void mountShieldBooster(int i){
        if (hangar != null){
            shieldBoosters.add(hangar.removeShieldBooster(i));
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
        throw new UnsupportedOperationException();
    }
    
    public float protection(){
        throw new UnsupportedOperationException();
    }
    
    public ShotResult receiveShot(float shoot){
        throw new UnsupportedOperationException();
    }
    
    public void setLoot(Loot loot){
        throw new UnsupportedOperationException();
    }
    
    public void discardWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public float getAmmoPower(){return ammoPower;}
    public float getFuelUnits(){return fuelUnits;}
    public Hangar getHangar(){return hangar;}
    public String getname(){return name;}
    public int getNMedals(){return nMedals;}
    public Damage getPendingDamage(){return pendingDamage;}
    public ArrayList<ShieldBooster> getShieldBoosters(){return shieldBoosters;}
    public ArrayList<Weapon> getWeapons(){return weapons;}
    public float getShieldPower(){return shieldPower;}
    public SpaceStationToUI getUIversion(){return new SpaceStationToUI(this);}    
}
