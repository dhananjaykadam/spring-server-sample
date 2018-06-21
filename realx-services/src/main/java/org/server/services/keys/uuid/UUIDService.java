package org.server.services.keys.uuid;

import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * Random strings are generated using java UUID class
 * 
 * @author Administrator
 *
 */
@Service
public class UUIDService {
	public String getNewUUID() {
		return UUID.randomUUID().toString();
	}

	public String getNewUUIDNoDashes() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
