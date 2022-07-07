package com.mongodsc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodsc.model.DistributerScoreCard;

@Repository
public interface DistributorMongoRepository extends MongoRepository<DistributerScoreCard, String>
{
	@Query("{'key' : ?0}")
	List<DistributerScoreCard> findByKey(String key);
}
