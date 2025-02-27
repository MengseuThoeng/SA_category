package ite.istad.category;

import ite.istad.category.controller.CategoryController;
import ite.istad.category.model.Category;
import ite.istad.category.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


class CategoryApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	private CategoryService categoryService;

	private CategoryController categoryController;

	private Category testCategory;

	@BeforeEach
	void setUp() {
		categoryService = Mockito.mock(CategoryService.class);
		categoryController = new CategoryController(categoryService);

		testCategory = new Category();
		testCategory.setId(1L);
		testCategory.setName("Test Category");
	}

	@Test
	void getCategoryById_ReturnsCategory() {
		// Arrange
		when(categoryService.getCategoryById(1L)).thenReturn(testCategory);

		// Act
		Category result = categoryController.getCategory(1L);

		// Assert
		assertNotNull(result);
		assertEquals(1L, result.getId());
		assertEquals("Test Category", result.getName());
		verify(categoryService, times(1)).getCategoryById(1L);
	}

	@Test
	void getCategories_ReturnsCategoryList() {
		// Arrange
		List<Category> categories = Arrays.asList(testCategory);
		when(categoryService.getCategories()).thenReturn(categories);

		// Act
		List<Category> result = categoryController.getCategories();

		// Assert
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("Test Category", result.get(0).getName());
		verify(categoryService, times(1)).getCategories();
	}

}
