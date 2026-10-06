package com.HigorThomaz.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.HigorThomaz.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonLogin.setOnClickListener(this)
        binding.buttonRegister.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_login){
            val email = binding.edittextEmail.text.toString()
            val password = binding.edittextEmail.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent: Intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, R.string.data_validation, Toast.LENGTH_SHORT).show()
            }
        } else if(v.id ==R.id.button_register) {

        }
    }
}