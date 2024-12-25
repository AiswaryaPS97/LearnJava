package spring.aiswarya.sprintCloud.couponService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.aiswarya.sprintCloud.couponService.dao.CouponDao;
import spring.aiswarya.sprintCloud.couponService.model.Coupon;

@RestController
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    CouponDao couponDao;

    @PostMapping("createCoupon")
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponDao.save(coupon);
    }

    @GetMapping("getCoupon/{code}")
    public Coupon getCoupon(@PathVariable String code){
        return couponDao.findByCode(code);
    }
}
