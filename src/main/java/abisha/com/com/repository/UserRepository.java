package abisha.com.com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import abisha.com.com.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
     
	    User findByEmail(String email);

	    boolean existsByEmail(String email);
}
