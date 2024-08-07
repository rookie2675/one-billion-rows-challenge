package com.ricardo.onebillionrowschallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

final class Reader {

    private static final Logger LOGGER = Logger.getLogger(
        Reader.class.getName()
    );

    private static final int MAX_STATIONS_COUNT = 413;

    public static Map<String, TemperatureStats> run() throws IOException {
        Map<String, TemperatureStats> values = new HashMap<>(
            MAX_STATIONS_COUNT
        );

        FileReader fileReader = new FileReader(
            "measurements.txt",
            StandardCharsets.UTF_8
        );

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        LOGGER.info("Reading the file...");

        bufferedReader
            .lines()
            .parallel()
            .map(line -> line.split(";"))
            .forEach(splitLine -> {
                String station = splitLine[0];
                double temperature = Double.parseDouble(splitLine[1]);

                if (values.containsKey(station)) {
                    var temperatureStats = values.get(station);
                    temperatureStats.addTemperature(temperature);
                } else {
                    values.put(
                        station,
                        new TemperatureStats(
                            temperature,
                            1,
                            temperature,
                            temperature
                        )
                    );
                }
            });
        return values;
    }
}
