package com.example.kafka;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionPayload {
    private String txnId;
    private Long fromUserId;
    private Long toUserId;
    private Double amount;
    private String status;
    private String reason;
    private String requestId;
}
