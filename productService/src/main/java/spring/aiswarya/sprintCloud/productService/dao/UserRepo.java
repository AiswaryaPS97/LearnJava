package spring.aiswarya.sprintCloud.productService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.aiswarya.sprintCloud.productService.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
