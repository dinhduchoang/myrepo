package com.hoangd.identity_service.controller;

import com.hoangd.identity_service.dto.request.ApiResponse;
import com.hoangd.identity_service.dto.request.UserCreationRequest;
import com.hoangd.identity_service.dto.request.UserUpdateRequest;
import com.hoangd.identity_service.dto.response.UserReponse;
import com.hoangd.identity_service.entity.User;
import com.hoangd.identity_service.mapper.UserMapper;
import com.hoangd.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class UserController {

    UserService userService;
    UserMapper userMapper;

    @PostMapping
    public ApiResponse<UserReponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserReponse> apiResponse = new ApiResponse<>();
        User user = userService.createUser(request);

        apiResponse.setResult(userMapper.toUserResponse(user));

        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<UserReponse>> getAllUsers() {
        ApiResponse<List<UserReponse>> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userMapper.toListUserResponse(userService.getAll()));

        return apiResponse;
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserReponse> getUser(@PathVariable String userId) {
        ApiResponse<UserReponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userMapper.toUserResponse(userService.getUser(userId)));

        return apiResponse;
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserReponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        ApiResponse<UserReponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userMapper.toUserResponse(userService.updateUser(userId, request)));

        return apiResponse;
    }


    @DeleteMapping("/{userId}")
    public ApiResponse deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("user da bi xoa!");
        return apiResponse;
    }

    @DeleteMapping
    public ApiResponse deleteAll(){
        userService.deleteAll();
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Da xoa sach");
        return apiResponse;
    }
}
