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

class Loot {
    
    private int nSupplies;
    private int nWeapons;
    private int nShield;
    private int nHangars;
    private int nMedals;
    
    Loot(int supplies, int weapons, int shield, int hangars, int medals){
        
        this.nSupplies=supplies;
        this.nWeapons=weapons;
        this.nShield=shield;
        this.nHangars=hangars;
        this.nMedals=medals;
        
    }
    
    public int getNSupplies() { return this.nSupplies; }
    
    public int getNWeapons() { return this.nWeapons; }
    
    public int getNShields() { return this.nShield; }
    
    public int getNHangars() { return this.nHangars; }
    
    public int getNMedals() { return this.nMedals; }
    
    public String toString(){
        return ("NSupplies: " + getNSupplies() + "NWeapons: " + getNWeapons()
                + "NShield: " + getNShields() + "NHangars: " + getNHangars()
                + "NMedals: " + getNMedals());
    }
    
    LootToUI getUIversion(){return new LootToUI (this);}
    
}