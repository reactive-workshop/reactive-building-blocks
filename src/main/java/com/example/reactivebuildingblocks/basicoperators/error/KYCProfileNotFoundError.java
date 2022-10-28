package com.example.reactivebuildingblocks.basicoperators.error;

public class KYCProfileNotFoundError extends Exception{
    public KYCProfileNotFoundError() {
        super("KYC Profile does not exist");
    }
}
