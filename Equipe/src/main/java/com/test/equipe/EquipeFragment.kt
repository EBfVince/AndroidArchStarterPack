package com.test.equipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.test.common.base.BaseFragment
import com.test.common.base.BaseViewModel
import com.test.equipe.databinding.FragmentEquipeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class EquipeFragment : BaseFragment() {

    private val viewModel: EquipeViewModel by viewModel()
    private lateinit var binding: FragmentEquipeBinding

    private val args: EquipeFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEquipeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.loadEquipe(args.idEquipe)
    }

    override fun getViewModel(): BaseViewModel = viewModel

}