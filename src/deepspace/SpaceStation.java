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
    }
    
    public void cleanUpMountedItems(){
        
    }
    
    
    
}
