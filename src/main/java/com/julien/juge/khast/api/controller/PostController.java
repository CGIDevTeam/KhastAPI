package com.julien.juge.khast.api.controller;

import com.julien.juge.khast.api.dto.DtoBuilder;
import com.julien.juge.khast.api.dto.output.PostDto;
import com.julien.juge.khast.api.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
@Slf4j
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Observable<ResponseEntity<List<PostDto>>> getAllPosts() {
        return postService.getAllPost().map(DtoBuilder::buildListPostDtoOutput).map(ResponseEntity::ok).doOnError(e -> log.error("Erreur de recuperation des posts", e));
    }

}
