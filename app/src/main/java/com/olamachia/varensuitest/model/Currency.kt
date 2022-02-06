package com.olamachia.varensuitest.model

import com.olamachia.varensuitest.utils.BTC
import com.olamachia.varensuitest.utils.CurrencyType
import com.olamachia.varensuitest.utils.ETH
import com.olamachia.varensuitest.utils.LTC
import com.olamachia.varensuitest.utils.XRP

data class Currency(
    val icon: Int,
    val name: String,
    val percentage: String,
    val amountInDollar: String,
    val rate: String
){
    lateinit var currencyType: CurrencyType

    fun getCurrentType(): CurrencyType {

        currencyType = when (name) {
            BTC -> CurrencyType.BTC
            ETH -> CurrencyType.ETH
            XRP -> CurrencyType.XRP
            LTC -> CurrencyType.LTC
            else -> CurrencyType.DEFAULT
        }

        return currencyType
    }
}
