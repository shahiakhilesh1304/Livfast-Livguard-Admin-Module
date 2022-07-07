package com.livguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livguard.model.SecondaryScheme;

@Repository
public interface SecondarySchemeRepository extends JpaRepository<SecondaryScheme, Integer> 
{
	List<SecondaryScheme> findByProductName(String model);
	int deleteByProductName(String model);
	@Query(value = "SELECT * FROM api_batterymodelseligiblescheme order by id desc;", nativeQuery = true)
	public List<SecondaryScheme> getSecondaryList();
}
