package com.julien.juge.khast.api.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Text")
public class TextEntity {

    private String text;

}
