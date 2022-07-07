package com.livguard.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livguard.model.StateWiseSecondary;

@Repository
public interface StateWiseSecondarySchemeRepository extends JpaRepository<StateWiseSecondary, Integer> 
{
	
	@Query(value = "select "
			+ "id,"
			+ "erick_category,"
			+ "fourw_category,"
			+ "ib_ups_category,"
			+ "state "
			+ "from "
			+ "statewise_secondary "
			+ "where "
			+ "UPPER(state)=UPPER( :state );",nativeQuery = true)
	StateWiseSecondary findByState(String state);
	List<StateWiseSecondary> findByIbUpsCategoryOrFourwCategoryOrErickCategory(int ib, int fw, int er);
	@Modifying
	@Query(value = "update statewise_secondary set ib_ups_category = 0, fourw_category = 0, erick_category = 0 where ib_ups_category = :schemeID or "
			+ "fourw_category = :schemeID or erick_category = :schemeID", nativeQuery = true)
	@Transactional
	void updateState(@Param("schemeID") int schemeID);
}
