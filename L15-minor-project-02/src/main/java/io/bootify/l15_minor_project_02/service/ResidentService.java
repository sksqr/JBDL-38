package io.bootify.l15_minor_project_02.service;

import io.bootify.l15_minor_project_02.domain.Flat;
import io.bootify.l15_minor_project_02.domain.User;
import io.bootify.l15_minor_project_02.domain.Visit;
import io.bootify.l15_minor_project_02.model.VisitDTO;
import io.bootify.l15_minor_project_02.model.VisitStatus;
import io.bootify.l15_minor_project_02.repos.UserRepository;
import io.bootify.l15_minor_project_02.repos.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitService visitService;



    public List<VisitDTO> findAllVisitsWithStatus(Long userId, VisitStatus visitStatus) {
        User user = userRepository.findById(userId).get();
        Flat flat = user.getFlat();
        List<Visit> visitList = visitRepository.findAllByFlatAndStatus(flat,visitStatus);
        return visitList
                .stream()
                .map(visit -> visitService.mapToDTO(visit, new VisitDTO()))
                .collect(Collectors.toList());
    }

}
