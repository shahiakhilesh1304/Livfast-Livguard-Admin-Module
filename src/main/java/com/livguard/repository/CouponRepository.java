package com.livguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livguard.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> 
{
	List<Coupon> findByCouponText(String coupon);
	Coupon findByUserId(int userID);
	Coupon findById(int id);
	int deleteByCouponText(int id);
	
	@Query(value = "SELECT * FROM coupon_table order by id desc;", nativeQuery = true)
	public List<Coupon> getCouponList();
}
