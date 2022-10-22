package io.bootify.l11_major_project_01.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ErrorResponse {

    private Integer httpStatus;
    private String exception;
    private String message;
    private List<FieldError> fieldErrors;

}
