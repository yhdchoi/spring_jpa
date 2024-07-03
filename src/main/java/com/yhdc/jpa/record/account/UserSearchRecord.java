package com.yhdc.jpa.record.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserSearchRecord(String keyword) {

    public UserSearchRecord(@NotBlank @Size(min = 1) String keyword) {
        this.keyword = keyword;
    }
}
