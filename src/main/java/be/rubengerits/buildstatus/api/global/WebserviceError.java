package be.rubengerits.buildstatus.api.global;

public interface WebserviceError {
	Integer getStatus();

	void setStatus(Integer status);

	String getMessage();

	void setMessage(String message);
}
