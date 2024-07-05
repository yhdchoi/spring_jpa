package com.yhdc.jpa.controller.account;

import com.yhdc.jpa.record.account.UserPatchRecord;
import com.yhdc.jpa.record.account.UserRecord;
import com.yhdc.jpa.service.account.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User API Controller
 *
 * @author Daniel
 * @apiNote User api controller
 */

@RequiredArgsConstructor
@RequestMapping("/usr")
@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody @Valid UserRecord userRecord) {
        return userServiceImpl.createUser(userRecord);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "keyword") @NotBlank @Size(min = 1, max = 50) String keyword) {
        return userServiceImpl.searchUser(keyword);
    }

    @PatchMapping("/patch")
    public ResponseEntity<?> patchUser(@RequestBody @Valid UserPatchRecord userPatchRecord) {
        return userServiceImpl.patchUser(userPatchRecord);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "userId") @NotBlank String userId) {
        return userServiceImpl.deleteUser(userId);
    }

}
