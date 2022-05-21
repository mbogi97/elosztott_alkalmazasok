package zeneszek;

/**
 *
 * @author D8IE65
 */
public class Performance {
    private Musician musician;
    
    public Performance(Musician musician){
        this.musician = musician;
    }
    
    @Override
    public String toString(){
        
        return "Performance: " + musician.toString();
    }
}
