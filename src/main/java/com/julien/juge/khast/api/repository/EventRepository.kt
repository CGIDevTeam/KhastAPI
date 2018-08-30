package com.julien.juge.khast.api.repository

import com.julien.juge.khast.api.entity.EventEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : MongoRepository<EventEntity, String>
