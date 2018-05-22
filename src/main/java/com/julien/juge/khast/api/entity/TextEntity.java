package com.julien.juge.khast.api.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "Text")
public class TextEntity {

    private String text;

}
