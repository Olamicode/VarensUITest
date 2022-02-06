package com.olamachia.varensuitest.utils

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter

class CustomLabelXAxisFormatter : ValueFormatter() {
    private val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sa", "Su")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return days.getOrNull(value.toInt()) ?: value.toString()
    }

}