package com.livfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.livfast.model.LivfastSerialNumber;

public interface LivfastSerialNumberRepository extends JpaRepository<LivfastSerialNumber, Integer> {
	List<LivfastSerialNumber> findBySerialNumber(String serialNumber);
	LivfastSerialNumber findById(int id);
	int deleteBySerialNumber(String serialNumber);
	
	@Query(value = "SELECT * "
			+ "FROM api_specialserialno "
			+ "order by id desc;", nativeQuery = true)
	public List<LivfastSerialNumber> getSerialNumberList();
}
