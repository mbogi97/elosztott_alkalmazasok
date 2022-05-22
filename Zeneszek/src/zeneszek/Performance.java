package zeneszek;

import java.io.Serializable;

/**
 *
 * @author D8IE65
 */
public class Performance implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    
    private Musician musician;
    
    public Performance(Musician musician){
        this.musician = musician;
    }
    
    @Override
    public String toString(){
        
        return "Performance: " + musician.toString();
    }
}
