package com.example.reactivebuildingblocks.basicoperators.error;

public class KYCNotFoundError extends Exception{
    public KYCNotFoundError() {
        super("KYC does not exist");
    }
}
