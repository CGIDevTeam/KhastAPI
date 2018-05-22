package com.julien.juge.khast.api.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "Event")
public class EventEntity {

    @Id
    private String id;

    private Date startDate;

    private Date endDate;

    private String place;

    private String comment;

    private Float price;

}
