package com.livfast.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.livfast.model.LivFastStateWiseTeritiary;

public interface LivFastStateWiseTertiarySchemeRepository extends JpaRepository<LivFastStateWiseTeritiary, Integer>
{
	@Query(value = "select "
			+ "id,"
			+ "erick_category,"
			+ "fourw_category,"
			+ "ib_ups_category,"
			+ "state "
			+ "from "
			+ "statewise_tertiary "
			+ "where "
			+ "UPPER(state)=UPPER( :state );",nativeQuery = true)
	LivFastStateWiseTeritiary findByState(@Param("state") String state);
	
	List<LivFastStateWiseTeritiary> findByIbUpsCategoryOrFourwCategoryOrErickCategory(int ib, int fw, int er);
	
	@Modifying
	@Query(value = "update statewise_tertiary set ib_ups_category = 0, fourw_category = 0, erick_category = 0 where ib_ups_category = :schemeID or "
			+ "fourw_category = :schemeID or erick_category = :schemeID", nativeQuery = true)
	@Transactional
	void updateState(@Param("schemeID") int schemeID);
}
