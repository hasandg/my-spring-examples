package org.hasandag.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
@Data
public class User {
    private String id;
    private String name;
    private String lastName;
    private HashMap properties;

}
