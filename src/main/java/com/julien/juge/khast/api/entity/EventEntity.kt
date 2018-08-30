package com.julien.juge.khast.api.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "Event")
class EventEntity {

    constructor(startDate: Date?, endDate: Date?, comment: String?, place: String?, price: Float?)

    @Id
    var id: String? = null
        set(id) {
            field = this.id
        }


    var startDate: Date? = null
        set(startDate) {
            field = this.startDate
        }

    var endDate: Date? = null
        set(endDate) {
            field = this.endDate
        }

    var place: String? = null
        set(place) {
            field = this.place
        }

    var comment: String? = null
        set(comment) {
            field = this.comment
        }

    var price: Float? = null
        set(price) {
            field = this.price
        }

}
