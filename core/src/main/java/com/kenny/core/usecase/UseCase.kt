package com.kenny.core.usecase

import io.reactivex.rxjava3.core.Single


abstract class SingleUseCase<T, R : Any> {
    abstract fun execute(input: T): Single<R>
}

abstract class UseCase<T, R> {
    abstract fun execute(input: T): R
}