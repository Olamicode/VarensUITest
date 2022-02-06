package com.olamachia.varensuitest.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.view.MenuItem
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.bottomnavigation.BottomNavigationView
import olamachia.varensuitest.R


fun Fragment.loadImageWithUrlIntoImageView(view: ImageView, url: String) {
    Glide.with(requireActivity())
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .dontAnimate().into(view)
}

fun BottomNavigationView.checkMenuItem(destinationId: Int) {
    for (i in 0 until menu.size()) {
        val item: MenuItem = menu.getItem(i)
        item.isChecked = false
    }
    menu.findItem(destinationId)?.isChecked = true
}

fun LineChart.drawLineChart(
    context: Context,
    currencyType: CurrencyType,
    randomData : MutableList<Int>,
    position: Int = 1,
    shouldDrawXAxis: Boolean = false,
    shouldHaveAxisRightEnabled: Boolean = false
) {

    val entries = mutableListOf<Entry>()

    randomData.map { it.toFloat() }
        .forEachIndexed { index, element -> entries.add(Entry((index).toFloat(), element)) }
    val lineDataSet = LineDataSet(entries, "STATS").apply {
        setDrawIcons(false)
        setDrawValues(false)
        setDrawCircles(false)

        when (currencyType) {
            CurrencyType.BTC -> {
                fillColor = ContextCompat.getColor(context, R.color.secondary_brown)
                color = ContextCompat.getColor(context, R.color.secondary_brown)
            }
            CurrencyType.ETH -> {
                fillColor = ContextCompat.getColor(context, R.color.eth_black)
                color = ContextCompat.getColor(context, R.color.eth_black)
            }
            CurrencyType.XRP -> {
                ContextCompat.getColor(context, R.color.xrp_blue)
                color = ContextCompat.getColor(context, R.color.xrp_blue)
            }
            CurrencyType.LTC -> {
                ContextCompat.getColor(context, R.color.eth_black)
                color = ContextCompat.getColor(context, R.color.eth_black)
            }
            else -> {
                ContextCompat.getColor(context, R.color.green)
                color = ContextCompat.getColor(context, R.color.green)
            }
        }

        mode = LineDataSet.Mode.CUBIC_BEZIER
        setDrawFilled(true)
    }

    this.apply {
        data = LineData(lineDataSet)
        invalidate()
        setBackgroundColor(
            if (position % 2 != 0)
                ContextCompat.getColor(context, R.color.ghost_gray)
            else ContextCompat.getColor(context, R.color.white)
        )
        setDrawBorders(false)
        description.isEnabled = false
        legend.isEnabled = false

        xAxis.apply {
            isEnabled = shouldDrawXAxis
            setDrawAxisLine(shouldDrawXAxis)
            setDrawGridLines(false)
            setCenterAxisLabels(false)
            setPosition(XAxis.XAxisPosition.BOTTOM)
            valueFormatter = CustomLabelXAxisFormatter()
        }

        axisRight.isEnabled = shouldHaveAxisRightEnabled
        axisRight.valueFormatter = CustomLabelAxisRightFormatter()
        axisRight.gridColor = ContextCompat.getColor(context, R.color.light_gray)
        axisLeft.isEnabled = false
    }
}

fun CandleStickChart.drawLineChart(context: Context) {
    isHighlightPerDragEnabled = true
    setDrawBorders(false)

    val yAxis = this.axisLeft
    val rightAxis = this.axisRight
    axisRight.isEnabled = true
    axisRight.valueFormatter = CustomLabelAxisRightFormatter()
    yAxis.isEnabled = false

    yAxis.setDrawGridLines(false)
    rightAxis.setDrawGridLines(false)
    requestDisallowInterceptTouchEvent(true)

    val xAxis = this.xAxis
    xAxis.setDrawGridLines(false)
    xAxis.position = XAxis.XAxisPosition.BOTTOM
    xAxis.valueFormatter = CustomLabelXAxisFormatter()
    xAxis.setDrawLabels(true)
    rightAxis.textColor = Color.BLACK
    xAxis.granularity = 1F
    xAxis.isGranularityEnabled = true
    xAxis.setAvoidFirstLastClipping(true)

    legend.isEnabled = false
    description.isEnabled = false

    val candleEntries = mutableListOf<CandleEntry>(
        CandleEntry(0F, 1750.0F, 1743.89F, 1712.54F, 1765.78F ),
        CandleEntry(1F, 1760.0F, 1753.89F, 1732.54F, 1745.78F ),
        CandleEntry(2F, 1750.0F, 1773.89F, 1722.54F, 1755.78F ),
        CandleEntry(3F, 1755.0F, 1773.89F, 1742.54F, 1800.00F ),
        CandleEntry(4F, 1775.0F, 1763.89F, 1752.54F, 1735.78F ),
        CandleEntry(5F, 1725.0F, 1700.09F, 1752.04F, 1775.08F ),
        CandleEntry(6F, 1825.0F, 1800.09F, 1752.04F, 1775.08F )
    )

    val candleDataSet = CandleDataSet(candleEntries, "STATS")
    candleDataSet.color = Color.rgb(80,80,80)
    candleDataSet.shadowColorSameAsCandle = true
    candleDataSet.shadowWidth = 0.8F
    candleDataSet.decreasingColor = ContextCompat.getColor(context, R.color.brown)
    candleDataSet.decreasingPaintStyle = Paint.Style.FILL
    candleDataSet.increasingColor = ContextCompat.getColor(context, R.color.green)
    candleDataSet.increasingPaintStyle = Paint.Style.FILL
    candleDataSet.neutralColor = Color.LTGRAY
    candleDataSet.setDrawValues(false)

    val candleData = CandleData(candleDataSet)

    data = candleData
    invalidate()
}

fun provideRandomData(): MutableList<Int> {
    val randomData = mutableListOf<Int>()

    for (i in 0..6) {
        randomData.add((1750..1800).random())
    }
    return randomData
}


