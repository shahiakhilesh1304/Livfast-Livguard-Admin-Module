package com.mongodsc.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.dsc.model.AchievementResponse;
//import com.dsc.service.SarProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodsc.model.Data;
import com.mongodsc.model.DistributerScoreCard;
import com.mongodsc.repository.DistributorMongoRepository;

@Service
public class DistributerScoreCardService 
{
	private static final Logger log = LoggerFactory.getLogger(DistributerScoreCardService.class);
	
	@Autowired
	DistributorMongoRepository mongoRepo;
	
//	@Autowired
//	SarProductService msRespo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	public List<Data> getScoreCard()
	{
		try {
//			List<AchievementResponse> achReport = this.msRespo.findAchievement();
//			if(achReport.size() > 0 )
//			{
				List<DistributerScoreCard> mongoDSCList = this.mongoRepo.findAll();
				List<Data> data = new ArrayList<>();
				if(mongoDSCList != null)
				{
					Data d = new Data();
					for(DistributerScoreCard dsc:mongoDSCList)
					{
						d =  new Data();
						d.setData(dsc.getData());
						data.add(d);
					}
					return data;
				}	
//			}
		} catch (Exception e) {
			log.info("Exception occured at getScroeCard in DistributerScoreCardService={}",e);
		}
		return null;
	}
}
