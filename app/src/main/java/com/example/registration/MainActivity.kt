package com.example.registration

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.registration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // when click button validation function invoke. This function validation for every required field
        binding.buttonRegistration.setOnClickListener { validation() }
     hideKeyboard()

    }

    // when user press Enter this function call handleKeyEvent to hide keyboard
    fun hideKeyboard(){
        binding.name.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
        binding.email.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
        binding.address.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
        binding.password.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
        binding.rePassword.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
        binding.birthDate.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
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
            binding.showName.text = getString(R.string.passwordAlert)
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
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}

