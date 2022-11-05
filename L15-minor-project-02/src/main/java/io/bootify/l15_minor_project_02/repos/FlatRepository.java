package io.bootify.l15_minor_project_02.repos;

import io.bootify.l15_minor_project_02.domain.Flat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlatRepository extends JpaRepository<Flat, Long> {
}
