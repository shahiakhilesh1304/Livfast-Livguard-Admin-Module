package com.livguard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.livguard.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmailAndPassword(String email, String password);
	long countByEmpCode(String empCode);
	List<User> findByEmpCode(String empCode);
	int deleteByEmpCode(String empCode);
	User findByEmail(String email);
	
	@Query(value = "select "
			+ "date(entry_date),"
			+ "count(emp_code) "
			+ "from admin_user "
			+ "where extract(year from entry_date) = extract(year from now()) "
			+ "group by date(entry_date);", nativeQuery = true)
	public List<Object[]> getUserAnalysis();
	
	
	@Query(value="select extract(month from entry_date) as month, "
			+ "sum(case when status = 'active' then 1 else 0 end) as active, "
			+ "sum(case when status = 'inactive' then 1 else 0 end) as inactive "
			+ "from admin_user "
			+ "where entry_date >= now()-interval '6 month' and extract(year from entry_date) = extract(year from now()) "
			+ "group by extract(month from entry_date)",nativeQuery=true)
	public List<Object[]> activeInactiveUser();

	
}