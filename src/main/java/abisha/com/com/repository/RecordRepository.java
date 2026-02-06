package abisha.com.com.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import abisha.com.com.entity.MoneyRecord;

@Repository
public interface RecordRepository  extends MongoRepository<MoneyRecord, String> {
     
	List<MoneyRecord> findByCreatedBy(String createdBy);

    
}
