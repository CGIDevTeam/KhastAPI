package com.julien.juge.khast.api.dto;

import com.julien.juge.khast.api.dto.output.PostDto;
import com.julien.juge.khast.api.entity.PostEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtoBuilder {

    public static List<PostDto> buildListPostDtoOutput(List<PostEntity> posts) {
        return io.vavr.collection.List.ofAll(posts).map(DtoBuilder::buildPostDtoOutput).toJavaList();
    }

    public static PostDto buildPostDtoOutput(PostEntity postEntity) {
        return PostDto.builder().createdDate(postEntity.getDate()).id(postEntity.getId()).build();
    }

}
