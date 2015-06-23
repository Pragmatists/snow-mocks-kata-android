package pl.pragmatists.tddtraining.snowrescue.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import pl.pragmatists.tddtrainings.snowrescue.SnowRescueService;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.MunicipalServices;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.PressService;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.SnowplowMalfunctioningException;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.WeatherForecastService;

public class RescueActivity extends Activity {

    private WeatherForecastService weatherForecastService = new LoggingForecastService(new RandomWeatherService());
    private MunicipalServices municipalServices = new LoggingMunicipalServices(new WebMunicipalServices());
    private PressService pressService = new LoggingPressService();
    private TextView temperatureText;
    private TextView snowFallText;
    private TextView pressAlertText;
    private TextView yourActionsText;
    private final SnowRescueService snowRescueService = new SnowRescueService(weatherForecastService, municipalServices, pressService);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue);

        Button actionButton = (Button) findViewById(R.id.actionButton);
        temperatureText = (TextView) findViewById(R.id.temperatureText);
        snowFallText = (TextView) findViewById(R.id.snowFallText);
        pressAlertText = (TextView) findViewById(R.id.pressAlertText);
        yourActionsText = (TextView) findViewById(R.id.yourActionsText);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear(pressAlertText);
                clear(yourActionsText);
                snowRescueService.checkForecastAndRescue();
            }
        });
    }

    private void clear(TextView textView) {
        textView.setText("");
    }

    private class LoggingMunicipalServices implements MunicipalServices {
        private final MunicipalServices delegate;

        public LoggingMunicipalServices(MunicipalServices delegate) {
            this.delegate = delegate;
        }

        @Override
        public void sendSnowplow() throws SnowplowMalfunctioningException {
            yourActionsText.append("Send a snowplow\n");
            delegate.sendSnowplow();
        }

        @Override
        public void sendSander() {
            yourActionsText.append("Send a sander\n");
            delegate.sendSander();
        }
    }

    private class LoggingForecastService implements WeatherForecastService {
        private final WeatherForecastService delegate;

        public LoggingForecastService(WeatherForecastService delegate) {
            this.delegate = delegate;
        }

        @Override
        public int getSnowFallHeightInMM() {
            int snowFallHeightInMM = delegate.getSnowFallHeightInMM();
            snowFallText.setText(snowFallHeightInMM + " mm");
            return snowFallHeightInMM;
        }

        @Override
        public int getAverageTemperatureInCelsius() {
            int averageTemperatureInCelsius = delegate.getAverageTemperatureInCelsius();
            temperatureText.setText(averageTemperatureInCelsius + " °C");
            return averageTemperatureInCelsius;
        }
    }

    private class LoggingPressService implements PressService {
        @Override
        public void sendWeatherAlert() {
            pressAlertText.setText("Press alert sent!");
        }
    }
}
