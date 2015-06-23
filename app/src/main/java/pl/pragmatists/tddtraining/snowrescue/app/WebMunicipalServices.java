package pl.pragmatists.tddtraining.snowrescue.app;

import pl.pragmatists.tddtrainings.snowrescue.dependencies.MunicipalServices;
import pl.pragmatists.tddtrainings.snowrescue.dependencies.SnowplowMalfunctioningException;

public class WebMunicipalServices implements MunicipalServices{
    @Override
    public void sendSnowplow() throws SnowplowMalfunctioningException {
        // http://api.city.pl/municipalService/sendSnowplow
    }

    @Override
    public void sendSander() {

    }
}
