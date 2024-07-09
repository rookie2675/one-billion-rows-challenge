import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Reader {

    private static final int MAX_STATIONS_COUNT = 413;

    public static Map<String, TemperatureStats> run() {

        Map<String, TemperatureStats> values = new HashMap<>(MAX_STATIONS_COUNT);

        try (FileReader fileReader = new FileReader("measurements.txt", StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            bufferedReader.lines()
                    .parallel()
                    .map(line -> line.split(";"))
                    .forEach(splitLine -> {

                        String station = splitLine[0];
                        double temperature = Double.parseDouble(splitLine[1]);

                        if (values.containsKey(station)) {

                            var temperatureStats = values.get(station);
                            temperatureStats.addTemperature(temperature);

                        } else {
                            values.put(station, new TemperatureStats(temperature, 1, temperature, temperature));
                        }
                    });

        } catch (IOException exception) {
            exception.getStackTrace();
        }

        return values;
    }
}
