package com.example.reactivebuildingblocks.basicoperators.repository;

import com.example.reactivebuildingblocks.basicoperators.model.KYC;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface KYCRepository extends ReactiveMongoRepository<KYC, String> {
    Mono<KYC> findFirstByUserId(String userId);
}
