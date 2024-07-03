package com.yhdc.jpa.entity.account;

import com.yhdc.jpa.entity.common.EntityDateAudit;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "user")
@Entity
public class User extends EntityDateAudit {

    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(length = 200)
    private String email;

    @Column(length = 100)
    private String phone;

    // User stacks
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_stack"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "stack_id"))
    private Set<Stack> stackSet;

}
