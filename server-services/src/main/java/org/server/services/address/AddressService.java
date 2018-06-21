package org.server.services.address;

import java.util.List;

import org.server.core.entities.address.Address;
import org.server.core.repositories.address.AddressRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends DefaultJpaServiceImpl<Address, Long, AddressRepository>
		implements JpaService<Address, Long> {
	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findAll() {
		return getAddressRepository().findAll();
	}

	public AddressRepository getAddressRepository() {
		return addressRepository;
	}

	public void setAddressRepository(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

}
