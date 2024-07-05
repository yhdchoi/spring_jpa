package com.yhdc.jpa.entity.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "stack")
@Entity
public class Stack extends EntityDateAudit {

    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private UUID id;

    // Users
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_stack"
            , joinColumns = @JoinColumn(name = "stack_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userSet;

    // Stack name
    private String name;

    // Skill level
    private String level;

}
