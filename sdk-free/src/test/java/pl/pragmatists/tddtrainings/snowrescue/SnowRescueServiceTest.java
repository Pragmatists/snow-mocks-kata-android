package pl.pragmatists.tddtrainings.snowrescue;

import static org.mockito.Mockito.*;

import org.junit.Test;

import pl.pragmatists.tddtrainings.snowrescue.dependencies.MunicipalServices;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.PressService;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.WeatherForecastService;

public class SnowRescueServiceTest {

    private PressService pressService = mock(PressService.class);

    private WeatherForecastService weatherForecastService = mock(WeatherForecastService.class);

    private MunicipalServices municipalService = mock(MunicipalServices.class);

    private SnowRescueService snowRescueService = new SnowRescueService(weatherForecastService, municipalService, pressService);

    @Test
    public void shouldSendSanderWhenTemperatureBelowZero() {
    }

}
