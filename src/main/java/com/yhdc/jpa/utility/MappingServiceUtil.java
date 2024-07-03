package com.yhdc.jpa.utility;

import com.yhdc.jpa.dto.account.UserDto;
import com.yhdc.jpa.entity.account.Stack;
import com.yhdc.jpa.entity.account.User;
import com.yhdc.jpa.record.account.UserRecord;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class MappingServiceUtil {


    public User UserRecordToUser(UserRecord userRecord) {

        User newUser = new User();
        newUser.setUsername(userRecord.username());
        newUser.setPassword(userRecord.password());
        newUser.setEmail(userRecord.email());
        newUser.setPhone(userRecord.phone());
        newUser.setFirstName(userRecord.firstName());
        newUser.setLastName(userRecord.lastName());
        return newUser;
    }


    public UserDto UserToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setCreated(user.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userDto.setUpdated(user.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // Stack collection
        if (user.getStackSet() == null || user.getStackSet().isEmpty()) {
            userDto.setStacks(List.of("Empty"));
        } else {
            List<String> stackList = user.getStackSet().stream().map(Stack::getStack).toList();
            userDto.setStacks(stackList);
        }

        return userDto;
    }


}
