package com.olamachia.varensuitest.utils

import com.github.mikephil.charting.formatter.ValueFormatter

class CustomLabelAxisRightFormatter : ValueFormatter() {

    override fun getFormattedValue(value: Float): String {
        return "$${value}"
    }

}