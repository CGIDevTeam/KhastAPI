package com.julien.juge.khast.api.dto.output

import java.util.*

class EventDto {

    constructor(comment: String?, endDate: Date?, place: String?, price: Float?, startDate: Date?)

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
