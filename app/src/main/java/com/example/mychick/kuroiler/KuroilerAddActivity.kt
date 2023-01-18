package com.example.mychick.kuroiler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import com.example.mychick.MyCickApplication
import com.example.mychick.R
import com.example.mychick.databinding.ActivityKuroilerAddBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class KuroilerAddActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityKuroilerAddBinding
    private lateinit var editWordView: EditText
    private lateinit var cosSElected: String
    private val kuroilerViewModel: KuroilerViewModel by viewModels<KuroilerViewModel> {
        KuroilerViewmodelFactory((application as MyCickApplication).kuroilerRepository)
    }
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_kuroiler_add)

        val spinner: Spinner = binding.chooseCost
        ArrayAdapter.createFromResource(
            this,
            R.array.cost_arrays,
            android.R.layout.simple_spinner_item
        ).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner.adapter = adapter
            spinner.marginBottom.div(10)
        }
        spinner.onItemSelectedListener = this
        editWordView  = binding.enterAmount
        binding.saveCost.setOnClickListener {
            //val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                Toast.makeText(this, "You've not entered cost", Toast.LENGTH_SHORT).show()
            } else {
                val cost = editWordView.text.toString()
                val sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy")

                val date = LocalDateTime.now().format(sdf)
                kuroilerViewModel.insert(KuroilerCost(cosSElected, cost.toInt(), date))
                Log.i("Cost", "$cosSElected $cost $date")
            }
            finish()
        }
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        cosSElected = parent?.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

