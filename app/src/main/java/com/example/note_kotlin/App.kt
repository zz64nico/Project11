package com.example.note_kotlin

import android.net.Uri
import com.example.note_kotlin.entity.Cabins
import com.google.firebase.auth.FirebaseUser
import java.util.ArrayList

object App {
    var commonUri: Uri? = null
    var user: FirebaseUser? = null
    var stringList:MutableList<String> = ArrayList()
    var cabinList:MutableList<Cabins> = ArrayList()
}