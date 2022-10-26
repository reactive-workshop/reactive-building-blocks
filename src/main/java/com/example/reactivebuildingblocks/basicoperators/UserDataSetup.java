package com.example.reactivebuildingblocks.basicoperators;

import com.example.reactivebuildingblocks.basicoperators.model.KYC;
import com.example.reactivebuildingblocks.basicoperators.model.KYCDoc;
import com.example.reactivebuildingblocks.basicoperators.model.User;
import com.example.reactivebuildingblocks.basicoperators.repository.KYCRepository;
import com.example.reactivebuildingblocks.basicoperators.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Arrays.asList;

@Component
public class UserDataSetup implements InitializingBean {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KYCRepository kycRepository;

    @Override
    public void afterPropertiesSet() {
        User fooBar = new User("10001", "Foo Bar", "F", 18, "123456789");
        User barBaz = new User("10002", "Bar Baz", "M", 28, "123456788");
        User bazball = new User("10003", "Baz Ball", "F", 43, "123456787");
        User jakeBall = new User("10004", "Jake Ball", "F", 13, "123456786");
        User willSmith = new User("10005", "Will Smith", "M", 53, "123456785");

        KYC kyc1 = new KYC(UUID.randomUUID().toString(), "10001", KYCDoc.AADHAAR, "12345");
        KYC kyc2 = new KYC(UUID.randomUUID().toString(), "10002", KYCDoc.PAN, "12348");
        KYC kyc3 = new KYC(UUID.randomUUID().toString(), "10003", KYCDoc.DL, "12340");
        KYC kyc4 = new KYC(UUID.randomUUID().toString(), "10005", KYCDoc.VOTER_ID, "12349");

        userRepository
                .deleteAll()
                .then(userRepository.saveAll(asList(fooBar, barBaz, bazball, jakeBall, willSmith)).then())
                .subscribe();

        kycRepository
                .deleteAll()
                .then(kycRepository.saveAll(asList(kyc1, kyc2, kyc3, kyc4)).then())
                .subscribe();
    }
}
