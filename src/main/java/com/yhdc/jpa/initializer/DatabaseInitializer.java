package com.yhdc.jpa.initializer;

import com.yhdc.jpa.entity.account.Stack;
import com.yhdc.jpa.entity.account.User;
import com.yhdc.jpa.repository.account.UserRepository;
import com.yhdc.jpa.repository.stack.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DatabaseInitializer {

    private final UserRepository userRepository;
    private final StackRepository stackRepository;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void defaultDataProcessor() {

        if (userRepository.findAll().isEmpty()) {
            List<Stack> initialStackList = new ArrayList<>();
            Stack stack1 = new Stack();
            stack1.setName("Java");
            stack1.setLevel("Beginner");
            initialStackList.add(stack1);

            Stack stack2 = new Stack();
            stack2.setName("Java");
            stack2.setLevel("Intermediate");
            initialStackList.add(stack2);

            Stack stack3 = new Stack();
            stack3.setName("Java");
            stack3.setLevel("Advanced");
            initialStackList.add(stack3);

            Stack stack4 = new Stack();
            stack4.setName("Spring Boot");
            stack4.setLevel("Intermediate");
            initialStackList.add(stack4);

            Stack stack5 = new Stack();
            stack5.setName("Spring Boot");
            stack5.setLevel("Advanced");
            initialStackList.add(stack5);

            List<Stack> stackList = stackRepository.saveAll(initialStackList);


            List<User> initalUserList = new ArrayList<>();

            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setEmail("admin@admin.com");
            user.setFirstName("Admin");
            user.setLastName("DSL");
            user.setPhone("010-1234-5678");
            user.setStackList(List.of(stackList.get(1), stackList.get(3)));
            initalUserList.add(user);

            User user1 = new User();
            user1.setUsername("daniel");
            user1.setPassword("daniel");
            user1.setEmail("daniel@daniel.com");
            user1.setFirstName("Daniel");
            user1.setLastName("Choi");
            user1.setPhone("010-1234-5678");
            user1.setStackList(List.of(stackList.get(2), stackList.get(4)));
            initalUserList.add(user1);

            userRepository.saveAll(initalUserList);
        }
    }

}
