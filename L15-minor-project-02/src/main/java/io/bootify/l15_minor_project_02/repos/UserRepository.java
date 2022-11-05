package io.bootify.l15_minor_project_02.repos;

import io.bootify.l15_minor_project_02.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
