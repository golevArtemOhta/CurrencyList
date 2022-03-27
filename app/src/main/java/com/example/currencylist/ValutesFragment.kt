package com.example.currencylist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencylist.databinding.FragmentValutesBinding

class ValutesFragment : Fragment() {
    lateinit var binding: FragmentValutesBinding
    lateinit var valuteViewModel: ValuteViewModel
    lateinit var valutesItems: Map<String, Valute>
    lateinit var date: String
    lateinit var datePrevious: ValuteJSON
    private val adapter = ValutesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        valuteViewModel = ViewModelProvider(requireActivity()).get(ValuteViewModel::class.java)
        binding = FragmentValutesBinding.inflate(inflater)
        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        valuteViewModel.request()


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        valuteViewModel.itemsValutes.observe(activity as LifecycleOwner, Observer {
            valutesItems = it
            adapter.getValutesData(valutesItems)
            adapter.notifyDataSetChanged()
        })


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rvValutes.layoutManager = LinearLayoutManager(context)
        binding.rvValutes.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = ValutesFragment()
    }
}