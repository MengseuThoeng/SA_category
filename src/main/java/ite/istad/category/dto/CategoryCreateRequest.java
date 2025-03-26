package ite.istad.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequest(
        @NotBlank(message = "Category name cannot be empty")
         String name,
        Boolean isDeleted
) {
}
