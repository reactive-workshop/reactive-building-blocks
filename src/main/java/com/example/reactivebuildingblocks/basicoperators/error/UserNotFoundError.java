package com.example.reactivebuildingblocks.basicoperators.error;

public class UserNotFoundError extends Exception{
    public UserNotFoundError() {
        super("User does not exist");
    }
}
