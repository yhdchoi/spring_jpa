package com.yhdc.jpa.service.account;

import com.yhdc.jpa.record.account.UserPatchRecord;
import com.yhdc.jpa.record.account.UserRecord;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> createUser(final UserRecord userRecord);

    ResponseEntity<?> searchUser(final String keyword);

    ResponseEntity<?> patchUser(final UserPatchRecord userPatchRecord);

    ResponseEntity<?> deleteUser(final String userId);

}
