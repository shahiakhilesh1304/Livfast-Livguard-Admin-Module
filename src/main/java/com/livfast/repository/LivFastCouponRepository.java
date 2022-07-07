package com.livfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livfast.model.LivFastCoupon;

@Repository
public interface LivFastCouponRepository extends JpaRepository<LivFastCoupon, Integer> 
{
	List<LivFastCoupon> findByCouponText(String coupon);
	LivFastCoupon findByUserId(int userID);
	LivFastCoupon findById(int id);
	int deleteByCouponText(int id);
	
	@Query(value = "SELECT * FROM coupon_table order by id desc;", nativeQuery = true)
	public List<LivFastCoupon> getCouponList();
}
