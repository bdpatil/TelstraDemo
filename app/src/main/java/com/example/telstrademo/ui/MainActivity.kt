package com.example.telstrademo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.telstrademo.R
import com.example.telstrademo.data.networks.FactsApi
import com.example.telstrademo.data.repositories.FactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository =FactsRepository(FactsApi())
        GlobalScope.launch (Dispatchers.Main ){
            val fact =repository.getFacts()

            Toast.makeText(this@MainActivity,fact.toString(),Toast.LENGTH_LONG).show()
            Log.e("RES----",fact.toString())
        }
    }
}
