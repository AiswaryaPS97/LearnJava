package spring.aiswarya.sprintCloud.productService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring.aiswarya.sprintCloud.productService.dao.ProductRepository;
import spring.aiswarya.sprintCloud.productService.dto.Coupon;
import spring.aiswarya.sprintCloud.productService.model.Product;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${coupon.url}")
    private String couponURL;

    @PostMapping("createProduct")
    public Product createProduct(@RequestBody Product product){
        Coupon coupon = restTemplate.getForObject(couponURL+product.getCoupon(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }

    @GetMapping("getProduct/{name}")
    public Product getProduct(@PathVariable String name){
        return productRepository.findByName(name);
    }
}
