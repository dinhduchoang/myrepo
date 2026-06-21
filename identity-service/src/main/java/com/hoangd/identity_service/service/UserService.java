package com.hoangd.identity_service.service;

import com.hoangd.identity_service.dto.request.UserCreationRequest;
import com.hoangd.identity_service.dto.request.UserUpdateRequest;
import com.hoangd.identity_service.entity.User;
import com.hoangd.identity_service.exception.ErrorCode;
import com.hoangd.identity_service.exception.MyException;
import com.hoangd.identity_service.mapper.UserMapper;
import com.hoangd.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())){
            throw new MyException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new MyException(ErrorCode.USER_NOT_EXISTED));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        if(!userRepository.existsById(userId)){
            throw new MyException(ErrorCode.USER_NOT_EXISTED);
        }

        User user = getUser(userId);

        userMapper.updateUser(user, request);

        return userRepository.save(user);
    }
    public void deleteUser (String userId) {
        if(!userRepository.existsById(userId)){
            throw new MyException(ErrorCode.USER_NOT_EXISTED);
        }
        else {
            userRepository.deleteById(userId);
        }
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }
}
