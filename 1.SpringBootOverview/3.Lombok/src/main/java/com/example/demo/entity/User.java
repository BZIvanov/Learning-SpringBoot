package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// let lombok generate some boilerplate code
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;

    @JsonProperty("first_name") // modify the property name in the response
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonIgnore // don't send the password in the JSON response
    private String password;
}
