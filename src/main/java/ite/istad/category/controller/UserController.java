package ite.istad.category.controller;


import ite.istad.category.dto.UserCreateRequest;
import ite.istad.category.model.secondary.User;
import ite.istad.category.repository.secondaryRepo.UserRepository;
import ite.istad.category.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    void  addUser(@RequestBody UserCreateRequest request) {
        userService.addUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }
}
