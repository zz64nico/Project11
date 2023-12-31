package com.example.note_kotlin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.note_kotlin.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.Firebase
class LoginActivity:AppCompatActivity() {
    var binding :ActivityLoginBinding? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        auth  = FirebaseAuth.getInstance();



        binding?.close?.setOnClickListener { finish() }

        binding?.register?.setOnClickListener {

        }


        //log in or sign up
        binding?.tvContinue?.setOnClickListener {
            val name = binding?.account?.text.toString();
            if (TextUtils.isEmpty(name)){
                Toast.makeText(applicationContext,"input name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var intent = Intent(this@LoginActivity,RegisterActivity::class.java)
            intent.putExtra("name",name)
            startActivityForResult(intent,101)
        }




        binding?.submit?.setOnClickListener {


            val name = binding?.account?.text.toString();
            val password = binding?.password?.text.toString();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)){
                Toast.makeText(applicationContext,"input name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(name, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        var intent = Intent(this@LoginActivity,MainActivity::class.java)
                        intent.putExtra("user",user)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101 && resultCode == 102){
            finish()
        }
    }

}