package com.example.demo.controller;

import com.example.demo.dto.CreateUserRequestDto;
import com.example.demo.dto.CreateUserResponseDto;
import com.example.demo.dto.GetUserResponseDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    @PostMapping
    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto dto){
        User user = mapper.map(dto, User.class);
        user = userService.create(user);
        return CreateUserResponseDto.builder()
                .message("User created successfully")
                .id(user.getId())
                .build();
    }

    @GetMapping(path = "/{userId}")
    public GetUserResponseDto read(@PathVariable("userId") Long userId){
        User user = userService.read(userId);
        return mapper.map(user, GetUserResponseDto.class);
    }

}
