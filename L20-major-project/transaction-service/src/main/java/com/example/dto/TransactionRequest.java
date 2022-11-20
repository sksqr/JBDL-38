package com.example.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest {
    private Long fromUserId;
    private Long toUserId;
    private Double amount;
    private String remark;
}
