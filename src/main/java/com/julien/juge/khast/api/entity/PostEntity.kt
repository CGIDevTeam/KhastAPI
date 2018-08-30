package com.julien.juge.khast.api.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "Post")
class PostEntity {

    constructor(date: Date?, event: EventEntity?, text: TextEntity?)

    @Id
    var id: String? = null
        set(id) {
            field = this.id
        }

    var date: Date? = null
        set(date) {
            field = this.date
        }

    var event: EventEntity? = null
        set(event) {
            field = this.event
        }

    var text: TextEntity? = null
        set(text) {
            field = this.text
        }
}
