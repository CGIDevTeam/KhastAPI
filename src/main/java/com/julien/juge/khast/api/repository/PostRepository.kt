package com.julien.juge.khast.api.repository

import com.julien.juge.khast.api.entity.PostEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : MongoRepository<PostEntity, String>
