package io.bootify.l11_major_project_01.service;

import io.bootify.l11_major_project_01.domain.Flat;
import io.bootify.l11_major_project_01.domain.Visit;
import io.bootify.l11_major_project_01.domain.Visitor;
import io.bootify.l11_major_project_01.model.VisitDTO;
import io.bootify.l11_major_project_01.model.VisitStatus;
import io.bootify.l11_major_project_01.repos.FlatRepository;
import io.bootify.l11_major_project_01.repos.VisitRepository;
import io.bootify.l11_major_project_01.repos.VisitorRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final VisitorRepository visitorRepository;
    private final FlatRepository flatRepository;

    public VisitService(final VisitRepository visitRepository,
            final VisitorRepository visitorRepository, final FlatRepository flatRepository) {
        this.visitRepository = visitRepository;
        this.visitorRepository = visitorRepository;
        this.flatRepository = flatRepository;
    }

    public List<VisitDTO> findAll() {
        return visitRepository.findAll(Sort.by("id"))
                .stream()
                .map(visit -> mapToDTO(visit, new VisitDTO()))
                .collect(Collectors.toList());
    }

    public VisitDTO get(final Long id) {
        return visitRepository.findById(id)
                .map(visit -> mapToDTO(visit, new VisitDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final VisitDTO visitDTO) {
        final Visit visit = new Visit();
        mapToEntity(visitDTO, visit);
        return visitRepository.save(visit).getId();
    }

    public void update(final Long id, final VisitDTO visitDTO) {
        final Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(visitDTO, visit);
        visitRepository.save(visit);
    }

    public void updateStatus(final Long id, final VisitStatus visitStatus) {
        final Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        visit.setStatus(visitStatus);
        visitRepository.save(visit);
    }

    public void delete(final Long id) {
        visitRepository.deleteById(id);
    }

    public VisitDTO mapToDTO(final Visit visit, final VisitDTO visitDTO) {
        visitDTO.setId(visit.getId());
        visitDTO.setStatus(visit.getStatus());
        visitDTO.setInTime(visit.getInTime());
        visitDTO.setOutTime(visit.getOutTime());
        visitDTO.setPurpose(visit.getPurpose());
        visitDTO.setImageUrl(visit.getImageUrl());
        visitDTO.setNoOfPeople(visit.getNoOfPeople());
        visitDTO.setVisitor(visit.getVisitor() == null ? null : visit.getVisitor().getId());
        visitDTO.setFlat(visit.getFlat() == null ? null : visit.getFlat().getId());
        return visitDTO;
    }

    public Visit mapToEntity(final VisitDTO visitDTO, final Visit visit) {
        visit.setStatus(visitDTO.getStatus());
        visit.setInTime(visitDTO.getInTime());
        visit.setOutTime(visitDTO.getOutTime());
        visit.setPurpose(visitDTO.getPurpose());
        visit.setImageUrl(visitDTO.getImageUrl());
        visit.setNoOfPeople(visitDTO.getNoOfPeople());
        final Visitor visitor = visitDTO.getVisitor() == null ? null : visitorRepository.findById(visitDTO.getVisitor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "visitor not found"));
        visit.setVisitor(visitor);
        final Flat flat = visitDTO.getFlat() == null ? null : flatRepository.findById(visitDTO.getFlat())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "flat not found"));
        visit.setFlat(flat);
        return visit;
    }



}
