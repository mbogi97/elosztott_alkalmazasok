package zeneszek;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author D8IE65
 */
public class Concert {
    private List<Musician> musicians;
    
    public Concert() {
        musicians = new ArrayList<>();
    }
    
    public void addMusician(Musician musician){
        musicians.add(musician);
    }
    
    public void saveToBinary() {
        Path path = Paths.get("doc.txt");
        byte[] bytes = toString().getBytes(StandardCharsets.UTF_8);
 
        try {
            Files.write(path, bytes);    // Java 7+ only
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        Collections.sort(musicians);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Concert: ");
        for (Musician musician : musicians) {
            stringBuilder
                    .append(musician.toString())
                    .append(" ");
        }
        return stringBuilder.toString();
    }
    
}
