package com.example.reactivebuildingblocks.basicoperators.repository;

import com.example.reactivebuildingblocks.basicoperators.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryUserRepository {

    private List<User> users = new ArrayList<>();
    public Mono<User> findById(String id) {
        Optional<User> user = this.users.stream().filter(u -> u.id().equals(id)).findFirst();
        return user.map(Mono::just).orElseGet(Mono::empty);
    }

    public Flux<User> findAll() {
        return Flux.fromStream(this.users.stream());
    }

    public Flux<User> findByNameContaining(String namePart) {
        return Flux.fromStream(this.users.stream().filter(u -> u.name().contains(namePart)));
    }

    public Mono<User> findFirstByMobile(String mobile) {
        Optional<User> user = this.users.stream().filter(u -> u.mobile().equalsIgnoreCase(mobile))
                .findFirst();
        return user.map(Mono::just).orElseGet(Mono::empty);
    }

    public void deleteAll() {
        this.users.clear();
    }

    public void saveAll(List<User> users) {
        this.users.addAll(users);
    }
}
