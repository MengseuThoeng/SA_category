package ite.istad.category.repository.primaryRepo;


import ite.istad.category.model.primary.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
