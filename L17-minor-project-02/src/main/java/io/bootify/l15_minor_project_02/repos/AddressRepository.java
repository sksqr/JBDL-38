package io.bootify.l15_minor_project_02.repos;

import io.bootify.l15_minor_project_02.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
