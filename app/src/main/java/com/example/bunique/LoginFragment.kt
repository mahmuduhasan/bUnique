package com.example.bunique

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bunique.data.userList
import com.example.bunique.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var emailValidator = false
    private var passwordValidator = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)


        binding.loginButton.setOnClickListener {
            for(user in userList){
                if(binding.email.text.toString() == user.email){
                    emailValidator = true
                }
                if(binding.password.text.toString() == user.password){
                    passwordValidator = true
                }
            }

            if(!emailValidator){
                binding.email.error = "Invalid Email"
                return@setOnClickListener
            }

            if(!passwordValidator){
                binding.password.error = "Incorrect Password"
                return@setOnClickListener

            }

            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return binding.root
    }


}