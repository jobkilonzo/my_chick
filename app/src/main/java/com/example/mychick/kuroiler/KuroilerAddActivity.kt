package com.example.mychick.kuroiler

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import com.example.mychick.MyCickApplication
import com.example.mychick.R
import com.example.mychick.databinding.ActivityKuroilerAddBinding
import java.util.*

class KuroilerAddActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityKuroilerAddBinding
    private lateinit var editWordView: EditText
    private lateinit var cosSElected: String

    private val kuroilerViewModel: KuroilerViewModel by viewModels {
        KuroilerViewmodelFactory((application as MyCickApplication).kuroilerRepository)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_kuroiler_add)

        val spinner: Spinner = binding.chooseCost
        ArrayAdapter.createFromResource(
            this,
            R.array.cost_arrays,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner.adapter = adapter
            spinner.marginBottom.div(10)
        }
        spinner.onItemSelectedListener = this
        editWordView = binding.enterAmount
        binding.saveCost.setOnClickListener {
            //val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                Toast.makeText(this, "You've not entered cost", Toast.LENGTH_SHORT).show()
            } else {
                val cost = editWordView.text.toString()

                roomDbLogic(cost)

                //kuroilerViewModel.insert(KuroilerCost(cosSElected, cost.toInt()))
//                if (kuroilerViewModel.isEmpty.equals(true)){

//                if (kuroilerViewModel.allCost.value?.isEmpty() == false) {
//                    kuroilerViewModel.insert(KuroilerCost(cosSElected, cost.toInt()))
//                    Log.i("Cost", "$cosSElected $cost")
//                } else {
//                    kuroilerViewModel.updateCost(cosSElected, cost.toInt())
//                }
                //kuroilerViewModel.updateCost(cosSElected, cost.toInt())

            }
            finish()
        }
    }

    private fun roomDbLogic(cost: String) {
        try {
            kuroilerViewModel.allCost.observe(this) { response ->
                response.let {
                    Log.d("allCost", "$it")
                    if (it.toMutableList().isNotEmpty()) {
                        // insert logic
                        kuroilerViewModel.insert(
                            KuroilerCost(
                                null,
                                cost.toInt()
                            )
                        )
                    } else {
                        updateRoomDb(cost, it)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateRoomDb(cost: String, it: List<KuroilerCost>?) {
        try {
            kuroilerViewModel.updateCost(it!!.toMutableList()[0].id!!, cost.toInt())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        cosSElected = parent?.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

