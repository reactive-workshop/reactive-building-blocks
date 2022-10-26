package com.example.reactivebuildingblocks.basicoperators.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record User(
        String id,
        String name,
        String gender,
        int age,
        String mobile) {
}
