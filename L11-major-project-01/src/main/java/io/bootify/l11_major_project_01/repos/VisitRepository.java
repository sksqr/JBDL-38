package io.bootify.l11_major_project_01.repos;

import io.bootify.l11_major_project_01.domain.Flat;
import io.bootify.l11_major_project_01.domain.Visit;
import io.bootify.l11_major_project_01.model.VisitStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findAllByFlatAndStatus(Flat flat, VisitStatus status);
}
