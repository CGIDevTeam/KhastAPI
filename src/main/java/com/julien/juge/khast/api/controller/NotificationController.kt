package com.julien.juge.khast.api.controller

import com.julien.juge.khast.api.dto.input.MailDto
import com.julien.juge.khast.api.service.MailService
import com.julien.juge.khast.api.utils.BindingResultUtils
import com.mailjet.client.errors.MailjetException
import com.mailjet.client.errors.MailjetSocketTimeoutException
import org.reactivecouchbase.json.JsObject
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import rx.Observable
import javax.validation.Valid

@RestController
@RequestMapping("/v1/notifications")
class NotificationController(@Autowired val mailService: MailService) {

    // Loger !
    private val LOGGER = LoggerFactory.getLogger(NotificationController::class.java)

    @ResponseBody
    @RequestMapping(
            "",
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE],
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE]
    )
    @Throws(MailjetSocketTimeoutException::class, MailjetException::class)
    fun sendNotificationEmail(@RequestBody @Valid mailDto: MailDto, errors: Errors): Observable<ResponseEntity<JsObject>> {

        BindingResultUtils.checkErrors(errors)

        return mailService!!.sendNotificationEmail(mailDto).map { ResponseEntity.ok(it) }.doOnError{LOGGER.error("Problem during notification email send", it)}


    }


}
