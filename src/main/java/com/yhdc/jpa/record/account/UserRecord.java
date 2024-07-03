package com.yhdc.jpa.record.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Collections;
import java.util.List;

public record UserRecord(String username, String password,
                         String firstName, String lastName,
                         String email, String phone,
                         List<String> stackIdList) {

    public UserRecord(@NotBlank @Size(min = 8, max = 20) String username,
                      @NotBlank @Size(min = 8, max = 20)String password,
                      @NotBlank @Size(min = 2, max = 30)String firstName,
                      @NotBlank @Size(min = 2, max = 30)String lastName,
                      @NotNull @Email String email,
                      String phone,
                      List<String> stackIdList) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;

        // 불변성 보장
        this.stackIdList = Collections.unmodifiableList(stackIdList);
    }
}
