package com.yhdc.jpa.repository.account;

import com.yhdc.jpa.entity.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, UserDslRepository {
}
