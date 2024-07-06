package com.yhdc.jpa.repository.account;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yhdc.jpa.entity.account.QStack;
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
        List<User> searchedUser = jpaQueryFactory
                .selectFrom(user)
                .where(user.username.contains(keyword)
                        .or(user.firstName.contains(keyword))
                        .or(user.lastName.contains(keyword))
                        .or(user.email.contains(keyword))
                        .or(user.phone.contains(keyword)))
                .fetch();

        return searchedUser;
    }


    private static Predicate searchStackList(String keyword) {
        QStack qStack = QStack.stack;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qStack.userSet.contains(user)).andAnyOf(qStack.name.contains(keyword).or(qStack.level.contains(keyword)));
        return booleanBuilder;
    }


    private static BooleanExpression eqKeyword(String keyword) {
        return user.username.contains(keyword)
                .or(user.firstName.contains(keyword))
                .or(user.lastName.contains(keyword))
                .or(user.email.contains(keyword))
                .or(user.phone.contains(keyword));
    }

}
