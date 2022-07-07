package com.livfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livfast.model.LivFastTertiaryScheme;

@Repository
public interface LivFastTertiarySchemeRepository extends JpaRepository<LivFastTertiaryScheme, Integer>  
{
	List<LivFastTertiaryScheme> findByBatteryModel(String batteryModel);
	int deleteByBatteryModel(String batteryModel);
	@Query(value = "SELECT * "
			+ "FROM detailproductloyalty_tbl "
			+ "order by id desc;", nativeQuery = true)
	public List<LivFastTertiaryScheme> getTertiaryList();
	
	
	
}
