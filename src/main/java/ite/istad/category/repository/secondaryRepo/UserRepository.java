package ite.istad.category.repository.secondaryRepo;

import ite.istad.category.model.secondary.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
}
