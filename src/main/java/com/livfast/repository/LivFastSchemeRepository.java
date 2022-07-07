package com.livfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livfast.model.LivFastScheme;

@Repository
public interface LivFastSchemeRepository extends JpaRepository <LivFastScheme, Integer>
{
	long countById(int schemeID);		
	@Query(value = "SELECT * "
			+ "FROM api_batteryscheme "
			+ "WHERE scheme_detail "
			+ "LIKE %:name% AND Date(end_timestamp) >= Date(NOW());", nativeQuery = true)
	List<LivFastScheme> findByschemeDetailContaining(@Param("name") String name);
	
	
	
	@Query(value="SELECT "
			+ "scheme_detail,"
			+ "COUNT(scheme_name) "
			+ "from api_batteryscheme "
			+ "WHERE end_timestamp >= Date(NOW()) and created_timestamp >= now()-interval '3 month' "
			+ "GROUP BY scheme_detail",nativeQuery = true)
	List<Object[]> findActiveTer_SecScheme();
}
