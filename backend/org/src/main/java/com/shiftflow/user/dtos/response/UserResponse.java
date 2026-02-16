package com.shiftflow.user.dtos.response;

import com.shiftflow.user.enums.Civility;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String PhoneNumber;
    private String Address;
    private Civility civility;
}
