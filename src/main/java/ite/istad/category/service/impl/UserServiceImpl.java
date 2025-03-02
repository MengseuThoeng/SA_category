package ite.istad.category.service.impl;

import ite.istad.category.dto.UserCreateRequest;
import ite.istad.category.model.secondary.User;
import ite.istad.category.repository.secondaryRepo.UserRepository;
import ite.istad.category.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public void addUser(UserCreateRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setPassword(request.password());
        user.setEmail(request.email());

        userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
