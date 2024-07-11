package com.ricardo.onebillionrowschallenge;

final class TemperatureStats {

    private double temperaturesSum;
    private int temperaturesCount;
    private double min;
    private double max;

    TemperatureStats(
        double temperaturesSum,
        int temperaturesCount,
        double min,
        double max
    ) {
        this.temperaturesSum = temperaturesSum;
        this.temperaturesCount = temperaturesCount;
        this.min = min;
        this.max = max;
    }

    void addTemperature(double temperature) {
        temperaturesSum += temperature;
        temperaturesCount++;

        if (temperature < min) {
            min = temperature;
        } else if (temperature > max) {
            max = temperature;
        }
    }

    private double getAverageTemperature() {
        return temperaturesSum / temperaturesCount;
    }

    @Override
    public String toString() {
        return (
            STR."\{getAverageTemperature()}º; " +
            STR."\{min}º; " +
            STR."\{max}º"
        );
    }
}
