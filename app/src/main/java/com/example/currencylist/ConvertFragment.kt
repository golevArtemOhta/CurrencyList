package com.example.currencylist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.currencylist.databinding.FragmentConvertBinding


class ConvertFragment : Fragment() {
    lateinit var binding: FragmentConvertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConvertBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = this.arguments
        val name = bundle?.getString("name")
        val charCode = bundle?.getString("CharCode")
        val value = bundle?.getDouble("Value")
        val nominal = bundle?.getInt("Nominal")
        binding.tvAbbreviatedName.text = "$charCode"
        binding.tvNominal.text = "$nominal"
        binding.tvValue.text = "$value"
        binding.tvFullName.text = "$name"

        binding.bntConvert.setOnClickListener {
            if (binding.etSum.text.toString() == "") {
                Toast.makeText(activity, "Введите сумму для конвертации", Toast.LENGTH_SHORT)
                    .show();
            } else {
                val result = (binding.etSum.text.toString().toInt() / value!!) * nominal!!
                binding.tvConvertResult.text = "${Math.round(result * 100.0) / 100.0}"
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ConvertFragment()
    }
}