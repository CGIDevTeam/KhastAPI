package com.julien.juge.khast.api.utils.exception

open class BusinessException(message: String, vararg args: Any) : RuntimeException(String.format(message, *args))
