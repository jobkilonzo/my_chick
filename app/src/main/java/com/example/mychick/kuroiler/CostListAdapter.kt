package com.example.mychick.kuroiler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mychick.R
import com.example.mychick.kuroiler.CostListAdapter.KuroilerCostViewHolder

class CostListAdapter : ListAdapter<KuroilerCost, KuroilerCostViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KuroilerCostViewHolder {
        return KuroilerCostViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: KuroilerCostViewHolder, position: Int) {
        val current = getItem(position)
        val type = current.type
        val amount = current.amount
        holder.bind(type, amount)

    }



    class WordsComparator : DiffUtil.ItemCallback<KuroilerCost>() {
        override fun areItemsTheSame(oldItem: KuroilerCost, newItem: KuroilerCost): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: KuroilerCost, newItem: KuroilerCost): Boolean {
            return oldItem.type == newItem.type
        }
    }

    class KuroilerCostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val type: TextView = itemView.findViewById(R.id.tileTextView)
        private val amount: TextView = itemView.findViewById(R.id.amountTextView)

        fun bind(text1: String?, text2: Int?) {
            type.text = text1
            amount.text = text2.toString()
        }

        companion object {
            fun create(parent: ViewGroup): KuroilerCostViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return KuroilerCostViewHolder(view)
            }
        }
    }
}