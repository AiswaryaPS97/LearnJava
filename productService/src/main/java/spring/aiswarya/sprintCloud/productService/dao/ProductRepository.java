package spring.aiswarya.sprintCloud.productService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.aiswarya.sprintCloud.productService.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
