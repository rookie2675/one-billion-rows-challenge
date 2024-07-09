import java.util.Map;
import java.util.logging.Logger;

final class Printer {

    private static final Logger LOGGER = Logger.getLogger(Printer.class.getName());

    static void run(Map<String, TemperatureStats> stations) {
        StringBuilder stringBuilder = new StringBuilder(1000);
        for (Map.Entry<String, TemperatureStats> entry : stations.entrySet()) {
            String station = entry.getKey();
            var temperatureStats = entry.getValue();
            stringBuilder
                    .append(STR."\{station}: ")
                    .append(temperatureStats);
        }
        LOGGER.info(stringBuilder.toString());
    }
}
