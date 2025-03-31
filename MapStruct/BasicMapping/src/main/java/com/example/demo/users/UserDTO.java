package com.example.demo.users;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;

    private String name;

    private String email;
}
