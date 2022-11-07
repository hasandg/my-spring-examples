package com.hasandag.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private String id;
    @Field(name= "name", type = FieldType.Text)
    private String name;
    @Field(name= "lastName", type = FieldType.Text)
    private String lastName;
    @Field(name= "address", type = FieldType.Text)
    private String address;
    @Field(name= "birthDay", type = FieldType.Date)
    private Date birthDay;

}
