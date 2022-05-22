package zeneszek;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author D8IE65
 */
public class Concert implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Musician> musicians;

    public Concert() {
        musicians = new ArrayList<>();
    }

    public void addMusician(Musician musician) {
        musicians.add(musician);
    }

    public void saveToBinary() {
        Path path = Paths.get("doc.bin");
        byte[] bytes = toString().getBytes();

        try {
            Files.write(path, bytes);    // Java 7+ only
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
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
