package com.ebfstudio.footballeuse.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ebfstudio.footballeuse.autoCleared
import com.ebfstudio.footballeuse.databinding.FragmentNotificationsBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class NotificationsFragment : Fragment() {

    private val notificationsViewModel: NotificationsViewModel by viewModel()
    private var binding: FragmentNotificationsBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = notificationsViewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotifications.text = it
        })

        notificationsViewModel.articles.observe(viewLifecycleOwner, Observer {
            Log.d("Vince", "==== ${it.status} ====")
            it.data?.map { article -> Log.d("Vince", "$article") }
            Log.d("Vince", "======================")
        })

    }

}