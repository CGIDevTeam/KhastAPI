package com.julien.juge.khast.api.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Text")
class TextEntity {

    constructor(text: String?)

    var text: String? = null
        set(text) {
            field = this.text
        }

}
