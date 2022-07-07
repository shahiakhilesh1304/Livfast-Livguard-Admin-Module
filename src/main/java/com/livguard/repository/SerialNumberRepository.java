package com.livguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.livguard.model.SerialNumber;

public interface SerialNumberRepository extends JpaRepository<SerialNumber, Integer> {
	List<SerialNumber> findBySerialNumber(String serialNumber);
	SerialNumber findById(int id);
	int deleteBySerialNumber(String serialNumber);
	
	@Query(value = "SELECT * FROM api_specialserialno order by id desc;", nativeQuery = true)
	public List<SerialNumber> getSerialNumberList();
}
