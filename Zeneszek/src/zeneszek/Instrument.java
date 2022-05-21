package zeneszek;

/**
 * @author D8IE65 Itt adom meg a hanszereket
 */
public class Instrument {

    private InstrumentType instrumentType;

    public Instrument(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }
}
