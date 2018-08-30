package com.julien.juge.khast.api.dto.input

import java.util.*
import javax.validation.constraints.NotNull

class EventDto {

    @NotNull(message = "La date de debut est obligatoire")
    var startDate: Date? = null

    var endDate: Date? = null

    @NotNull(message = "L'emplacement est obligatoire")
    var place: String? = null

    var comment: String? = null

    var price: Float? = null

}
