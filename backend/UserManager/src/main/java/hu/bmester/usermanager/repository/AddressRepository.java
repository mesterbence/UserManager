package hu.bmester.usermanager.repository;

import hu.bmester.usermanager.model.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
