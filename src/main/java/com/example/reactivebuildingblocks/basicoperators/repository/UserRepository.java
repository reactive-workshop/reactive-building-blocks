package com.example.reactivebuildingblocks.basicoperators.repository;

import com.example.reactivebuildingblocks.basicoperators.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
