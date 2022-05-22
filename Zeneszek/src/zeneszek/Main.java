package zeneszek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author D8IE65
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        Concert penteki = readConcert();
        if (penteki == null) {
            penteki = createConcert();
            System.out.println("Létrehoztunk egy új koncertet!");
        } else {
            System.out.println("Beolvastuk a concertet az archívumból!");
        }
        System.out.println(penteki);
        penteki.saveToBinary();
        
        Performance performance = createPerformance();
        
        System.out.println(performance);
        
        writeConcert(penteki);
    }

    private static Concert createConcert() {
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
        
        return penteki;
    }
    
    private static Performance createPerformance() {
        Instrument ukulele = new Instrument(InstrumentType.Stringed);
        Musician byeAlex = new Musician("ByeAlex");
        byeAlex.addInstrument(ukulele);
        
        Performance macskak = new Performance(byeAlex);
        
        return macskak;
    }

    private static Concert readConcert() {
        try {
            FileInputStream f = new FileInputStream(new File("concert.txt"));
            ObjectInputStream o = new ObjectInputStream(f);
            
            Concert concert = (Concert) o.readObject();
            return concert;
        } catch (FileNotFoundException ex) {
            // no-op
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static void writeConcert(Concert concert) {
        try {
            FileOutputStream f = new FileOutputStream(new File("concert.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //write to file
            o.writeObject(concert);

            o.close();
            f.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
