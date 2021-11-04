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
    fun validation(){
        if (binding.password.text.toString().isNotEmpty()&&binding.rePassword.text.toString().isNotEmpty()){
           if (binding.password.text.toString()==binding.rePassword.text.toString()){
            if(binding.email.text.toString().contains('@') && binding.email.text.toString().contains('.')){
                if (binding.name.text.toString().isNotEmpty()){
                    binding.welcom.text=getText(R.string.welcomeMasseg)
                    binding.showName.setText(binding.name.text.toString())
                } else{
                    binding.showName.text=getText(R.string.nameAlert)
                }
            } else {
                binding.showName.text = getText(R.string.emailAlert)
            }
        } else {
            binding.showName.text= getText(R.string.passAlert)
        }
    }else{
binding.showName.text = getText(R.string.passwordAlert)
        }    }
}

