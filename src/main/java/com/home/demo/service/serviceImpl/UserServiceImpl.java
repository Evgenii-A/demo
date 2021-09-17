package com.home.demo.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.demo.dto.UserDto;
import com.home.demo.entity.UserEntity;
import com.home.demo.exception.EmptyInputException;
import com.home.demo.repo.UserRepo;
import com.home.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    private final ObjectMapper mapper;
    @Override
    public void addUser(UserDto userDto) {
        if (userDto != null) {
            UserEntity userEntity = mapper.convertValue(userDto, UserEntity.class);
            userRepo.save(userEntity);
        } else throw new EmptyInputException("nothing to save, stupid");
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepo.findById(id);
        if (userEntity.isPresent()) {
            return mapper.convertValue(userEntity, UserDto.class);
        } else throw new RuntimeException("No user found with id " + id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userRepo.findAll().stream()
                .map(userEntity -> mapper.convertValue(userEntity, UserDto.class)).collect(Collectors.toList());
        if (!users.isEmpty()) return users;
        else throw new RuntimeException("There are no users found");
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }
}
