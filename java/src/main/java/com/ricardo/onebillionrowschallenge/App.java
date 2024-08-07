package com.ricardo.onebillionrowschallenge;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

final class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main() {
        long startTime = System.nanoTime();

        try {
            Map<String, TemperatureStats> results = Reader.run();
            Printer.run(results);
        } catch (IOException exception) {
            LOGGER.info(
                "An error ocurred while processing the file: " +
                exception.getMessage()
            );
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        LOGGER.info(STR."The program took \{duration / 1_000_000_000}s to run");
    }
}
