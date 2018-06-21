package org.server.rest.resources.address;

import java.util.List;

import org.server.core.dtos.common.Entry;
import org.server.core.entities.address.Area;
import org.server.core.entities.address.City;
import org.server.services.address.AddressService;
import org.server.services.address.AreaService;
import org.server.services.address.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressResource {

	@Autowired
	private AddressService addressService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "city/all", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<City>>> getListOfCities() {
		Entry<List<City>> entry = new Entry<>();
		List<City> cities = getCityService().findAll();
		entry.setEntry(cities);
		return ResponseEntity.ok().body(entry);
	}

	@RequestMapping(value = "area/all", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<Area>>> getListOfArea() {
		Entry<List<Area>> entry = new Entry<>();
		List<Area> cities = getAreaService().findAllAreas();
		entry.setEntry(cities);
		return ResponseEntity.ok().body(entry);
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

}
