/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author antoniojrr
 * @author kessler
 */

public class Weapon {
    
    private String name;
    private WeaponType type;
    private int uses;
    
    public Weapon( String name, WeaponType type, int uses) {
        
        this.name = name;
        this.type = type;
        this.uses = uses;
        
    }
    
    public Weapon ( Weapon w) {
        
        this.name = name;
        this.type = type;
        this.uses = uses;
        
    }
    
    public WeaponType getType() { return this.type; }
    public int getUses() { return this.uses; }
    
    public String getName() { return this.getName(); }
    
    public float power() { return getType().getPower(); }
    
    public float useIt() {
        
        if ( getUses() > 0) {
            
            this.uses--;
            return power();
            
        }
        
        else return (float) 1.0;
    }
    
    
}
