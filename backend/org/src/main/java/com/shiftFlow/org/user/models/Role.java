package com.shiftFlow.org.user.models;


import com.shiftFlow.org.user.BaseEntity;
import com.shiftFlow.org.user.enums.Permission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_uuid"))
    @Enumerated(EnumType.STRING)
    @Column(name = "permission")
    private List<Permission> permissions;
}
