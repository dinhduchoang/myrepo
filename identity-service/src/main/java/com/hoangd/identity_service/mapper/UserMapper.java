package com.hoangd.identity_service.mapper;

import com.hoangd.identity_service.dto.request.UserCreationRequest;
import com.hoangd.identity_service.dto.request.UserUpdateRequest;
import com.hoangd.identity_service.dto.response.UserReponse;
import com.hoangd.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper (componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    UserReponse toUserResponse(User user);
    List<UserReponse> toListUserResponse(List<User> users);
}
