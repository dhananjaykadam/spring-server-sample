package org.server.services.address;

import java.util.List;

import org.server.core.entities.address.Area;
import org.server.core.repositories.address.AreaRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService extends DefaultJpaServiceImpl<Area, Long, AreaRepository> implements JpaService<Area, Long> {
	@Autowired
	private AreaRepository areaRepository;

	public List<Area> findAllAreas() {
		return getAreaRepository().findAll();
	}

	public AreaRepository getAreaRepository() {
		return areaRepository;
	}

	public void setAreaRepository(AreaRepository areaRepository) {
		this.areaRepository = areaRepository;
	}

}
