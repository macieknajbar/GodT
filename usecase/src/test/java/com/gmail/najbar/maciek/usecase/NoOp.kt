package com.gmail.najbar.maciek.usecase

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

object NoOp {

    fun <T> of(clazz: Class<T>): T {
        return Proxy.newProxyInstance(clazz.classLoader, arrayOf(clazz), HANDLER) as T
    }

    private val HANDLER = InvocationHandler { proxy, method, args ->
        return@InvocationHandler when (method.returnType) {
            Boolean::class.java -> false
            Byte::class.java -> 0.toByte()
            Short::class.java -> 0.toShort()
            Int::class.java -> 0
            Long::class.java -> 0L
            Float::class.java -> 0.0f
            Double::class.java -> 0.0
            String::class.java -> ""
            else -> null
        }
    }
}