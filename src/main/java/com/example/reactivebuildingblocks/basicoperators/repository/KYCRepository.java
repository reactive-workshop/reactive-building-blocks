package com.example.reactivebuildingblocks.basicoperators.repository;

import com.example.reactivebuildingblocks.basicoperators.model.KYC;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KYCRepository extends ReactiveMongoRepository<KYC, String> {

}
