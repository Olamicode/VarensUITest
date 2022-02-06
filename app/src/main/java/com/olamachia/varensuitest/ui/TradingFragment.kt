package com.olamachia.varensuitest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.olamachia.varensuitest.ui.adapter.MarketStatsAdapter
import com.olamachia.varensuitest.utils.CurrencyType
import com.olamachia.varensuitest.utils.DUMMY_AVATAR_URL
import com.olamachia.varensuitest.utils.DataModelProvider
import com.olamachia.varensuitest.utils.drawLineChart
import com.olamachia.varensuitest.utils.loadImageWithUrlIntoImageView
import com.olamachia.varensuitest.utils.provideRandomData
import olamachia.varensuitest.R
import olamachia.varensuitest.databinding.FragmentTradingBinding

class TradingFragment : Fragment(R.layout.fragment_trading) {
    private var _binding: FragmentTradingBinding? = null
    private val binding get() = _binding!!
    private var isCandleStickChartInView = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTradingBinding.bind(view)

        val marketStatsAdapter  = MarketStatsAdapter(DataModelProvider.provideMarketStats())
        binding.apply {
            marketStatsRecyclerView.apply {
                adapter = marketStatsAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            changeButton.setOnClickListener {
                findNavController().navigate(R.id.exchangeFragment)
            }

            loadImageWithUrlIntoImageView(userAvatarImageView,
                DUMMY_AVATAR_URL)

            btcLineChart.drawLineChart(requireContext(), CurrencyType.BTC, provideRandomData())
            setUpMainLineChart()

            twentyFourHourTextView.setOnClickListener {
                toggleUnSelectedAndSelectedViews(it as TextView)
                setUpMainLineChart()
            }

            oneWeekTextView.setOnClickListener {
                toggleUnSelectedAndSelectedViews(it as TextView)
                setUpMainLineChart()
            }

            oneMonthTextView.setOnClickListener {
                toggleUnSelectedAndSelectedViews(it as TextView)
                setUpMainLineChart()
            }

            oneYearTextView.setOnClickListener {
                toggleUnSelectedAndSelectedViews(it as TextView)
                setUpMainLineChart()
            }

            allTextView.setOnClickListener {
                toggleUnSelectedAndSelectedViews(it as TextView)
                setUpMainLineChart()
            }

            settingImageView.setOnClickListener {
                isCandleStickChartInView = !isCandleStickChartInView
                if (isCandleStickChartInView) {
                    mainLineChart.isVisible = false
                    mainCandleChart.isVisible = true
                    mainCandleChart.drawLineChart(requireContext())
                    toggleUnSelectedAndSelectedViews(settingImageView)
                    switchOnPeriodViews(false)
                } else {
                    mainLineChart.isVisible = true
                    mainCandleChart.isVisible = false
                    toggleUnSelectedAndSelectedViews(settingImageView)
                    switchOnPeriodViews(true)
                    setUpMainLineChart()
                }
            }

        }
    }

    private fun toggleUnSelectedAndSelectedViews(view: View) {
        toggleOff(object : ViewCallBack {
            override fun toggleOffAllViews() {
                toggleOffPeriodViews()
            }

        })
        if (view is TextView) {
            view.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        } else if (view is ImageView) {
            if (isCandleStickChartInView) {
                val color = ContextCompat.getColor(requireContext(), R.color.green)
                view.setColorFilter(color)
            } else {
                val color = ContextCompat.getColor(requireContext(), R.color.secondary_black)
                view.setColorFilter(color)

                binding.twentyFourHourTextView.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.green))
            }
        }
    }

    private fun setUpMainLineChart() {
        binding.apply {
            mainLineChart.drawLineChart(requireContext(), CurrencyType.DEFAULT,
                provideRandomData(),0,
                shouldDrawXAxis = true,
                shouldHaveAxisRightEnabled = true)
        }
    }

    private fun toggleOffPeriodViews() {
        binding.apply {
            twentyFourHourTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.eth_black))
            oneWeekTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.eth_black))
            oneMonthTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.eth_black))
            oneYearTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.eth_black))
            allTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.eth_black))
        }
    }

    private fun switchOnPeriodViews(isSwitchOn: Boolean) {
        binding.apply {
            twentyFourHourTextView.isClickable = isSwitchOn
            oneWeekTextView.isClickable = isSwitchOn
            oneMonthTextView.isClickable = isSwitchOn
            oneYearTextView.isClickable = isSwitchOn
            allTextView.isClickable = isSwitchOn
        }
    }

    private fun toggleOff(viewCallBack: ViewCallBack) {
        viewCallBack.toggleOffAllViews()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

interface ViewCallBack {
    fun toggleOffAllViews()
}