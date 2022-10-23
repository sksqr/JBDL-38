package io.bootify.l12_minor_project_01.repos;

import io.bootify.l12_minor_project_01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
