package com.kenny.core.usecase

import io.reactivex.rxjava3.core.Single

fun <T, A> performGetOperation(databaseQuery: () -> Single<Any>,
                               networkCall: suspend () -> Single<Any>,
                               saveCallResult: suspend (A) -> Unit): Single<Any> =
    Single.create { emitter ->
        val source = databaseQuery.invoke().map { it }
        emitter.onSuccess(source)


    }
