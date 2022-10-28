package com.example.reactivebuildingblocks.basicoperators.repository;

import com.example.reactivebuildingblocks.basicoperators.model.KYC;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryKYCRepository {
    private List<KYC> kycs = new ArrayList<>();

    public Mono<KYC> findFirstByUserId(String userId) {
        return Mono.just(kycs.stream().filter(k -> k.userId().equals(userId)).findFirst().get());
    }

    public void deleteAll() {
        this.kycs.clear();
    }

    public void saveAll(List<KYC> kycs) {
        this.kycs.addAll(kycs);
    }
}
