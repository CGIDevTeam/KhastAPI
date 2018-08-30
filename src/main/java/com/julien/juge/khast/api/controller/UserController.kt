package com.julien.juge.khast.api.controller

import com.julien.juge.khast.api.dto.input.MailDto
import com.julien.juge.khast.api.dto.output.PostDto
import lombok.extern.slf4j.Slf4j
import org.reactivecouchbase.json.JsObject
import org.reactivecouchbase.json.Json
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import rx.Observable
import javax.validation.Valid


@RestController
@RequestMapping("/v1/users")
@Slf4j
class UserController {

    private val LOGGER = LoggerFactory.getLogger(NotificationController::class.java)

    @RequestMapping(method = arrayOf(RequestMethod.POST), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun users(@RequestBody @Valid mailDto: MailDto, errors: Errors): Observable<ResponseEntity<JsObject>> {
        return Observable.just(Json.obj().with("name", "son petit nom")).map { ResponseEntity.ok(it) }.doOnError { e -> LOGGER.error("Probleme de sauvegarde du post", e) }
    }


}
