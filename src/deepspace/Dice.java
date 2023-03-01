


package deepspace;

import java.util.Random;

/**
 *
 * @author antoniojrr
 * @author kessler
 */
public class Dice {
    
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    
    private Random generator;
    
    public Dice() {
        
        NHANGARSPROB=(float) 0.25;
        NSHIELDSPROB=(float) 0.25;
        NWEAPONSPROB=(float) 0.33;
        FIRSTSHOTPROB=(float) 0.5;
        
        // Inicializar generator ?
        // generator.doubles();
        
    }
    
    public int initWithNHangars() {
        
        int result=1;
        if (generator.nextDouble() <= (double)NHANGARSPROB)
            result=0;
        
        return result;
        
    }
    
    public int initWithNWeapons() {
        
        int result;
        double prob = generator.nextDouble();
        
        if ( prob <= (double)NWEAPONSPROB)
            result=1;
        
        else if ( prob <= (double)(2*NWEAPONSPROB))
            result=2;
        
        else
            result=3;
        
        return result;
    }
    
    public int initWithNShields() {
        
        int result=0;
        if (generator.nextDouble() <= (double)NSHIELDSPROB)
            result=1;
        
        return result;
        
    }
    
    public int whoStarts(int nPlayers) {
        
        double num = generator.nextDouble();
        
        // Trunca
        return (int)(num*nPlayers);
        
    }
    
    public GameCharacter firstShot() {
        
        GameCharacter result= GameCharacter.ENEMYSTARSHIP;
        
        if ( generator.nextDouble() <= FIRSTSHOTPROB)
            result = GameCharacter.SPACESTATION;
        
        return result;
        
    }
    
    public boolean spaceStationMoves(float speed) {
        
        return (generator.nextDouble() <= speed);
        
    }
    
    
    
    
    
}
