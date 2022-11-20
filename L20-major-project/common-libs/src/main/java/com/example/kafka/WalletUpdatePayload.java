package com.example.kafka;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletUpdatePayload {

    private String email;
    private Double balance;

    private String requestId;

}
