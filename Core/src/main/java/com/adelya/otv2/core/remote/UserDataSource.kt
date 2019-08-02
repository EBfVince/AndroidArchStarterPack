package com.adelya.otv2.core.remote

/*class UserDataSource(private val userService: UserService) {

    suspend fun connect(login: String, pwd: String): Response<User> {

        val basicAuth = BasicAuth(CoreConstants.DEFAULT_APIKEY, login, pwd)

        val json = JSONObject()
        json.put("login", login)
        json.put("action", "connect")
        // json.put("mobileKey", mobileKey)

        val header = "Basic " + Base64.encodeToString(
            basicAuth.toString().toByteArray(),
            Base64.NO_WRAP
        )

        return userService.connect(
            headerAuth = header,
            json_header = json.toString()
        )

    }



}*/