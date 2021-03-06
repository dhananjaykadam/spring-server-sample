package org.server.core.entities.notifications.fcm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FCMResponse {
	private String multicast_id;
	private String success;
	private String failure;
	private String canonical_ids;

	public String getMulticast_id() {
		return multicast_id;
	}

	public void setMulticast_id(String multicast_id) {
		this.multicast_id = multicast_id;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFailure() {
		return failure;
	}

	public void setFailure(String failure) {
		this.failure = failure;
	}

	public String getCanonical_ids() {
		return canonical_ids;
	}

	public void setCanonical_ids(String canonical_ids) {
		this.canonical_ids = canonical_ids;
	}

}
