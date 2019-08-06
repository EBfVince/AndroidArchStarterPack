package com.test.core.remote

import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import com.test.core.di.createRemoteModule
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import java.io.File

abstract class BaseTest : AutoCloseKoinTest() {

    protected lateinit var mockServer: MockWebServer

    @Before
    open fun setup() {
        mockServer = MockWebServer()
        mockServer.start()
        startKoin {
            modules(createRemoteModule(mockServer.url("/").toString()))
        }
    }

    @After
    open fun tearDown(){
        mockServer.shutdown()
    }

    fun mockHttpResponse(mockServer: MockWebServer, fileName: String, responseCode: Int) = mockServer.enqueue(
        MockResponse()
            .setResponseCode(responseCode)
            .setBody(getJson(fileName)))

    private fun getJson(path : String) : String {
        val uri = this.javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

}