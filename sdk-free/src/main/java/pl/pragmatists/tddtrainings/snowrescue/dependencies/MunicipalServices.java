package pl.pragmatists.tddtrainings.snowrescue.dependencies;


public interface MunicipalServices {
	void sendSnowplow() throws SnowplowMalfunctioningException;

	void sendSander();
}
