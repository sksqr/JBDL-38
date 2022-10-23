package io.bootify.l12_minor_project_01.rest;


import io.bootify.l12_minor_project_01.model.UserDTO;
import io.bootify.l12_minor_project_01.model.UserStatus;
import io.bootify.l12_minor_project_01.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping(value = "/api/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {


    static private Logger LOGGER = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    private UserService userService;



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
