package io.bootify.l15_minor_project_02.rest;


import io.bootify.l15_minor_project_02.model.UserDTO;
import io.bootify.l15_minor_project_02.model.UserStatus;
import io.bootify.l15_minor_project_02.model.VisitDTO;
import io.bootify.l15_minor_project_02.service.UserService;
import io.bootify.l15_minor_project_02.service.VisitService;
import io.bootify.l15_minor_project_02.service.VisitorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {


    static private Logger LOGGER = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    private UserService userService;


    @Value("${static.dir.path}")
    private String staticDir;

    @Autowired
    private VisitService visitService;



    @PostMapping("/user")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createUser(@RequestBody @Valid final UserDTO userDTO) {
        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
    }


    @PutMapping("/user/{id}/{status}")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @PathVariable UserStatus status) {
        userService.updateStatus(id,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/visit-report")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<String> getReport() throws IOException {
        List<VisitDTO> visitDTOList =  new ArrayList<>();//visitService.findAll();
        VisitDTO visitDTO1 = new VisitDTO();
        visitDTO1.setPurpose("Work visit");
        visitDTO1.setFlat(1l);
        visitDTO1.setNoOfPeople(2);

        visitDTOList.add(visitDTO1);


        VisitDTO visitDTO2 = new VisitDTO();
        visitDTO2.setPurpose("guest visit");
        visitDTO2.setFlat(2l);
        visitDTO2.setNoOfPeople(1);

        visitDTOList.add(visitDTO2);


        String fileName = staticDir+System.currentTimeMillis()+"_report.csv";
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(fileName));
        CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter,CSVFormat.DEFAULT
                .withHeader("Purpose","FlatId", "noOfPerson"));

        for(VisitDTO visitDTO : visitDTOList){
            csvPrinter.printRecord(visitDTO.getPurpose(),visitDTO.getFlat(),visitDTO.getNoOfPeople());
        }
        csvPrinter.flush();
        csvPrinter.close();
        return ResponseEntity.ok(fileName);

    }


    @PostMapping("/user-csv/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                UserDTO usersDTO = UserDTO.builder()
                        .name(csvRecord.get("name"))
                        .email(csvRecord.get("email"))
                        .phone(csvRecord.get("phone"))
                        .flat(Long.parseLong(csvRecord.get("flat")))
                        .address(Long.parseLong(csvRecord.get("address")))
                        .role(csvRecord.get("role"))
                        .status(UserStatus.ACTIVE).build();
                userService.create(usersDTO);
                LOGGER.info("Read user name :{}",usersDTO.getName());
            }
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            LOGGER.error("Exception occurred: {}",e);
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }






}
