package com.julien.juge.khast.api.dto.input

import javax.validation.constraints.NotNull

class MailDto {

    @NotNull(message = "L'adresse email est obligatoire")
    var emailAddress: String? = null

    @NotNull(message = "Le contenu du message est obligatoire")
    var emailBody: String? = null

    @NotNull(message = "Le sujet du message est obligatoire")
    var emailSubject: String? = null

}
