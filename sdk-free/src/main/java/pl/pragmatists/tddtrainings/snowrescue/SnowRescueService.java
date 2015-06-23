package pl.pragmatists.tddtrainings.snowrescue;

import pl.pragmatists.tddtrainings.snowrescue.dependencies.MunicipalServices;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.PressService;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.WeatherForecastService;

public class SnowRescueService {

    private final WeatherForecastService weatherForecastService;

    private final MunicipalServices municipalServices;

    private final PressService pressService;

    public SnowRescueService(WeatherForecastService weatherForecastService, MunicipalServices municipalServices,
                             PressService pressService) {
        this.weatherForecastService = weatherForecastService;
        this.municipalServices = municipalServices;
        this.pressService = pressService;
    }

    public void checkForecastAndRescue() {

    }

}
