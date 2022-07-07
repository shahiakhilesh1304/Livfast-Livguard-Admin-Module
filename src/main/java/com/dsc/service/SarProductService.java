//package com.dsc.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.dsc.model.AchievementResponse;
//import com.dsc.model.Sar_product_serial_number_cstm;
//import com.dsc.repository.Sar_Product_SerialNumberRepository;
//import com.mongodsc.service.DistributerScoreCardService;
//
//@Service
//@Transactional("tertiaryTransactionManager")
//public class SarProductService {
//	
//	@Autowired
//	Sar_Product_SerialNumberRepository msAchRepo;
//	
//	private static final Logger log = LoggerFactory.getLogger(SarProductService.class);
//	
//	
//	public List<AchievementResponse> findAchievement()
//	{
//		
//		try {
//			AchievementResponse achievement = new AchievementResponse();
//			List<AchievementResponse> finalreport = new ArrayList<>();
//			List<Object[]> values = this.msAchRepo.getAchReport();
//			if(values.size() > 0)
//			{
//				for(Object[] v:values)
//				{
//					achievement = new AchievementResponse();
//					achievement.setPrimary_achive(v[0].toString());
//					achievement.setName(v[1].toString());
//					achievement.setAccount_code_c(v[2].toString());
//					finalreport.add(achievement);
//				}
//				return finalreport;
//			}
//		} catch (Exception e) {
//			log.info("Exception occured at findAchievement in SarProductService",e);
//		}
//		return null;
//	}
//	
//}
