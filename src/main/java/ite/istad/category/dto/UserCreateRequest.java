package ite.istad.category.dto;

public record UserCreateRequest(
    String name,

    String email,

    String password
) {
}
