package com.appa.view.fragment.dashboard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.appa.R
import com.appa.databinding.FragmentMainBinding
import com.appa.utils.extensions.provideViewModel
import com.appa.view.fragment.dashboard.adapter.ListMessageAdapter
import com.appa.view.fragment.dashboard.viewmodel.MainViewModel


class DashboardFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val mainViewModel: MainViewModel by provideViewModel()
    private lateinit var listAdapter: ListMessageAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        getMessageList()
    }

    private fun initAdapter() {
        listAdapter = ListMessageAdapter()
        binding?.recyclerview?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }

    }

    private fun getMessageList() {
        mainViewModel.allMessagesLiveData.observe(viewLifecycleOwner) { list ->
            listAdapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }


}