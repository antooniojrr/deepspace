/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author Profe
 */
public class ShieldToUI {
    private float boost;
    private int uses;
    private String name;

    ShieldToUI (ShieldBooster s) {
        boost=s.getBoost();
        uses=s.getUses();
        name = s.getName();
        
    }    

    public float getBoost() {
        return boost;
    }

    public int getUses() {
        return uses;
    }
    
    
}
