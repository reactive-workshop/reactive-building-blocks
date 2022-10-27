package com.example.reactivebuildingblocks.eventstream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private long id;
    private String content;
}