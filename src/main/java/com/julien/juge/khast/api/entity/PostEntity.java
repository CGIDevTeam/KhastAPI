package com.julien.juge.khast.api.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Post")
public class PostEntity {

    @Id
    private String id;

    @CreatedDate
    private Date date;


}
