package com.livguard.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.livguard.model.UserDetail;

@Repository
public interface ScanningAnalysisRepository extends JpaRepository<UserDetail, Integer>  
{
	@Query(value = "select "
			+ "first_name,"
			+ "last_name,"
			+ "email,"
			+ "large_image,"
			+ "phone,"
			+ "username,"
			+ "total_loyalty_tertiary,"
			+ "ibups_sec_loyalty,"
			+ "fourw_sec_loyalty,"
			+ "user_id "
			+ "from api_userdetail "
			+ "INNER Join auth_user "
			+ "ON auth_user.id = api_userdetail.user_id "
			+ "where api_userdetail.created_timestamp >= now()-interval '3 month';",nativeQuery = true)
	public List<Object[]> findAllData();
	
//	@Query(value ="select large_image from api_userdetail where user_id = :id",nativeQuery = true)
//	public String imageLink(@Param("id") int id);
//	
	@Query(value = "select first_name,"
			+ " last_name,"
			+ "	email,"
			+ "	salespersonname,"
			+ "	phone,"
			+ "	username,"
			+ "	(ibups_sec_loyalty + fourw_sec_loyalty + total_loyalty_tertiary) as total_loyalty_point,"
			+ "	user_id "
			+ "	from api_userdetail "
			+ "	INNER Join auth_user "
			+ "	ON auth_user.id = api_userdetail.user_id "
			+ "where extract(month from created_timestamp) = extract(month from now())"
			+ "ORDER BY total_loyalty_point DESC;", nativeQuery = true)
	public List<Object[]> findTop10SchemeScanned();
	
//	@Query(value ="select salespersonname from api_userdetail where user_id = :id",nativeQuery = true)
//	public String salePersonName(@Param("id") int id);
	
}
