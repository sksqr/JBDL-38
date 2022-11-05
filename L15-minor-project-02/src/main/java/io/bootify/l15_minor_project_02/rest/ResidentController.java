package io.bootify.l15_minor_project_02.rest;


import io.bootify.l15_minor_project_02.domain.User;
import io.bootify.l15_minor_project_02.model.VisitDTO;
import io.bootify.l15_minor_project_02.model.VisitStatus;
import io.bootify.l15_minor_project_02.service.ResidentService;
import io.bootify.l15_minor_project_02.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/resident", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResidentController {


    @Autowired
    private ResidentService residentService;


    @Autowired
    private VisitService visitService;


    @PutMapping("/visit/{id}/{status}")
    public ResponseEntity<Void> updateVisit(@PathVariable final Long id, @PathVariable VisitStatus status) {
        visitService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/visits/{status}")
    public ResponseEntity<List<VisitDTO>> getVisitsByStatus(@PathVariable VisitStatus status) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = user.getId();
        return ResponseEntity.ok(residentService.findAllVisitsWithStatus(userId,status));
    }



}
