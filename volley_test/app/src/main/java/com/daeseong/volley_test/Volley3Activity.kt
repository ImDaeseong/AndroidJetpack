package com.daeseong.volley_test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class Volley3Activity : ComponentActivity() {

    private val TAG = Volley3Activity::class.simpleName

    private lateinit var requestQueue: RequestQueue
    private var responseData1 by mutableStateOf<String?>(null)
    private var responseData2 by mutableStateOf<String?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initVolley()

        setContent {

            Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp))
            {
                Text(
                    text = responseData1 ?: "",
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp),
                    maxLines = Int.MAX_VALUE
                )

                Text(
                    text = responseData2 ?: "",
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                        .weight(1f),
                    style = TextStyle(color = Color.Black, fontSize = 16.sp),
                    maxLines = Int.MAX_VALUE
                )

                Button(
                    onClick = {
                        requestQueue.add(requestGetJson())
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Request Data")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        try {
            requestQueue?.cancelAll(this)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    private fun initVolley() {
        requestQueue = Volley.newRequestQueue(this)
    }

    private fun requestGetJson(): JsonObjectRequest {
        val url = "https://api.bithumb.com/public/ticker/BTC"

        return JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                try {

                    responseData1 = response.toString()

                    val status = response.getString("status")
                    if (status == "0000") {
                        val data = response.getJSONObject("data")
                        val openingPrice = data.getString("opening_price")
                        val closingPrice = data.getString("closing_price")
                        val minPrice = data.getString("min_price")
                        val maxPrice = data.getString("max_price")
                        val unitsTraded = data.getString("units_traded")
                        val accTradeValue = data.getString("acc_trade_value")
                        val prevClosingPrice = data.getString("prev_closing_price")
                        val unitsTraded24H = data.getString("units_traded_24H")
                        val accTradeValue24H = data.getString("acc_trade_value_24H")
                        val fluctuate24H = data.getString("fluctate_24H")
                        val fluctuateRate24H = data.getString("fluctate_rate_24H")
                        val date = data.getString("date")

                        val stringBuilder = StringBuilder()

                        stringBuilder.append(openingPrice)
                        stringBuilder.append("\n")

                        stringBuilder.append(closingPrice)
                        stringBuilder.append("\n")

                        stringBuilder.append(minPrice)
                        stringBuilder.append("\n")

                        stringBuilder.append(maxPrice)
                        stringBuilder.append("\n")

                        stringBuilder.append(unitsTraded)
                        stringBuilder.append("\n")

                        stringBuilder.append(accTradeValue)
                        stringBuilder.append("\n")

                        stringBuilder.append(prevClosingPrice)
                        stringBuilder.append("\n")

                        stringBuilder.append(unitsTraded24H)
                        stringBuilder.append("\n")

                        stringBuilder.append(accTradeValue24H)
                        stringBuilder.append("\n")

                        stringBuilder.append(fluctuate24H)
                        stringBuilder.append("\n")

                        stringBuilder.append(fluctuateRate24H)
                        stringBuilder.append("\n")

                        stringBuilder.append(date)

                        responseData2 = stringBuilder.toString()
                    }

                } catch (ex: Exception) {
                    android.util.Log.e(TAG, "onResponse Exception: ${ex.message}")
                }
            },
            { error ->
                android.util.Log.e(TAG, "requestGetData onErrorResponse: ${error.message}")
            }
        ).apply {
            retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
            setShouldCache(false)
        }
    }

}
