package com.example.reactivebuildingblocks.basicoperators;

import com.example.reactivebuildingblocks.basicoperators.model.User;
import com.example.reactivebuildingblocks.basicoperators.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

}
