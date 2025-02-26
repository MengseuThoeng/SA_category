package ite.istad.category.dto;

public record CategoryCreateRequest(
        String name,
        Boolean isDeleted
) {
}
