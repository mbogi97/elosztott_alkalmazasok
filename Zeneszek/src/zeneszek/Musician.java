package zeneszek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author D8IE65
 *
 * Zenészek definiálása
 */
public class Musician implements Comparable<Musician> {

    // tud táncolni és/ vagy énekelni
    private boolean doesDance;
    private boolean doesSing;
    private String name;
    // hangszerek megadása amin tud játszani
    private Map<InstrumentType, Integer> instruments;

    public Musician(String name) {
        instruments = new HashMap<>();
        this.name = name;
    }

    public boolean doesDance() {
        return doesDance;
    }

    public void setDoesDance(boolean doesDance) {
        this.doesDance = doesDance;
    }

    public boolean doesSing() {
        return doesSing;
    }

    public void setDoesSing(boolean doesSing) {
        this.doesSing = doesSing;
    }

    public void addInstrument(Instrument instrument) {
        InstrumentType key = instrument.getInstrumentType();
        Integer value = instruments.get(key);
        if (value == null) {
            value = 0;
        }
        value++;
        instruments.put(key, value);
    }
    
    public int sumInstruments(){
        int sum = 0;
        for(Entry<InstrumentType, Integer> entry : instruments.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }

    @Override
    public int compareTo(Musician o) {
        return o.sumInstruments() - sumInstruments();
    }
    
    @Override
    public String toString(){
     //   return name;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(name)
                .append(" [");
        for(Entry<InstrumentType, Integer> entry : instruments.entrySet()){
            stringBuilder
                    .append(entry.getKey())
                    .append("-")
                    .append(entry.getValue())
                    .append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
