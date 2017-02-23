package org.realx.services.notifications.push;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.realx.core.entities.notifications.PushNotification;
import org.realx.core.entities.notifications.fcm.FCMNotification;
import org.realx.core.entities.notifications.fcm.FCMResponse;
import org.realx.services.resttemplate.SpringRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class FCMNotificationService {

	@Resource
	private Environment environment;
	@Autowired
	private SpringRestTemplate restTemplate;

	public SpringRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(SpringRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public PushNotification sendPushNotification(PushNotification pushNotification) {
		return null;
	}

	public PushNotification sendIndividualPushNotification(PushNotification pushNotification) {
		return null;
	}

	public PushNotification sendGroupPushNotification(PushNotification pushNotification) {
		return null;
	}

	@Async
	public void sendOrderPlacedPushNotification(FCMNotification fcmNotification) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.put("Authorization", "key=" + getEnvironment().getProperty("fcm.secret.key"));
		String url = getEnvironment().getProperty("fcm.notification.send.api");
		ResponseEntity<FCMResponse> responseEntity = getRestTemplate().post(url, headers, fcmNotification,
				FCMResponse.class);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			responseEntity.getBody();
		}
	}
	
	public ResponseEntity<FCMResponse> sendNotificationToTopics(FCMNotification fcmNotification){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.put("Authorization", "key=" + getEnvironment().getProperty("fcm.secret.key"));
		String url = getEnvironment().getProperty("fcm.notification.send.api");
		ResponseEntity<FCMResponse> responseEntity = getRestTemplate().post(url, headers, fcmNotification,
				FCMResponse.class);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			responseEntity.getBody();
		}
		return responseEntity;
	}
}
