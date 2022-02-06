package com.olamachia.varensuitest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.olamachia.varensuitest.model.MarketStat
import olamachia.varensuitest.R
import olamachia.varensuitest.databinding.MarketStatItemBinding

class MarketStatsAdapter(private val marketStats: ArrayList<MarketStat>) :
    RecyclerView.Adapter<MarketStatsAdapter.MarketStatsViewHolder>() {

    class MarketStatsViewHolder(private val binding: MarketStatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(marketStat: MarketStat) {
            binding.apply {
                root.setBackgroundColor(
                    if (adapterPosition % 2 != 0)
                        ContextCompat.getColor(root.context, R.color.ghost_gray)
                    else ContextCompat.getColor(root.context, R.color.white)
                )
                iconImageView.setImageResource(marketStat.icon)
                titleTextView.text = marketStat.title
                contentTextView.text = marketStat.content
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketStatsViewHolder {
        val binding = MarketStatItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return MarketStatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarketStatsViewHolder, position: Int) {
        holder.bind(marketStats[position])
    }

    override fun getItemCount(): Int = marketStats.size
}