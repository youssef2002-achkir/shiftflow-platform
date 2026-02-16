package com.shiftFlow.org.user.models;

import com.shiftFlow.org.user.BaseEntity;
import com.shiftFlow.org.user.enums.Civility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String PhoneNumber;
    private String Address;
    private String birthPlace;
    private LocalDate birthDate;
    private Civility civility;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_uuid"),
            inverseJoinColumns = @JoinColumn(name = "role_uuid")
    )
    private List<Role> roles;


}
