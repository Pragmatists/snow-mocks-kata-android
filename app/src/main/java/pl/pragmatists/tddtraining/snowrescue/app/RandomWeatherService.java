package pl.pragmatists.tddtraining.snowrescue.app;

import java.util.Random;

import pl.pragmatists.tddtrainings.snowrescue.dependencies.WeatherForecastService;

public class RandomWeatherService implements WeatherForecastService {

    public static final int FORECAST_REFRESH_INTERVAL = 2000;

    private long lastSnowQueryTime;

    private int lastSnowFall;

    private int lastTemperature;

    private long lastTemperatureQueryTime;

    @Override
    public int getSnowFallHeightInMM() {
        if (shouldRefreshSnowForecast()) {
            lastSnowQueryTime = System.currentTimeMillis();
            lastSnowFall = new Random().nextInt(20);
        }
        return lastSnowFall;
    }

    @Override
    public int getAverageTemperatureInCelsius() {
        if (shouldRefreshTemperatureForecast()) {
            lastTemperatureQueryTime = System.currentTimeMillis();
            lastTemperature = new Random().nextInt(30) - 20;
        }
        return lastTemperature;
    }

    private boolean shouldRefreshTemperatureForecast() {
        return System.currentTimeMillis() > lastTemperatureQueryTime + FORECAST_REFRESH_INTERVAL;
    }

    private boolean shouldRefreshSnowForecast() {
        return System.currentTimeMillis() > lastSnowQueryTime + FORECAST_REFRESH_INTERVAL;
    }
}
