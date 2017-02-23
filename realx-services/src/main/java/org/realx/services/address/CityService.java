package org.realx.services.address;

import java.util.List;

import org.realx.core.entities.address.City;
import org.realx.core.repositories.address.CityRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends DefaultJpaServiceImpl<City, Long, CityRepository> implements JpaService<City, Long> {
	@Autowired
	private CityRepository cityRepository;

	public List<City> findAll() {
		return getCityRepository().findAll();
	}

	public CityRepository getCityRepository() {
		return cityRepository;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

}
