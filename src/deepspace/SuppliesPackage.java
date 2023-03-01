/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author antoniojrr
 */
public class SuppliesPackage {
    
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    public SuppliesPackage(float ammoPower, float fuelUnits, float shieldPower) {
        
        this.ammoPower=ammoPower;
        this.fuelUnits=fuelUnits;
        this.shieldPower=shieldPower;
        
    }
    
    public SuppliesPackage(SuppliesPackage s) {
        
        this.ammoPower=s.getAmmoPower();
        this.fuelUnits=s.getFuelUnits();
        this.shieldPower=s.getShieldPower();
        
    }
    
    public float getAmmoPower() { return this.ammoPower; }
    
    public float getFuelUnits() { return this.fuelUnits; }
    
    public float getShieldPower() {return this.shieldPower; }
    
    
}
