package com.julien.juge.khast.api.controller

import com.julien.juge.khast.api.dto.DtoBuilder
import com.julien.juge.khast.api.dto.output.PostDto
import com.julien.juge.khast.api.entity.EntityBuilder
import com.julien.juge.khast.api.entity.PostEntity
import com.julien.juge.khast.api.service.PostService
import org.reactivecouchbase.json.JsArray
import org.reactivecouchbase.json.JsObject
import org.reactivecouchbase.json.JsValue
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import rx.Observable
import javax.validation.Valid

@RestController
@RequestMapping("/v1/posts")
open class PostController(@Autowired val postService: PostService, @Autowired val dtoBuilder: DtoBuilder) {

    private val LOGGER = LoggerFactory.getLogger(PostController::class.java)

    /**
     * @api {get} /v1/posts Recuperation de tous les posts presents
     * @apiGroup Post
     * @apiName getAllPosts
     * @apiDescription Recupere tous les posts sans disctinctions
     * @apiVersion 1.0.0
     * @apiHeader {String} Authorization Token de l'utilisateur
     *
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * [
     * {
     * "id": "5b02de5310e77a205cee87cc",
     * "createdDate": "2018-05-21T16:00:00.000+0000",
     * "event": {
     * "startDate" : "2018-05-22T18:00:00.000+0000",
     * "place" : "Minute Blonde",
     * }
     * },
     * {
     * "id": "5b041db7f83b362d545bee0b",
     * "createdDate": "2018-05-21T17:00:00.000+0000",
     * "text": {
     * "text" : "Un super post avec que du texte"
     * }
     * }
     * ]
     */
    @RequestMapping(
            path = [""],
            method = [RequestMethod.GET],
            consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE],
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE]
    )
    fun getAllPosts(): Observable<ResponseEntity<JsArray>> {
        return postService.getPosts()

                .map { dtoBuilder.buildListPostDtoOutput(it)}
                .map { ResponseEntity.ok(it) }
                .doOnError { e -> LOGGER.error("Probleme de sauvegarde du post", e) }
    }

    /**
     * @api {post} /v1/posts Sauvegarde d'un post
     * @apiGroup Post
     * @apiName savePost
     * @apiDescription Permet de sauvegarder un post (event, text)
     * @apiVersion 1.0.0
     * @apiHeader {String} Authorization Token de l'utilisateur
     * @apiParam {Date} createdDate Date de creation
     * @apiParam (Text) {String} text Texte du post
     * @apiParam (Event) {Date} startDate Date de debut de l'evenement
     * @apiParam (Event) {Date} [endDate] Date de fin de l'evenement
     * @apiParam (Event) {String} [comment] Commentaire de l'evenement
     * @apiParam (Event) {String} [price] Prix de l'evenement
     * @apiParam (Event) {String} place Emplacement de l'evenement
     * @apiParamExample {json} Request-Example:
     * {
     * "createdDate": "2018-05-22T18:00:00",
     * "text": {
     * "text": "Un super post !!!!!!"
     * }
     * }
     * @apiParamExample {json} Minimal-Event-Request-Example:
     * {
     * "createdDate": "2018-05-22T18:00:00",
     * "event": {
     * "startDate": "2018-05-22T18:00:00",
     * "place": "Minute Blonde"
     * }
     * }
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "success": 1
     * }
     */
    @ResponseBody
    @RequestMapping(
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE],
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE]
    )
    fun savePost(@RequestBody @Valid postInput: com.julien.juge.khast.api.dto.input.PostDto): Observable<ResponseEntity<Boolean>> {
        return postService.savePost(EntityBuilder.buildPostEntity(postInput))
                .map { ResponseEntity.ok(it) }
                .doOnError { e -> LOGGER.error("Probleme de sauvegarde du post", e) }
    }

}
