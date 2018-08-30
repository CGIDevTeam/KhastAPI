package com.julien.juge.khast.api.dto.input

import javax.validation.constraints.NotNull

class TextDto {

    @NotNull(message = "Le texte du post est obligatoire")
    var text: String? = null

}
