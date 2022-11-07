package org.hasandag;

import org.hasandag.entity.User;
import org.hasandag.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserRepository userRepository;


    @PostConstruct
    private void init(){
        User user = new User();
        user.setName("Hasan");
        user.setLastName("Oltu");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

}
