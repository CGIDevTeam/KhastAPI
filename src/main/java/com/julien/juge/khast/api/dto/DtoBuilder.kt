package com.julien.juge.khast.api.dto

import com.julien.juge.khast.api.entity.EventEntity
import com.julien.juge.khast.api.entity.PostEntity
import com.julien.juge.khast.api.entity.TextEntity
import org.reactivecouchbase.json.JsArray
import org.reactivecouchbase.json.JsObject
import org.reactivecouchbase.json.JsValue
import org.reactivecouchbase.json.Json
import org.springframework.stereotype.Service

@Service
object DtoBuilder {

    fun buildListPostDtoOutput(posts: List<PostEntity>): JsArray {

        var jsValue: List<JsObject> = posts.map { postEntity: PostEntity -> DtoBuilder.buildPostDtoOutput(postEntity) }
        var jsArray: JsArray = Json.array(jsValue)
        return jsArray
    }

    fun buildPostDtoOutput(postEntity: PostEntity): JsObject {
        return Json.obj().with("date", postEntity.date.toString())
                .with("event", buildEventDtoOutput(postEntity?.event))
                .with("text", buildTextDtoOutput(postEntity?.text))
    }

    fun buildEventDtoOutput(eventEntity: EventEntity?): JsObject {
        return Json.obj().with("comment", eventEntity?.comment)
                .with("endDate", eventEntity?.endDate?.toString())
                .with("place", eventEntity?.place)
                .with("startDate", eventEntity?.startDate?.toString())
    }

    fun buildTextDtoOutput(textEntity: TextEntity?): JsObject? {
        return Json.obj().with("text", textEntity?.text)
    }


}
