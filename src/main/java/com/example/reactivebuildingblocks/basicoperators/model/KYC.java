package com.example.reactivebuildingblocks.basicoperators.model;

public record KYC(String id, String userId, KYCDoc docType, String docNumber) {
    public static KYC noneKYC(){
        return new KYC("000", "000", KYCDoc.NONE, "000");
    }
}


