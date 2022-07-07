//package com.dsc.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.dsc.model.Sar_product_serial_number_cstm;
//
//@Repository
//public interface Sar_Product_SerialNumberRepository extends JpaRepository<Sar_product_serial_number_cstm, String> {
//
//	@Query(value="SELECT COUNT(distinct p.productSerialId) AS primary_achive ,d.name,b.account_code_c "
//			+ "FROM sar_product_serial_number_cstm b "
//			+ "INNER JOIN sar_product_serial_number a ON a.id=b.id_c "
//			+ "inner join tblProductSerialNum1 p on p.serial_num=a.name "
//			+ "INNER JOIN (select distinct id,aos_product_category_id from aos_products) c ON c.id =b.aos_products_id_c "
//			+ "INNER JOIN aos_product_categories d ON d.id=c.aos_product_category_id "
//			+ "WHERE a.deleted = 0 "
//			+ "group by d.name,b.account_code_c",nativeQuery=true)
//	List<Object[]> getAchReport();
//}
