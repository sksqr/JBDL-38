package io.bootify.l12_minor_project_01.repos;

import io.bootify.l12_minor_project_01.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
