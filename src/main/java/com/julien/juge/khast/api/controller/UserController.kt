package com.julien.juge.khast.api.controller

import org.reactivecouchbase.json.JsObject
import org.reactivecouchbase.json.Json
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import rx.Observable


@RestController
@RequestMapping("/v1/users")
class UserController {

    private val LOGGER = LoggerFactory.getLogger(NotificationController::class.java)

    @ResponseBody
    @RequestMapping(
            method = [RequestMethod.GET]
    )
    fun getAllPosts(): Observable<ResponseEntity<JsObject>> {
        return Observable.just(ResponseEntity.ok(Json.obj().with("nom", "ducon")))
    }

}
