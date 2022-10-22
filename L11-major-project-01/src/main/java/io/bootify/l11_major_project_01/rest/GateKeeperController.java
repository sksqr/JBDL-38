package io.bootify.l11_major_project_01.rest;


import io.bootify.l11_major_project_01.model.VisitDTO;
import io.bootify.l11_major_project_01.model.VisitStatus;
import io.bootify.l11_major_project_01.model.VisitorDTO;
import io.bootify.l11_major_project_01.service.VisitService;
import io.bootify.l11_major_project_01.service.VisitorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/gatekeeper", produces = MediaType.APPLICATION_JSON_VALUE)
public class GateKeeperController {

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private VisitService visitService;


    @PostMapping("/visitor")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisitor(@RequestBody @Valid final VisitorDTO visitorDTO) {
        return new ResponseEntity<>(visitorService.create(visitorDTO), HttpStatus.CREATED);
    }

    @PostMapping("/visit")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisit(@RequestBody @Valid final VisitDTO visitDTO) {
        return new ResponseEntity<>(visitService.create(visitDTO), HttpStatus.CREATED);
    }

    @PutMapping("/complete-visit/{id}")
    public ResponseEntity<Void> updateVisit(@PathVariable final Long id) {
        visitService.updateStatus(id, VisitStatus.COMPLETED);
        return ResponseEntity.ok().build();
    }



}
