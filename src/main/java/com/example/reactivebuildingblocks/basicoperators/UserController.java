package com.example.reactivebuildingblocks.basicoperators;

import com.example.reactivebuildingblocks.basicoperators.model.KYC;
import com.example.reactivebuildingblocks.basicoperators.model.KYCProfile;
import com.example.reactivebuildingblocks.basicoperators.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{user-id}")
    public Mono<User> getUser(@PathVariable(value = "user-id") String userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/{user-id}/kyc")
    public Mono<KYC> getKyc(@PathVariable(value = "user-id") String userId){
        return userService.getKycByUserId(userId);
    }

    @GetMapping("/all")
    public Flux<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/find-user")
    public Flux<User> findUser(@RequestParam(value = "namePart") String namePart) {
        return userService.findUserByName(namePart);
    }

    @GetMapping("/all/pii-masked")
    public Flux<User> allPIIMasked() {
        return userService.getAllUsersPIIMasked();
    }

    @GetMapping("/kyc-profile")
    public Mono<KYCProfile> kycProfileByMobile(@RequestParam(value = "mobile") String mobile) {
        return userService.getKycProfileByMobile(mobile);
    }

    @GetMapping("/{user-id}/kyc-profile")
    public Mono<KYCProfile> kycProfileByUserId(@PathVariable(value = "user-id") String userId) {
        return userService.getKycProfileByUserId(userId);
    }

    @GetMapping("/above-eighteen")
    public Flux<User> aboveEighteen() {
        return userService.aboveEighteen();
    }
}
