package com.yhdc.jpa.utility;

import com.yhdc.jpa.dto.account.UserDto;
import com.yhdc.jpa.entity.account.Stack;
import com.yhdc.jpa.entity.account.User;
import com.yhdc.jpa.record.account.UserRecord;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
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
        if (user.getStackList() == null || user.getStackList().isEmpty()) {
            userDto.setStacks(List.of("Empty"));
        } else {
            List<String> stackList = user.getStackList().stream().map(Stack::getName).toList();
            userDto.setStacks(stackList);
        }

        return userDto;
    }


}
