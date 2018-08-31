package com.julien.juge.khast.api.entity

import com.julien.juge.khast.api.dto.input.PostDto
import org.springframework.stereotype.Service

@Service
object EntityBuilder {

    fun buildListPostEntity(posts: List<PostDto>): List<PostEntity> {
        return posts.map { buildPostEntity(it) }
    }

    fun buildPostEntity(post: PostDto): PostEntity {
        return PostEntity(post?.createdDate, buildEventEntity(post?.event!!), buildTextEntity(post.text?.text))
    }

    fun buildEventEntity(event: com.julien.juge.khast.api.dto.input.EventDto): EventEntity {
        return EventEntity(event.startDate, event.endDate, event.comment, event.place, event.price)
    }


    fun buildTextEntity(text: String?): TextEntity? {
        return TextEntity(text)
    }

}
