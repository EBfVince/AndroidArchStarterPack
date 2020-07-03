package com.ebfstudio.footballeuse.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebfstudio.footballeuse.autoCleared
import com.ebfstudio.footballeuse.databinding.FragmentNotificationsBinding
import com.ebfstudio.footballeuse.ui.notifications.viewholder.ArticleListAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class NotificationsFragment : Fragment() {

    private var binding: FragmentNotificationsBinding by autoCleared()
    private val notificationsViewModel: NotificationsViewModel by viewModel()

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

        val adapter = ArticleListAdapter { }
        binding.postsRecyclerView.adapter = adapter
        binding.postsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        notificationsViewModel.articles.data.observe(viewLifecycleOwner, Observer {
            Log.d("Vince", it.toString())
        })

    }

}