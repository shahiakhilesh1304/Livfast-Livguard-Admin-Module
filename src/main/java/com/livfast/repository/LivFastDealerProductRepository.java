package com.livfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.livfast.model.LivFastDealerProduct;

@Repository
public interface LivFastDealerProductRepository extends JpaRepository<LivFastDealerProduct, Integer>
{
	@Query(value="select "
			+ "created_timestamp,"
			+ "count(id) "
			+ "from api_dealerproduct "
			+ "where created_timestamp >= now()-interval '3 month' "
			+ "group by created_timestamp;",nativeQuery = true)
	public List<Object[]> checkDataAvailaibilitySecondary();
}
