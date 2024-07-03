package com.yhdc.jpa.service.account;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yhdc.jpa.dto.account.UserDto;
import com.yhdc.jpa.entity.account.Stack;
import com.yhdc.jpa.entity.account.User;
import com.yhdc.jpa.record.account.UserPatchRecord;
import com.yhdc.jpa.record.account.UserRecord;
import com.yhdc.jpa.record.account.UserSearchRecord;
import com.yhdc.jpa.repository.account.UserRepository;
import com.yhdc.jpa.repository.stack.StackRepository;
import com.yhdc.jpa.utility.MappingServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JPAQueryFactory jpaQueryFactory;
    private final MappingServiceUtil mappingServiceUtil;
    private final UserRepository userRepository;
    private final StackRepository stackRepository;

    // Create a new user
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    @Override
    public ResponseEntity<?> createUser(UserRecord userRecord) {

        User newUser = mappingServiceUtil.UserRecordToUser(userRecord);

        if (!userRecord.stackIdList().isEmpty()) {
            List<UUID> stackUidList = new ArrayList<>();
            userRecord.stackIdList().forEach(stackId -> {
                stackUidList.add(UUID.fromString(stackId));
            });
            List<Stack> userStacks = stackRepository.findAllById(stackUidList);
            newUser.setStackList(userStacks);
        }

        User savedUser = userRepository.save(newUser);

        UserDto userDto = mappingServiceUtil.UserToUserDto(savedUser);

        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }


    // Search user by keyword
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    @Override
    public ResponseEntity<?> searchUser(UserSearchRecord userSearchRecord) {


        return null;
    }

    @Override
    public ResponseEntity<?> patchUser(UserPatchRecord userPatchRecord) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteUser(String userId) {
        return null;
    }
}
