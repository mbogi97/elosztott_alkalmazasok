package zeneszek;

/**
 * @author D8IE65
 */
public class Main {

    public static void main(String[] args) {
        Instrument flute = new Instrument(InstrumentType.Brass);
        Instrument violin = new Instrument(InstrumentType.Stringed);
        Instrument guitar = new Instrument(InstrumentType.Stringed);
        Instrument ukulele = new Instrument(InstrumentType.Stringed);   

        Musician byeAlex = new Musician("ByeAlex");
        Musician tothAndi = new Musician("Tóth Andi");
        Musician kurtCobain = new Musician("Kurt Cobain");

        byeAlex.addInstrument(flute);
        byeAlex.setDoesDance(true);
        byeAlex.setDoesSing(true);

        tothAndi.addInstrument(violin);
        tothAndi.addInstrument(flute);
        
        kurtCobain.addInstrument(violin);
        kurtCobain.addInstrument(guitar);
        kurtCobain.addInstrument(ukulele);

        Concert penteki = new Concert();

        penteki.addMusician(byeAlex);
        penteki.addMusician(tothAndi);
        penteki.addMusician(kurtCobain);

        System.out.println(penteki);
        penteki.saveToBinary();
        
        Performance macskak = new Performance(byeAlex);
        System.out.println(macskak);
        
    }

}
