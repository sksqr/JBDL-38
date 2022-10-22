package io.bootify.l11_major_project_01.rest;


import io.bootify.l11_major_project_01.model.VisitDTO;
import io.bootify.l11_major_project_01.model.VisitStatus;
import io.bootify.l11_major_project_01.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/resident", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResidentController {



    @Autowired
    private VisitService visitService;


    @PutMapping("/visit/{id}/{status}")
    public ResponseEntity<Void> updateVisit(@PathVariable final Long id, @PathVariable VisitStatus status) {
        visitService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/visits/{status}")
    public ResponseEntity<VisitDTO> getVisit(@PathVariable VisitStatus status, @RequestHeader Long userId) {

        return null;
        //return ResponseEntity.ok(visitService.get(id));
    }



}
