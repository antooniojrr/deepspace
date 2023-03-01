/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author antoniojrr
 */
public class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;
    
    
    public ShieldBooster( String name, float boost, int uses) {
        
        this.name=name;
        this.boost=boost;
        this.uses=uses;
        
    }
    
    public ShieldBooster( ShieldBooster s) {
        
        this.name=s.getName();
        this.boost=s.getBoost();
        this.uses=s.getUses();
        
    }
    
    public String getName() { return this.name; }
    
    public float getBoost() { return this.boost; }
    
    public int getUses() { return this.uses; }
    
    public float useIt() {
        if ( getUses() > 0) {
            this.uses--;
            return getBoost();
        }
        
        else return (float) 1.0;
    }
    
}
