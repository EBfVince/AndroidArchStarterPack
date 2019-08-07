@file:Suppress("MayBeConstant")

object Modules {

    val app = ":app"

    val navigation = ":Navigation"

    val core = ":Core"
    val common = ":Common"

    val equipe = ":Equipe"
    val match = ":Match"

}

object Versions {

    val androidJunit = "1.1.2-alpha02"
    val androidTestRunner = "1.3.0-alpha02"
    val appCompat = "1.1.0-rc01"
    val archCoreTest = "2.1.0-rc01"
    val constraintLayout = "1.1.3"
    val coreKtx = "1.2.0-alpha02"
    val databinding = "3.3.2"
    val espressoCore = "3.3.0-alpha02"
    val fragmentTest = "1.1.0-alpha06"
    val joda = "2.10.1"
    val koin = "2.0.1"
    val kotlin = "1.3.41"
    val kotlinCoroutine = "1.3.0-RC"
    val lifecycle = "2.2.0-alpha02"
    val liveDataTest = "1.1.0"
    val mockk = "1.9.2"
    val mockwebserver = "2.7.5"
    val navigation = "2.1.0-beta02"
    val retrofit = "2.6.1"
    val room = "2.2.0-alpha01"

}

object Libs {

    val joda = "net.danlew:android.joda:${Versions.joda}"

    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val kotlinCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutine}"
    val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutine}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

}

object AndroidLibs {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    // Lifecycle
    // https://developer.android.com/jetpack/androidx/releases/lifecycle
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    val lifecycleViewModel =  "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // Navigation
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"

    // Room
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}

object TestLibs {

    // Junit
    val junit = "androidx.test.ext:junit:${Versions.androidJunit}"

    // Android test
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"
    val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"

    // Kotlin Coroutine
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutine}"

    // Koin
    val koin = "org.koin:koin-test:${Versions.koin}"

    // Mockk
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"

    // Espresso
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"

    // Mock WebServer
    val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"

    // LiveData
    val liveData = "com.jraska.livedata:testing-ktx:${Versions.liveDataTest}"

}