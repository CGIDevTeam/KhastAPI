package com.julien.juge.khast.api.entity;

import com.julien.juge.khast.api.dto.input.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityBuilder {

    public static List<PostEntity> buildListPostEntity(List<PostDto> posts) {
        return io.vavr.collection.List.ofAll(posts).map(EntityBuilder::buildPostEntity).toJavaList();
    }

    public static PostEntity buildPostEntity(PostDto post) {
        return PostEntity.builder()
                .date(post.getCreatedDate())
                .event(EntityBuilder.buildEventEntity(post.getEvent()))
                .text(EntityBuilder.buildTextEntity(post.getText()))
                .build();
    }

    public static EventEntity buildEventEntity(com.julien.juge.khast.api.dto.input.EventDto event) {
        return null != event ? EventEntity.builder().comment(event.getComment()).endDate(event.getEndDate()).startDate(event.getStartDate()).place(event.getPlace()).price(event.getPrice()).build() : null;
    }

    public static TextEntity buildTextEntity(com.julien.juge.khast.api.dto.input.TextDto text) {
        return null != text ? TextEntity.builder()
                .text(text.getText())
                .build() : null;
    }

}
