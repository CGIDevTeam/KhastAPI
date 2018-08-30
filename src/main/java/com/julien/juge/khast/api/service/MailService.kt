package com.julien.juge.khast.api.service

import com.julien.juge.khast.api.dto.input.MailDto
import com.mailjet.client.ClientOptions
import com.mailjet.client.MailjetClient
import com.mailjet.client.MailjetRequest
import com.mailjet.client.MailjetResponse
import com.mailjet.client.errors.MailjetException
import com.mailjet.client.errors.MailjetSocketTimeoutException
import com.mailjet.client.resource.Emailv31
import lombok.extern.slf4j.Slf4j
import org.json.JSONArray
import org.json.JSONObject
import org.reactivecouchbase.json.JsObject
import org.reactivecouchbase.json.Json
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import rx.Observable

@Service
@Slf4j
class MailService {

    @Value("\${mailjet.apikey}")
    private val apikey: String? = null

    @Value("\${mailjet.apisecret}")
    private val apisecret: String? = null


    @Throws(MailjetSocketTimeoutException::class, MailjetException::class)
    fun sendNotificationEmail(mailDto: MailDto): Observable<JsObject> {

        val client: MailjetClient
        val request: MailjetRequest
        val response: MailjetResponse
        client = MailjetClient(apikey, apisecret, ClientOptions("v3.1"))
        request = MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, JSONArray()
                        .put(JSONObject()
                                .put(Emailv31.Message.FROM, JSONObject()
                                        .put("Email", "game.julien.juge@gmail.com")
                                        .put("Name", "KHAST"))
                                .put(Emailv31.Message.TO, JSONArray()
                                        .put(JSONObject()
                                                .put("Email", mailDto.emailAddress)
                                                .put("Name", mailDto.emailAddress)))
                                .put(Emailv31.Message.SUBJECT, mailDto.emailSubject)
                                .put(Emailv31.Message.TEXTPART, mailDto.emailBody)
                                .put(Emailv31.Message.HTMLPART, "<p>" + mailDto.emailBody + "</p>")))
        response = client.post(request)

        return if (response.status == 200) Observable.just(Json.obj().with("response", "ok")) else Observable.just(Json.obj().with("response", "ko"))

    }

}
