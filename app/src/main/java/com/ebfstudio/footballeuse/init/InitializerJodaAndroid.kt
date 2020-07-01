package com.ebfstudio.footballeuse.init

import android.content.Context
import androidx.startup.Initializer
import net.danlew.android.joda.JodaTimeAndroid

/**
 * Created by Vincent Guillebaud on 01/07/2020
 */
class InitializerJodaAndroid : Initializer<Unit> {

    override fun create(context: Context) = JodaTimeAndroid.init(context)

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()

}