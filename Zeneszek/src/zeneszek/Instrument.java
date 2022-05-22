package zeneszek;

import java.io.Serializable;

/**
 * @author D8IE65 Itt adom meg a hanszereket
 */
public class Instrument implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private InstrumentType instrumentType;

    public Instrument(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }
}
