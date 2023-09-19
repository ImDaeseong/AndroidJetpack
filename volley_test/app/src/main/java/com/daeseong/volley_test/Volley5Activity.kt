package com.daeseong.volley_test

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class Volley5Activity : ComponentActivity() {

    private val TAG = Volley5Activity::class.simpleName

    private val sPage = "http://www.worldjob.or.kr/openapi/openapi.do"
    private val sdobType = "1" // 1:해외취업,2:해외연수,3:해외인턴,4:해외봉사,5:해외창업
    private val sdsptcKsco = "01" // 직종별코드(해외취업,연수만 사용)01:전산,컴퓨터,02:전기/전자,06:기계/금속,07:건설/토목,08:사무/서비스,09:의료,10:기타
    private val scontinent = "1" // 대륙별코드 1:아시아,2:북아메리카, 3:남아메리카,4:유럽,5:오세아니아,6:아프리카
    private val sepmt61 = "Y" // 일자리Best20(해외취업만 사용)Y,N
    private val sshowItemListCount = "1000" // 한번에보여질리스트갯수출력결과

    private var responseText1 by mutableStateOf("")
    private var responseText2 by mutableStateOf("")

    private var isLoading by mutableStateOf(false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val context = LocalContext.current

            Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp))
            {
                LazyColumn(modifier = Modifier.fillMaxSize().weight(1f).background(color = Color.LightGray, shape = RoundedCornerShape(16.dp)))
                {
                    item {
                        Text(
                            text = responseText1,
                            modifier = Modifier.padding(10.dp),
                            style = LocalTextStyle.current.copy(color = Color.Black, fontSize = 16.sp, lineHeight = 24.sp),
                            maxLines = Int.MAX_VALUE
                        )
                    }
                }

                LazyColumn(modifier = Modifier.fillMaxSize().weight(1f).background(color = Color.LightGray, shape = RoundedCornerShape(16.dp)))
                {
                    item {
                        Text(
                            text = responseText2,
                            modifier = Modifier.padding(10.dp),
                            style = LocalTextStyle.current.copy(color = Color.Black, fontSize = 16.sp, lineHeight = 24.sp),
                            maxLines = Int.MAX_VALUE
                        )
                    }
                }

                Row(modifier = Modifier.fillMaxWidth())
                {
                    Button(
                        onClick = {
                            isLoading = !isLoading

                            val url = buildString {
                                append(sPage)
                                append("?dobType=$sdobType")
                                append("&dsptcKsco=$sdsptcKsco")
                                append("&continent=$scontinent")
                                append("&showItemListCount=$sshowItemListCount")
                                append("&sepmt61=$sepmt61")
                            }

                            getData(
                                sUrl = url,
                                context = context,
                                onResponse = { response ->
                                    responseText1 = response
                                    isLoading = false
                                },
                                onError = {
                                    isLoading = false
                                }
                            )
                        },
                        modifier = Modifier.padding(horizontal = 10.dp).weight(1f),
                        shape = RoundedCornerShape(size = 16.dp))
                    {
                        Text(text = "Button 1")
                    }

                    Button(
                        onClick = {
                            isLoading = !isLoading

                            postData(
                                sUrl = sPage,
                                context = context,
                                params = arrayOf(sdobType, sdsptcKsco, scontinent, sshowItemListCount, sepmt61),
                                onResponse = { response ->
                                    responseText2 = response
                                    isLoading = false
                                },
                                onError = {
                                    isLoading = false
                                }
                            )
                        },
                        modifier = Modifier.padding(horizontal = 10.dp).weight(1f),
                        shape = RoundedCornerShape(size = 16.dp))
                    {
                        Text(text = "Button 2")
                    }

                    if (isLoading) {

                        Box(modifier = Modifier.fillMaxSize()
                            .clickable {
                                isLoading = !isLoading
                            },
                            contentAlignment = Alignment.Center)
                        {
                            CircularProgressIndicator(
                                strokeWidth = 2.dp,
                                color = MaterialTheme.colors.primary
                            )
                        }
                    }

                }

            }

        }
    }


    fun getData(sUrl: String, context: Context, onResponse: (String) -> Unit, onError: () -> Unit) {

        val sr = StringRequest(
            Request.Method.GET, sUrl,
            { response ->
                onResponse(response)
            },
            { error ->
                error.message?.let {
                    onError()
                }
            }
        )
        sr.retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        sr.setShouldCache(false)
        sr.tag = "getData"

        MyApplication.getRequestQueue().add(sr)
    }

    fun postData(sUrl: String, context: Context, params: Array<String>, onResponse: (String) -> Unit, onError: () -> Unit) {

        val sr = object : StringRequest(Request.Method.POST, sUrl,
            Response.Listener { response ->
                onResponse(response)
            },
            Response.ErrorListener { error ->
                error.message?.let {
                    onError()
                }
            }
        ) {
            override fun getParams(): Map<String, String> {
                val param = HashMap<String, String>()
                param["dobType"] = params[0]
                param["dsptcKsco"] = params[1]
                param["continent"] = params[2]
                param["showItemListCount"] = params[3]
                param["sepmt61"] = params[4]
                return param
            }
        }
        sr.retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        sr.setShouldCache(false)
        sr.tag = "postData"

        MyApplication.getRequestQueue().add(sr)
    }

}
