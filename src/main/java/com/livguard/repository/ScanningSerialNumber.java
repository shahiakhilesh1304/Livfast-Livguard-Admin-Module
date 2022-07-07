package com.livguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.livguard.model.ProductWarrenty;

@Repository
public interface ScanningSerialNumber extends JpaRepository<ProductWarrenty,Integer> 
{
	@Query(value = "select to_char(created_timestamp, 'W') as inweek,"
			+ "count(serial_number)  as Total,"
			+ "extract(month from now()) as inomth "
			+ "from productwarranty_tbl "
			+ "where extract(year from created_timestamp) = extract(year from now()) "
			+ "and extract(month from created_timestamp) = extract(month from now())"
			+ "group by to_char(created_timestamp, 'W');",nativeQuery = true)
	public List<Object[]> findThisMonthScannedSerialNumber();
	
	@Query(value="SELECT "
			+ "count(id) AS total, "
			+ "sum(case when (product_cat IN ('IB')) then 1 else 0 end) as ib, "
			+ "sum(case when (product_cat IN ('E-RICKSHAW')) then 1 else 0 end) as erick, "
			+ "sum(case when (product_cat IN ('UPS')) then 1 else 0 end) as ups "
			+ "FROM productwarranty_tbl;",nativeQuery=true)
	public List<Object[]> recordData();
}
