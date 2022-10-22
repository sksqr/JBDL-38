package io.bootify.l11_major_project_01.repos;

import io.bootify.l11_major_project_01.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
