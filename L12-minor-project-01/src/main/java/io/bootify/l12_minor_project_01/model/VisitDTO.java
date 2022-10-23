package io.bootify.l12_minor_project_01.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VisitDTO {

    private Long id;

    @NotNull
    private VisitStatus status = VisitStatus.WAITING;

    private LocalDateTime inTime;

    private LocalDateTime outTime;

    @Size(max = 255)
    private String purpose;

    @Size(max = 255)
    private String imageUrl;

    @NotNull
    private Integer noOfPeople;

    @NotNull
    private Long visitor;

    @NotNull
    private Long flat;

}
