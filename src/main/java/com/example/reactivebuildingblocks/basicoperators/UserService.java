package com.example.reactivebuildingblocks.basicoperators;

import com.example.reactivebuildingblocks.basicoperators.error.KYCNotFoundError;
import com.example.reactivebuildingblocks.basicoperators.error.KYCProfileNotFoundError;
import com.example.reactivebuildingblocks.basicoperators.error.UserNotFoundError;
import com.example.reactivebuildingblocks.basicoperators.model.KYC;
import com.example.reactivebuildingblocks.basicoperators.model.KYCProfile;
import com.example.reactivebuildingblocks.basicoperators.model.User;
import com.example.reactivebuildingblocks.basicoperators.repository.InMemoryKYCRepository;
import com.example.reactivebuildingblocks.basicoperators.repository.InMemoryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private InMemoryUserRepository userRepository;
    @Autowired
    private InMemoryKYCRepository kycRepository;

    private static KYCProfile buildKycProfile(User user, KYC kyc) {
        return new KYCProfile(user.id(), user.name(), user.gender(), user.age(), kyc.docType(), kyc.docNumber());
    }

    public Mono<User> getUserById(String id) {
        return userRepository
                .findById(id)
                .switchIfEmpty(Mono.error(UserNotFoundError::new));
    }

    public Mono<KYC> getKycByUserId(String userId) {
        return kycRepository
                .findFirstByUserId(userId)
                .switchIfEmpty(Mono.error(KYCNotFoundError::new));
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Flux<User> findUserByName(String namePart) {
        return userRepository.findByNameContaining(namePart);
    }

    public Flux<User> getAllUsersPIIMasked() {
        return getAllUsers()
                .map(user ->
                        new User(user.id(), "###", user.gender(), user.age(), "***")
                );
    }

    public Flux<User> aboveEighteen() {
        return getAllUsers().filter(user -> user.age() > 18);
    }

    public Mono<KYCProfile> getKycProfileByMobile(String mobile) {
        return userRepository
                .findFirstByMobile(mobile)
                .flatMap(user -> kycRepository
                        .findFirstByUserId(user.id())
                        .map(kyc -> buildKycProfile(user, kyc)));
    }

    public Mono<KYCProfile> getKycProfileByUserId(String userId) {
        Mono<User> user = getUserById(userId)
                .onErrorMap(UserNotFoundError.class, (e) -> new KYCProfileNotFoundError());

        Mono<KYC> kyc = getKycByUserId(userId)
                .onErrorResume(KYCNotFoundError.class, (e) -> Mono.just(KYC.noneKYC()));
        return Mono.zip(user, kyc, UserService::buildKycProfile);
    }
}
