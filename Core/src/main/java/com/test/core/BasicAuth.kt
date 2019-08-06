package com.test.core

data class BasicAuth(
    val apiKey: String,
    val login: String,
    val password: String
) {

    override fun toString() = "$apiKey;$login:$password"

}