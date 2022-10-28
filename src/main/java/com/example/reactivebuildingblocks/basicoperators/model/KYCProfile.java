package com.example.reactivebuildingblocks.basicoperators.model;


public record KYCProfile(String userId,
         String name,
         String gender,
         int age,
         KYCDoc documentType, String documentNumber) {
}
