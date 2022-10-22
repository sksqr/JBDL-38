package io.bootify.l11_major_project_01.rest;

import io.bootify.l11_major_project_01.model.VisitDTO;
import io.bootify.l11_major_project_01.model.VisitStatus;
import io.bootify.l11_major_project_01.service.VisitService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/visits", produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitResource {

    private final VisitService visitService;

    public VisitResource(final VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public ResponseEntity<List<VisitDTO>> getAllVisits() {
        return ResponseEntity.ok(visitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDTO> getVisit(@PathVariable final Long id) {
        return ResponseEntity.ok(visitService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisit(@RequestBody @Valid final VisitDTO visitDTO) {
        return new ResponseEntity<>(visitService.create(visitDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVisit(@PathVariable final Long id,
            @RequestBody @Valid final VisitDTO visitDTO) {
        visitService.update(id, visitDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteVisit(@PathVariable final Long id) {
        visitService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}/{status}")
    public ResponseEntity<Void> updateVisit(@PathVariable final Long id, @PathVariable VisitStatus status) {
        visitService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

}
