package abisha.com.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import abisha.com.com.dto.SignupRequest;
import abisha.com.com.entity.User;
import abisha.com.com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private  UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET USER BY ID
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    // GET USER BY EMAIL
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // DELETE USER
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        return user;
    }
    
    
    public User signup(SignupRequest req) {

        if (req.getEmail() == null || req.getEmail().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is required");
        }
        if (req.getPassword() == null || req.getPassword().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required");
        }
        if (req.getName() == null || req.getName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
        }

        // ✅ this uses your boolean method (no repo return type change)
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail()); // or setEmail(email) depending on your entity field
        user.setPassword(req.getPassword()); // (later we can hash)

        return userRepository.save(user);
    }


}
