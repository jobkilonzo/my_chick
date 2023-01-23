package com.example.mychick.kuroiler

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mychick.MyCickApplication
import com.example.mychick.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Kuroiler : AppCompatActivity() {

    private val kuroilerViewModel: KuroilerViewModel by viewModels {
        KuroilerViewmodelFactory((application as MyCickApplication).kuroilerRepository)
    }

    private lateinit var editWordView: EditText
    private lateinit var cosSElected: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuroiler)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = CostListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        kuroilerViewModel.allCost.observe(this) { cost ->
            // Update the cached copy of the words in the adapter.
            cost.let { adapter.submitList(it) }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val intent = Intent(this, KuroilerAddActivity::class.java)
            startActivity(intent)
        }


    }


}