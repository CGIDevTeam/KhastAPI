package com.julien.juge.khast.api.service;

import com.julien.juge.khast.api.entity.PostEntity;
import com.julien.juge.khast.api.repository.PostRepository;
import com.julien.juge.khast.api.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    private TextRepository textRepository;

    @Autowired
    public PostService(PostRepository postRepository, TextRepository textRepository) {
        this.textRepository = textRepository;
        this.postRepository = postRepository;
    }

    public Observable<List<PostEntity>> getAllPost() {
        return Observable.just(postRepository.findAll());
    }

}
