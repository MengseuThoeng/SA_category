package ite.istad.category.service;

import ite.istad.category.dto.UserCreateRequest;
import ite.istad.category.model.secondary.User;

import java.util.List;

public interface UserService {

    void addUser(UserCreateRequest request);

    User getUser(String username);

    List<User> getUsers();
}
