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
@Table(name = "stack")
@Entity
public class Stack extends EntityDateAudit {

    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private UUID id;

    // User
    @ManyToMany(mappedBy = "stackSet", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    private Set<User> userSet;

    // Stack name
    private String stack;

    // Skill level
    private String level;

}
