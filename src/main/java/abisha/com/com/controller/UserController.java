package abisha.com.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abisha.com.com.dto.LoginRequest;
import abisha.com.com.dto.SignupRequest;
import abisha.com.com.entity.User;
import abisha.com.com.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173",
"https://money-management-frontend.vercel.app")
public class UserController {
	
	@Autowired
    private UserService userService;

    // CREATE USER
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            User user = userService.login(req.getEmail(), req.getPassword());

            // IMPORTANT: don't send password back
            user.setPassword(null);

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
    }

  
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        try {
            User user = userService.signup(req);

            // IMPORTANT: don't send password back
            user.setPassword(null);

            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (org.springframework.web.server.ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Signup failed");
        }
    }

}
