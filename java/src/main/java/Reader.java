import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

@SuppressWarnings("preview")
public class Reader {

    private static final Logger LOGGER = Logger.getLogger(Reader.class.getName());

    public static void run() {

        long counter = 0;
        int max = 50_000_000;
        long startTime = System.nanoTime();
        Collection<String> lines = new ArrayList<>();

        try (FileReader fileReader = new FileReader("measurements.txt"); BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null && max > counter) {
                lines.add(line);
                counter++;
            }

        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        LOGGER.info(STR."It took \{duration}ms to retrieve all \{lines.size()} document lines");
    }
}
