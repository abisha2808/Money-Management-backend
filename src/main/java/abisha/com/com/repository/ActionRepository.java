package abisha.com.com.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import abisha.com.com.entity.Action;

public interface ActionRepository extends MongoRepository<Action, String> {
       
	List<Action> findByRecordId(String recordId);
	
}
