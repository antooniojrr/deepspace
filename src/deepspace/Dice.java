


package deepspace;

import java.util.Random;

/**
 *
 * @author antoniojrr
 * @author kessler
 */
class Dice {
    
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    private final static float EXTRAEFFICIENCYPROB = 0.8f;
    
    private Random generator;
    
    Dice() {
        
        NHANGARSPROB= 0.25f;
        NSHIELDSPROB= 0.25f;
        NWEAPONSPROB= 0.33f;
        FIRSTSHOTPROB= 0.5f;
        generator = new Random();
    }
    
    public int initWithNHangars() {
        
        int result=1;
        if (generator.nextFloat() <= NHANGARSPROB)
            result=0;
        
        return result;
        
    }
    
    public int initWithNWeapons() {
        
        int result;
        double prob = generator.nextFloat();
        
        if ( prob <= NWEAPONSPROB)
            result=1;
        
        else if ( prob <= (2*NWEAPONSPROB))
            result=2;
        
        else
            result=3;
        
        return result;
    }
    
    public int initWithNShields() {
        
        int result=0;
        if (generator.nextFloat() <= NSHIELDSPROB)
            result=1;
        
        return result;
        
    }
    
    public int whoStarts(int nPlayers) {        
                
        return generator.nextInt(nPlayers);
        
    }
    
    public GameCharacter firstShot() {
        
        GameCharacter result= GameCharacter.ENEMYSTARSHIP;
        
        if ( generator.nextFloat() <= FIRSTSHOTPROB)
            result = GameCharacter.SPACESTATION;
        
        return result;
        
    }
    
    public boolean spaceStationMoves(float speed) {
        
        return (generator.nextDouble() <= speed);
        
    }
    
    public boolean extraEfficiency(){
        return (generator.nextFloat() <= EXTRAEFFICIENCYPROB);
    }
    
}