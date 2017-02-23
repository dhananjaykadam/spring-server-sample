package org.realx.services.devices;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.realx.core.entities.devices.MobileDevice;
import org.realx.core.entities.notifications.fcm.FCMResponse;
import org.realx.core.entities.user.User;
import org.realx.core.repositories.devices.MobileDeviceRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.realx.services.resttemplate.SpringRestTemplate;
import org.realx.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class MobileDeviceService extends DefaultJpaServiceImpl<MobileDevice, Long, MobileDeviceRepository>
		implements JpaService<MobileDevice, Long> {
	@Autowired
	private MobileDeviceRepository mobileDeviceRepository;
	@Autowired
	private UserService userService;
	@Resource
	private Environment environment;
	@Autowired
	private SpringRestTemplate restTemplate;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MobileDeviceRepository getMobileDeviceRepository() {
		return mobileDeviceRepository;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public SpringRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(SpringRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setMobileDeviceRepository(MobileDeviceRepository mobileDeviceRepository) {
		this.mobileDeviceRepository = mobileDeviceRepository;
	}

	public void removeOldMobileDetail(User user, Date deleteDate) {
		getMobileDeviceRepository().removeOldMobileDetail(user, deleteDate);
	}

	public List<MobileDevice> getActiveDeviceIdForUser(User user) {
		return getMobileDeviceRepository().getActiveDeviceIdForUser(user);
	}

	public MobileDevice addNewMobileDeviceForCurrentUser(MobileDevice mobileDevice) {
		Date deleteDate = new Date();
		User user = getUserService().getLoggedInUser();
		removeOldMobileDetail(user, deleteDate);
		mobileDevice.setUser(user);
		mobileDevice = create(mobileDevice);
		
		return mobileDevice;
	}
	
	public void topicsSubscriptionForNewMobileDeviceForCurrentUser(MobileDevice mobileDevice){
		Map<String, String> headers = new HashMap<String, String>();  
		headers.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.put("Content-Length", "0");
		headers.put("Authorization", "key=" + getEnvironment().getProperty("fcm.secret.key"));
		String IID_TOKEN = mobileDevice.getPushRegistrationId();
		String TOPIC_NAME = getEnvironment().getProperty("fcm.notification.topics.name");
		String SUBPATH=getEnvironment().getProperty("fcm.notification.topics.subscription.api.subPath");
		String url = getEnvironment().getProperty("fcm.notification.topics.subscription.api")+ IID_TOKEN +SUBPATH +TOPIC_NAME;
		ResponseEntity<FCMResponse> responseEntity = getRestTemplate().post(url, headers, null,
				FCMResponse.class);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			responseEntity.getBody();
		}
	
	}

	public List<MobileDevice> findByUser(User user) {
		return getMobileDeviceRepository().findByUser(user);
	}
}
