package com.test.match.view

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.test.core.model.Match
import com.test.core.repository.utils.Resource

object MatchBinding {

    @JvmStatic
    @BindingAdapter("score")
    fun showScore(text: TextView, res: Resource<Match>?) {
        res?.data?.let { match ->
            text.text = "${match.nbButsDom} - ${match.nbButsVis}"
        }
    }

}