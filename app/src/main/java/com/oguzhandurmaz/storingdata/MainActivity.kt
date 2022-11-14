package com.oguzhandurmaz.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) 
        setContentView(R.layout.activity_main)

        sharedPreferences=getSharedPreferences("com.oguzhandurmaz.storingdata",
            Context.MODE_PRIVATE)
        if(sharedPreferences.contains("note")){
            val note=sharedPreferences.getString("note",null)
            noteText.setText(note)
        }
    }

    fun saveNote(view: View){
        //SharedPreferences
        if(noteText.text.toString()!=""){
            sharedPreferences.edit().putString("note",noteText.text.toString()).apply()
            Toast.makeText(this, "Note saved.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteNote(view:View){
        if (sharedPreferences.contains("note")) {
            sharedPreferences.edit().remove("note").apply()
            noteText.text=null
            Toast.makeText(this, "Note deleted.", Toast.LENGTH_SHORT).show()
        }
    }
}