package com.yhdc.jpa.record.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Collections;
import java.util.List;

public record UserRecord(String username, String password, String firstName, String lastName, String email, String phone, List<String> stacks) {

    public UserRecord(@NotNull @Size(min = 7, max = 20) String username,
                      @NotBlank String password,
                      @NotBlank String firstName,
                      @NotBlank String lastName,
                      @NotNull @Email String email,
                      String phone,
                      List<String> stacks) {
        this.username =  username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        // 불변성 보장
        this.stacks = Collections.unmodifiableList(stacks);
    }
}
