package io.bootify.l15_minor_project_02.repos;

import io.bootify.l15_minor_project_02.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
