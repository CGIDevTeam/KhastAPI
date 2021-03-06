package com.julien.juge.khast.api.utils.exception


/**
 * Exception to throw in utility classes constructor.
 *
 *
 * Utility classes should not have public constructors
 *
 *
 * Utility classes, which are collections of static members, are not meant to be instantiated.
 * Even abstract utility classes, which can be extended, should not have public constructors.
 * Java adds an implicit public constructor to every class which does not define at least one explicitly.
 * Hence, at least one non-public constructor should be defined.
 */
class ForbiddenInstanciationException : IllegalStateException() {
    init {
        throw IllegalStateException("Utility class : instanciation is forbidden")
    }
}
