package com.shiftflow.user.dtos.request;

import com.shiftflow.user.enums.Civility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationRequest {
    private String firstName;
    private String lastName;
    @NonNull
    private String email;
    private String password;
    private String PhoneNumber;
    private String Address;
    private String birthPlace;
    private LocalDate birthDate;
    private Civility civility;
}
