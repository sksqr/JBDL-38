package io.bootify.l15_minor_project_02.rest;


import io.bootify.l15_minor_project_02.model.VisitDTO;
import io.bootify.l15_minor_project_02.model.VisitStatus;
import io.bootify.l15_minor_project_02.model.VisitorDTO;
import io.bootify.l15_minor_project_02.service.VisitService;
import io.bootify.l15_minor_project_02.service.VisitorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping(value = "/api/gatekeeper", produces = MediaType.APPLICATION_JSON_VALUE)
public class GateKeeperController {


    static private Logger LOGGER = LoggerFactory.getLogger(GateKeeperController.class);


    @Autowired
    private VisitorService visitorService;

    @Autowired
    private VisitService visitService;

    @Value("${static.dir.path}")
    private String staticDir;

    @PostMapping("/visitor")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createVisitor(@RequestBody @Valid final VisitorDTO visitorDTO) {
        return new ResponseEntity<>(visitorService.create(visitorDTO), HttpStatus.CREATED);
    }

    @GetMapping("/visitor")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<List<VisitorDTO>> getVisitor(@RequestParam final String email) {
        return ResponseEntity.ok(visitorService.findAllByEmail(email));
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


    @PostMapping("/image/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            String uploadPath = staticDir+"testfile_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
            file.transferTo(new File(uploadPath));
            message = "Image URL : " + uploadPath;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            LOGGER.error("Exception occurred: {}",e);
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }



}
