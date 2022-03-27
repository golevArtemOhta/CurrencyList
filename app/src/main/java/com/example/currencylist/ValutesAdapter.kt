package com.example.currencylist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.currencylist.databinding.ValuteItemBinding

class ValutesAdapter() : RecyclerView.Adapter<ValutesAdapter.ValuteHolder>() {
    val valutesList = ArrayList<Valute>()
    lateinit var allInfoApi: ValuteJSON

    class ValuteHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ValuteItemBinding.bind(item)


        @SuppressLint("SetTextI18n")
        fun bind(valute: Valute) = with(binding) {
            tvAbbreviatedName.text = valute.charCode
            tvFullName.text = valute.name
            tvNominal.text = "${valute.nominal}"
            tvValue.text = "${valute.value}"

            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    Toast.makeText(p0?.context, "${valute.name} выбран", Toast.LENGTH_SHORT).show()

                    val activity = p0?.getContext() as AppCompatActivity
                    val convertFragment: Fragment = ConvertFragment()
                    val bundle = Bundle()
                    bundle.putString("name", valute.name)
                    bundle.putString("CharCode", valute.charCode)
                    bundle.putDouble("Value", valute.value)
                    bundle.putInt("Nominal", valute.nominal)
                    convertFragment.arguments = bundle
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, convertFragment).addToBackStack(null).commit()

                }
            })
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.valute_item, parent, false)
        return ValuteHolder(view)
    }

    override fun onBindViewHolder(holder: ValuteHolder, position: Int) {
        val item = valutesList[position]
        holder.bind(valutesList[position])

    }

    override fun getItemCount(): Int {
        return valutesList.size
    }

    fun getValutesData(valutes: Map<String, Valute>) {
        valutesList.addAll(valutes.values.toList())
    }


    fun getAllApiInfoData(allInfoApiNew: ValuteJSON) {
        allInfoApi = allInfoApiNew
    }

}