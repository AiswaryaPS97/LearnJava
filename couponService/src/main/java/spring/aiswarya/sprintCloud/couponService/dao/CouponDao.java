package spring.aiswarya.sprintCloud.couponService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.aiswarya.sprintCloud.couponService.model.Coupon;

@Repository
public interface CouponDao extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String code);
}
