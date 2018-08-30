package com.julien.juge.khast.api.dto

import com.julien.juge.khast.api.dto.output.EventDto
import com.julien.juge.khast.api.dto.output.PostDto
import com.julien.juge.khast.api.dto.output.TextDto
import com.julien.juge.khast.api.entity.EventEntity
import com.julien.juge.khast.api.entity.PostEntity
import com.julien.juge.khast.api.entity.TextEntity
import org.springframework.stereotype.Service

@Service
object DtoBuilder {

    fun buildListPostDtoOutput(posts: List<PostEntity>): List<PostDto> {
        return posts.map { postEntity: PostEntity -> DtoBuilder.buildPostDtoOutput(postEntity) }
    }

    fun buildPostDtoOutput(postEntity: PostEntity): PostDto {
        return PostDto(postEntity.date, postEntity.id, DtoBuilder.buildEventDtoOutput(postEntity.event), DtoBuilder.buildTextDtoOutput(postEntity.text))
    }

    fun buildEventDtoOutput(eventEntity: EventEntity?): EventDto {
        return EventDto(eventEntity!!.comment, eventEntity!!.endDate, eventEntity!!.place, eventEntity!!.price, eventEntity!!.startDate)
    }

    fun buildTextDtoOutput(textEntity: TextEntity?): TextDto? {
        return TextDto(textEntity!!.text)
    }


}
