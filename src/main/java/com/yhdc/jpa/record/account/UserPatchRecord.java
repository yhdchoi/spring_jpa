package com.yhdc.jpa.record.account;

import jakarta.validation.constraints.*;

import java.util.Collections;
import java.util.List;

public record UserPatchRecord(String username, String password,
                              String firstName, String lastName,
                              String email, String phone,
                              List<String> stacks) {

    public UserPatchRecord(@Size(min = 8, max = 20) String username,
                           @Size(min = 8, max = 20)String password,
                           @Size(min = 2, max = 30)String firstName,
                           @Size(min = 2, max = 30)String lastName,
                           @Email String email,
                           @Pattern(regexp = "^\\d{3}-(\\d{4})-\\d{4}$") String phone,
                           List<String> stacks) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;

        // 불변성 보장
        this.stacks = Collections.unmodifiableList(stacks);
    }
}
