package com.yhdc.jpa.repository.stack;

import com.yhdc.jpa.entity.account.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StackRepository extends JpaRepository<Stack, UUID>, StackDslRepository {

}
