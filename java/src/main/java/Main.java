import java.util.Map;
import java.util.logging.Logger;

final class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main() {
        long startTime = System.nanoTime();
        Map<String, TemperatureStats> results = Reader.run();
        Printer.run(results);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        LOGGER.info(STR."The program took \{duration / 1_000_000_000}s to run");
    }
}
