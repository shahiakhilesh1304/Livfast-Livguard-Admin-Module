package com.livguard.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.livguard.repository.MonthlySlabRepository;

@Service
@Transactional("primaryTransactionManager")
public class MonthlySlabsService 
{
	private static final Logger log = LoggerFactory.getLogger(SchemeService.class);
	
	@Autowired
	MonthlySlabRepository msRepo;
	
	
	
}
