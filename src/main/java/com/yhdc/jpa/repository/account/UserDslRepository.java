package com.yhdc.jpa.repository.account;

import com.yhdc.jpa.entity.account.User;

import java.util.List;

public interface UserDslRepository {

    List<User> searchUser(String keyword);

}
