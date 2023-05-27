/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author david
 */
public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation{
    private final static float EXTRAEFFICIENCY = 1.2f;
    private Dice dice; 
    
    public BetaPowerEfficientSpaceStation(SpaceStation station){
        super(station);
        dice = new Dice();
    }
    
    @Override
    public float fire(){
        float factor = 1.0f; 
        if (dice.extraEfficiency())
            factor = EXTRAEFFICIENCY;
        return (super.fire()*factor);
    }
}
