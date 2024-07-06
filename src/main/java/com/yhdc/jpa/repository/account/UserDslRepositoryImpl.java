package com.yhdc.jpa.repository.account;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yhdc.jpa.entity.account.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.yhdc.jpa.entity.account.QUser.user;

@RequiredArgsConstructor
@Repository
public class UserDslRepositoryImpl implements UserDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> searchUser(String keyword) {

        return jpaQueryFactory
                .selectFrom(user)
                .where(user.username.contains(keyword)
                        .or(user.firstName.contains(keyword))
                        .or(user.lastName.contains(keyword))
                        .or(user.email.contains(keyword))
                        .or(user.phone.contains(keyword)))
                .fetch();
    }

}
