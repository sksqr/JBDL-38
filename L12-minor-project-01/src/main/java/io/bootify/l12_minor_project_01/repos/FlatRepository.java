package io.bootify.l12_minor_project_01.repos;

import io.bootify.l12_minor_project_01.domain.Flat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlatRepository extends JpaRepository<Flat, Long> {
}
