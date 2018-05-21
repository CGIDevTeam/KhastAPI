package com.julien.juge.khast.api.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Event")
public class EventEntity {

    private Date startDate;

    private Date endDate;

    private String place;

    private String comment;

    private Float price;

}
