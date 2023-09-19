package com.daeseong.volley_test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.daeseong.volley_test.ui.theme.Volley_testTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Volley1Activity : ComponentActivity() {

    private val TAG = Volley1Activity::class.java.simpleName

    private lateinit var requestQueue: RequestQueue

    //호출 정보
    private var dobType by mutableStateOf("1")
    private var dsptcKsco by mutableStateOf("01")
    private var continent by mutableStateOf("1")
    private var sepmt61 by mutableStateOf("Y")
    private var showItemListCount by mutableStateOf("1000")

    private var tv1 by mutableStateOf("")
    private var tv2 by mutableStateOf("")
    private val isMaxline = tv1.count { it == '\n' } >= 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initVolley()

        setContent {
            Volley_testTheme {

                Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()))
                {
                    Box(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(Color.White)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(16.dp)))
                    {
                        TextField(modifier = Modifier.fillMaxSize(),
                            value = tv1,
                            onValueChange = { newValue ->
                                tv1 = newValue },
                            keyboardOptions = if (isMaxline) {
                                KeyboardOptions.Default.copy(
                                    imeAction = ImeAction.Next
                                )
                            } else {
                                KeyboardOptions.Default
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(Color.White)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(16.dp)))
                    {
                        TextField(modifier = Modifier.fillMaxSize(),
                            value = tv2,
                            onValueChange = { newValue ->
                                tv2 = newValue }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    // Spacer를 사용하여 버튼을 컬럼의 맨 아래에 위치
                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = {
                            requestGetData()
                            requestPOSTData()
                        },
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(size = 16.dp))
                    {
                        Text(text = "Button 1")
                    }

                    Spacer(modifier = Modifier.height(10.dp))
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

    private fun requestGetData() {

        val url = "http://www.worldjob.or.kr/openapi/openapi.do?"

        val params = mapOf(
            "dobType" to dobType,
            "dsptcKsco" to dsptcKsco,
            "continent" to continent,
            "sepmt61" to sepmt61,
            "showItemListCount" to showItemListCount
        )

        val stringRequest = StringRequest(
            Request.Method.GET,
            url + params.entries.joinToString("&") { (key, value) -> "$key=$value" },
            { response ->
                tv1 = response
            },
            { error ->
                tv1 = "Error: ${error.message}"
            }
        )

        stringRequest.retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.setShouldCache(false)
        requestQueue.add(stringRequest)
    }

    private fun requestPOSTData() {

        val url = "http://www.worldjob.or.kr/openapi/openapi.do?"

        val params = mapOf(
            "dobType" to dobType,
            "dsptcKsco" to dsptcKsco,
            "continent" to continent,
            "sepmt61" to sepmt61,
            "showItemListCount" to showItemListCount
        )

        val stringRequest = object : StringRequest(
            Method.POST,
            url,
            Response.Listener { response ->
                tv2 = response
            },
            Response.ErrorListener { error ->
                tv2 = "Error: ${error.message}"
            }) {

            override fun getParams(): MutableMap<String, String> {
                return params.toMutableMap()
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = "application/x-www-form-urlencoded; charset=UTF-8"
                return headers
            }
        }

        stringRequest.retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.setShouldCache(false)
        requestQueue.add(stringRequest)
    }
}
