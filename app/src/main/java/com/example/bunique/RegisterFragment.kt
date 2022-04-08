package com.example.bunique

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.bunique.data.User
import com.example.bunique.data.userList
import com.example.bunique.databinding.FragmentRegisterBinding
import java.text.Format

class RegisterFragment : Fragment() {

    private lateinit var binding : FragmentRegisterBinding
    private var country = "USA"
    private var institute = "Harvard University"
    private var area = "Web Development"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)

        spinnerSelector()
        radioGroupSelector()

        binding.registerButton.setOnClickListener {
            saveInfo()
        }

        return binding.root
    }

    private fun saveInfo() {
        val name = binding.fullName.text.toString()
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()
        val confirmPassword = binding.confirmPassword.text.toString()

        if(name.isEmpty()){
            binding.fullName.error = "Please Insert Your Name"
            return
        }

        if(email.isEmpty()){
            binding.email.error = "Please Insert Your Email"
            return
        }

        if(password.isEmpty()){
            binding.password.error = "Please Insert Your Password"
            return
        }

        if(confirmPassword.isEmpty()){
            binding.confirmPassword.error = "Please Insert Your Password Again"
            return
        }

        if(password.length < 10){
            binding.password.error = "Minimum 10 Character Long"
            return
        }

        if(password != confirmPassword){
            binding.confirmPassword.error = "Password didn't match"
            return
        }

        val user = User(
            id = System.currentTimeMillis(),
            name = name,
            email = email,
            country = country,
            institute = institute,
            interest = area,
            password = password
        )

        val newUser = Bundle().apply {
            putString("name", name)
            putString("email", email)
            putString("country", country)
            putString("institute", institute)
        }

        userList.add(user)

        findNavController().navigate(R.id.action_registerFragment_to_homeFragment, bundleOf("user" to newUser))

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