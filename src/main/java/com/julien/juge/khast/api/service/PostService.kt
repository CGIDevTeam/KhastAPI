package com.julien.juge.khast.api.service

import com.julien.juge.khast.api.entity.PostEntity
import com.julien.juge.khast.api.repository.PostRepository
import com.julien.juge.khast.api.repository.TextRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import rx.Observable

@Service
class PostService @Autowired
constructor(private val postRepository: PostRepository, private val textRepository: TextRepository) {

    fun getPosts(): Observable<List<PostEntity>> {
        return Observable.just(postRepository.findAll())
    }

    fun savePost(post: PostEntity): Observable<Boolean> {
        return Observable.just(postRepository.save(post)).map { true }
    }

}
