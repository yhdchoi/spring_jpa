package com.yhdc.jpa.utility;

import com.yhdc.jpa.dto.account.StackDto;
import com.yhdc.jpa.dto.account.UserDto;
import com.yhdc.jpa.entity.account.Stack;
import com.yhdc.jpa.entity.account.User;
import com.yhdc.jpa.record.account.UserRecord;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        userDto.setUserId(user.getId().toString());
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
            userDto.setStacks(List.of());
        } else {
//            List<String> stackList = user.getStackList().stream().map(Stack::getName).toList();
            List<StackDto> stackList = new ArrayList<>();
            user.getStackList().forEach(stack -> {
                stackList.add(StackToStackDto(stack));
            });
            userDto.setStacks(stackList);
        }

        return userDto;
    }

    public StackDto StackToStackDto(Stack stack) {
        StackDto stackDto = new StackDto();
        stackDto.setStackId(stack.getId().toString());
        stackDto.setName(stack.getName());
        stackDto.setLevel(stack.getLevel());
        stackDto.setCreated(stack.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        stackDto.setUpdated(stack.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return stackDto;
    }


}
