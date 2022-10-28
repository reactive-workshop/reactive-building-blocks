package com.example.reactivebuildingblocks.basicoperators.error;

public class ApplicationError extends Exception{
    public ApplicationError() {
        super("Something Went Wrong");
    }
}
