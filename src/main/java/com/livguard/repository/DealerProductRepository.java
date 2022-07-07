package com.livguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.livguard.model.DealerProduct;

@Repository
public interface DealerProductRepository extends JpaRepository<DealerProduct, Integer>
{
	@Query(value="select "
			+ "created_timestamp,"
			+ "count(id) "
			+ "from api_dealerproduct "
			+ "where created_timestamp >= now()-interval '3 month' "
			+ "group by created_timestamp;",nativeQuery = true)
	public List<Object[]> checkDataAvailaibilitySecondary();
}
