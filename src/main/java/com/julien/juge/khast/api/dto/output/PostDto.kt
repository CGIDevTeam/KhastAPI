package com.julien.juge.khast.api.dto.output

import java.util.*

class PostDto {

    constructor(createdDate: Date?, id: String?, event: EventDto?, text: TextDto?)

    var id: String? = null
        set(id) {
            field = this.id
        }

    var createdDate: Date? = null
        set(createdDate) {
            field = this.createdDate
        }

    var event: EventDto? = null
        set(event) {
            field = this.event
        }

    var text: TextDto? = null
        set(text) {
            field = this.text
        }

}
