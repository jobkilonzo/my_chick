package com.example.mychick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mychick.databinding.ActivityMainBinding
import com.example.mychick.kuroiler.Kuroiler
import com.example.mychick.kuroiler.KuroilerCost
import com.example.mychick.kuroiler.KuroilerViewModel
import com.example.mychick.kuroiler.KuroilerViewmodelFactory
import com.example.mychick.raibowrooster.RainbowRooster

class MainActivity : AppCompatActivity() {

    private val kuroilerViewModel: KuroilerViewModel by viewModels<KuroilerViewModel> {
        KuroilerViewmodelFactory((application as MyCickApplication).kuroilerRepository)
    }
    private lateinit var binding: ActivityMainBinding
    private val kuroilerctivityRequestCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnKuroiler.setOnClickListener {

            val intent = Intent(this, Kuroiler::class.java)
            startActivity(intent)
        }
//        kuroilerViewModel.cost.observe(this, Observer {
//            binding.textViewDrugs.text = it.toString()
//        })

       // binding.textViewDrugs.text = kuroilerViewModel.getSumById("drugs").toString()

//        kuroilerViewModel.kuroilerCost.observe(this){
//            kuroilerCost -> kuroilerCost.
//        }
        binding.btnKuroiler.setOnClickListener {

            val intent = Intent(this, Kuroiler::class.java)
            startActivity(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
//        super.onActivityResult(requestCode, resultCode, intentData)
//
//        if (requestCode == kuroilerctivityRequestCode && resultCode == RESULT_OK) {
//
//            val cost: String = intentData?.getStringExtra("cost").toString()
//            val costSelected: String = intentData?.getStringExtra("costSelected").toString()
//
//            //val kuroiler = KuroilerCost(cost, costSelected)
////            intentData?.getStringExtra()?.let { reply ->
////                val kuroiler = KuroilerCost(reply.)
////                wordViewModel.insert(word)
////            }
////            intentData?.getStringExtra(Kuroiler.EXTRA_REPLY)?.let { reply ->
////                val kuroiler = KuroilerCost(reply.)
////                wordViewModel.insert(word)
////            }
//        } else {
//            Toast.makeText(
//                applicationContext,
//                R.string.empty_not_saved,
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }

}