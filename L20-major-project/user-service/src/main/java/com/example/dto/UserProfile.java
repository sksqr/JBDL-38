package com.example.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {
    private String name;
    private String email;
    private String phone;
    private String address;
    private Double balance;
}
