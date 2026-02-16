package com.shiftflow.mappers;


import com.shiftflow.user.dtos.request.UserRegistrationRequest;
import com.shiftflow.user.dtos.response.UserResponse;
import com.shiftflow.user.models.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserResponse toDto(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public User toEntity(UserResponse userResponse) {
        return modelMapper.map(userResponse, User.class);
    }

    public User toEntityFromReq(UserRegistrationRequest request) {
        return modelMapper.map(request, User.class);
    }



}
