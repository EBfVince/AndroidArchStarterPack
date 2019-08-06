package com.test.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.common.base.BaseFragment
import com.test.common.base.BaseViewModel
import com.test.match.databinding.FragmentMatchBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MatchFragment : BaseFragment() {

    private val viewModel: MatchViewModel by viewModel()
    private lateinit var binding: FragmentMatchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun getViewModel(): BaseViewModel = viewModel

}