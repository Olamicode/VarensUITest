package com.olamachia.varensuitest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.olamachia.varensuitest.model.Currency
import com.olamachia.varensuitest.utils.drawLineChart
import com.olamachia.varensuitest.utils.provideRandomData
import olamachia.varensuitest.R
import olamachia.varensuitest.databinding.ConvertCurrencyItemBinding

class CurrenciesAdapter(
    private val currencies: List<Currency>,
    private val onCurrentItemClicked: (Currency) -> Unit
) : RecyclerView.Adapter<CurrenciesAdapter.CurrenciesViewHolder>() {

    class CurrenciesViewHolder(
        private val binding: ConvertCurrencyItemBinding,
        private val onCurrentItemClicked: (Currency) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: Currency) {
            binding.apply {
                currencyTextView.text = currency.name
                currencyPercentageTextView.text = currency.percentage
                currencyAmountTextView.text = currency.amountInDollar
                currencyRateTextView.text = currency.rate
                cryptocurrencyCardLayout.setBackgroundResource(
                    if (adapterPosition % 2 != 0)
                        R.drawable.white_background
                    else R.drawable.ghost_gray_background
                )
                currencyImageView.setImageResource(currency.icon)
                lineChart.drawLineChart(root.context, currency.getCurrentType(),
                    provideRandomData(), adapterPosition)

                root.apply {
                    setOnClickListener {
                        onCurrentItemClicked.invoke(currency)
                    }
                    setBackgroundColor(
                        if (adapterPosition % 2 != 0)
                            ContextCompat.getColor(root.context, R.color.ghost_gray)
                        else ContextCompat.getColor(root.context, R.color.white)
                    )
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesViewHolder {
        val binding = ConvertCurrencyItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrenciesViewHolder(binding, onCurrentItemClicked)
    }

    override fun onBindViewHolder(holder: CurrenciesViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int = currencies.size
}