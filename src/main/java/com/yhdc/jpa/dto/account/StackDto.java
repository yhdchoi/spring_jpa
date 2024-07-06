package com.yhdc.jpa.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StackDto {

    private String stackId;
    private String name;
    private String level;
    private String created;
    private String updated;

}
