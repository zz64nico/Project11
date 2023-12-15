package com.example.note_kotlin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.note_kotlin.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity:AppCompatActivity() {
    lateinit var binding:ActivityRegisterBinding ;
    private lateinit var auth: FirebaseAuth
    var name:String? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        name = intent.getStringExtra("name")
        binding?.account?.setText(name)


        auth = FirebaseAuth.getInstance()
        binding.submit.setOnClickListener {
            val name = binding.account.text.toString();
            val password = binding.password.text.toString();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)){
                Toast.makeText(applicationContext,"input name",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(name, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        auth.signInWithEmailAndPassword(name, password)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    // Sign in success, update UI with the signed-in user's information
                                    val user = auth.currentUser;
                                    App.user = user;
                                    var intent = Intent()
                                    intent.putExtra("name",user)
                                    setResult(102,intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        baseContext,
                                        "Authentication failed.",
                                        Toast.LENGTH_SHORT,
                                    ).show()
                                }
                            }
                    } else {
                        // If sign in fails, display a message to the user.
                        auth.signInWithEmailAndPassword(name, password)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    // Sign in success, update UI with the signed-in user's information
                                    val user = auth.currentUser;
                                    App.user = user;
                                    var intent = Intent()
                                    intent.putExtra("name",user)
                                   setResult(102,intent)
                                    finish()
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
        }
    }
}