package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfileDTO {
    private Long id;

    private String address;

    private String phoneNumber;
}
