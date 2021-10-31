package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // when click button validation function invoke. This function validation for every required field
        binding.buttonRegistration.setOnClickListener { validation() }
    }

    // this function for checking Name (it will calling by function "validation")

    fun validName() {
        if (binding.name.text.toString().isEmpty()) {
            binding.showName.setText(getString(R.string.nameAlert))
        } else {
            binding.name.text.toString()
        }
    }

// this function for checking Email (it will calling by function "validation")

    fun validEmail() {
        if (!(binding.email.text.toString().contains('@')) && !(binding.email.text.toString()
                .contains('.'))
        ) {
            binding.showName.setText(getString(R.string.emailAlert))
        } else {
            binding.email.text.toString()
        }
    }

// this function for checking password (it will calling by function "validation")

    fun validPassword() {
        if (binding.password.text.toString().isEmpty()) {
            binding.showName.setText(getString(R.string.passwordAlert))
        } else if (binding.password.text.toString() != binding.rePassword.text.toString()) {
            binding.showName.text = getString(R.string.passAlert)
        } else {
            binding.password.text.toString()
            binding.rePassword.text.toString()
        }
    }

    // This function validation for every required field , then print Name with welcome massage

    fun validation() {
        validPassword()
        validEmail()
        validName()

        if (binding.name.text.toString().isNotEmpty() &&
            binding.email.text.toString().isNotEmpty() &&
            binding.rePassword.text.toString().isNotEmpty())
            {
            binding.welcom.text = getString(R.string.welcomeMasseg)
            binding.showName.setText(binding.name.text.toString())
        }
    }
}

