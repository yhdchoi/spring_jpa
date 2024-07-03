package com.yhdc.jpa.service.account;

import com.yhdc.jpa.record.account.UserPatchRecord;
import com.yhdc.jpa.record.account.UserRecord;
import com.yhdc.jpa.record.account.UserSearchRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    ResponseEntity<?> createUser(final UserRecord userRecord);

    ResponseEntity<?> searchUser(final UserSearchRecord userSearchRecord);


    ResponseEntity<?> patchUser(final UserPatchRecord userPatchRecord);

    ResponseEntity<?> deleteUser(final String userId);

}
