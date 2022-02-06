package com.olamachia.varensuitest.utils

import com.olamachia.varensuitest.model.Currency
import com.olamachia.varensuitest.model.MarketStat
import olamachia.varensuitest.R

object DataModelProvider {

    fun provideMarketStats() : ArrayList<MarketStat> {
        return arrayListOf<MarketStat>(
            MarketStat(
               icon = R.drawable.presention_chart,
               title = "Market Cap",
               content = "41,288.00 BTC"
            ),
            MarketStat(
               icon = R.drawable.chart,
               title = "Volume (4h)",
               content = "$12,999.00"
            ),
            MarketStat(
               icon = R.drawable.chart_success,
               title = "Available Supply",
               content = "9771.64"
            ),
            MarketStat(
               icon = R.drawable.diagram,
               title = "Trading Activity",
               content = "15% sell, 85% buy"
            )
        )
    }

    fun provideCurrencies(): List<Currency> {
        return listOf(
            Currency(
              icon = R.drawable.cryptocurrency,
              name = "BTC",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_eth,
              name = "ETH",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_xrp,
              name = "XRP",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_ltc,
              name = "LTC",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),Currency(
              icon = R.drawable.cryptocurrency,
              name = "BTC",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_eth,
              name = "ETH",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_xrp,
              name = "XRP",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_ltc,
              name = "LTC",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency,
              name = "BTC",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_eth,
              name = "ETH",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_xrp,
              name = "XRP",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
            Currency(
              icon = R.drawable.cryptocurrency_ltc,
              name = "LTC",
              percentage = "-1.32%",
              amountInDollar = "$24,150.17",
              rate = "2.73 BTC"
            ),
        )
    }
}