package com.livfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livfast.model.LivFastMonthlySlabs;
import com.livguard.model.MonthlySlabs;

@Repository
public interface LivFastMonthlySlabRepository extends JpaRepository<LivFastMonthlySlabs, Integer> 
{
	@Query(value="select "
			+ "monthly_slabs.id,"
			+ "monthly_slabs.loyalty_point,"
			+ "monthly_slabs.is_active,"
			+ "monthly_slabs.created_timestamp,"
			+ "monthly_slabs.updated_timestamp,"
			+ "monthly_slabs.battery_scheme_id,"
			+ "monthly_slabs.redeem_desc "
			+ "from monthly_slabs "
			+ "inner join api_batteryscheme "
			+ "on api_batteryscheme.id = monthly_slabs.battery_scheme_id "
			+ "where api_batteryscheme.created_timestamp >= now()-interval '3 month'  "
			+ "order by monthly_slabs.battery_scheme_id desc;",nativeQuery = true)
	public List<LivFastMonthlySlabs> findAllDataWithCommonBatteryScheme();
		
	@Query(value = "select "
			+ "api_batteryscheme.id, "
			+ "api_batteryscheme.scheme_name "
			+ "from monthly_slabs "
			+ "inner join api_batteryscheme "
			+ "on api_batteryscheme.id = monthly_slabs.battery_scheme_id "
			+ "where monthly_slabs.created_timestamp >= now()-interval '3 month' "
			+ "group by api_batteryscheme.id;",nativeQuery = true)
	public List<Object[]> batterySchemeIdWithMonthlySlabs();
	
	@Query(value = "select id, loyalty_point, is_active, created_timestamp, updated_timestamp, battery_scheme_id,"
			+ "redeem_desc "
			+ "from monthly_slabs "
			+ "where battery_scheme_id = :id and monthly_slabs.created_timestamp >= now()-interval '3 month';",nativeQuery = true)
	public List<LivFastMonthlySlabs> findAllDataWithCommonBatterySchemeId(@Param("id")int id);
}
