@file:Suppress("MayBeConstant")

object Modules {

    val app = ":app"

    val navigation = ":Navigation"

    val core = ":Core"
    val coreBase = ":CoreBase"

    val equipe = ":Equipe"
    val match = ":Match"

}

object Versions {

    val appCompat = "1.1.0-rc01"
    val constraintLayout = "2.0.0-beta2"
    val coreKtx = "1.2.0-alpha02"
    val joda = "2.10.1"
    val koin = "2.0.1"
    val kotlin = "1.3.41"
    val kotlinCoroutine = "1.3.0-RC"
    val lifecycle = "2.2.0-alpha02"
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
    val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleViewModel =  "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // Navigation
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"

    // Room
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}