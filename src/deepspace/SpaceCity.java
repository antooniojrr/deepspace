/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author antoniojrr
 */
public class SpaceCity extends SpaceStation {
    
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;
    
    public SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest) {
        super(base);
        this.base=base;
        this.collaborators = rest;
    }
    
    public ArrayList<SpaceStation> getCollaborators() { return collaborators; }
    
    public float fire() {
        float dam = this.fire();
        for (SpaceStation station : this.getCollaborators())
            dam += station.fire();
        return dam;
     
    }
    
    public float protection() {
        float prot = this.protection();
        for (SpaceStation station : this.getCollaborators())
            prot += station.protection();
        return prot;
        
    }
    
    public Transformation setLoot(Loot loot) {
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
    }
    
    
}
