package com.eventify.eventify.service.impl;

import com.eventify.eventify.dto.request.UserRegisterRequest;
import com.eventify.eventify.dto.request.UserUpdateRequest;
import com.eventify.eventify.dto.response.UserResponse;
import com.eventify.eventify.entity.User;
import com.eventify.eventify.exception.NotFoundException;
import com.eventify.eventify.mapper.UserMapper;
import com.eventify.eventify.repository.UserRepository;
import com.eventify.eventify.service.UserService;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class UserServieImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse save(UserRegisterRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        User userSaved = userRepository.save(user);
        return userMapper.toResponse(userSaved);

    }

    @Override
    public UserResponse getEventById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return userMapper.toResponse(user.get());
        throw new NotFoundException("trouvé  aucan  user de id " + id);
    }

    @Override
    public UserResponse update(UUID id, UserUpdateRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User oldUser = user.get();
            if (!userRequest.getEmail().trim().isEmpty())
                oldUser.setEmail(userRequest.getEmail());
            if(!userRequest.getName().trim().isEmpty())
                oldUser.setName(userRequest.getName());
            if(!userRequest.getPassword().trim().isEmpty())
                oldUser.setPassword(userRequest.getPassword());
            userRepository.save(oldUser);
        }
        throw new NotFoundException("trouvé  aucan  user de id pour  modification " + id);
    }

    @Override
    public String delete(UUID id) {
        Optional<User>   user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return "user est  seprime";
        }
        throw new NotFoundException("trouvé  aucan  user de id pour  suprrision " + id);

    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        Page<User>   page  =  userRepository.findAll(pageable);
        if(page.getTotalElements()<1)
            throw new NotFoundException("trouvé  aucan  user  ");
        return page.map(userMapper::toResponse);

    }
}
