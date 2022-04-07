package com.example.bunique

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.example.bunique.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding : FragmentRegisterBinding
    private var country = "USA"
    private var institute = "Harvard University"
    private var area = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)

        spinnerSelector()
        radioGroupSelector()

        return binding.root
    }

    private fun radioGroupSelector() {
        binding.interestArea.setOnCheckedChangeListener { radioGroup, i ->
            val selectedArea : RadioButton = radioGroup.findViewById(i)
            area = selectedArea.text.toString()
        }
    }

    private fun spinnerSelector() {
        val countryAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            countryList
        )

        val instituteAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            instituteList
        )

        binding.countrySpinner.adapter = countryAdapter
        binding.instituteSpinner.adapter = instituteAdapter

        binding.countrySpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    country = p0?.getItemAtPosition(p2).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        binding.instituteSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    institute = p0?.getItemAtPosition(p2).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
    }

}


val countryList = listOf("USA","Canada","Finland","India","Bangladesh","Norway")
val instituteList = listOf("Harvard University","Canada University","University of Finland","IIT","Daffodil International University","University of Norway")