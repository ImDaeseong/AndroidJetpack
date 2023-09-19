package com.daeseong.volley_test

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.android.volley.DefaultRetryPolicy
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley

class Volley2Activity : ComponentActivity() {

    private val TAG = Volley2Activity::class.java.simpleName

    private lateinit var requestQueue: RequestQueue
    private var imageUrl by mutableStateOf("https://cdn.pixabay.com/photo/2016/03/23/08/34/woman-1274361_960_720.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initVolley()

        setContent {

            Surface(modifier = Modifier.fillMaxSize(),  color = MaterialTheme.colors.background)
            {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Image(
                        painter = rememberImagePainter(data = imageUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .border(width = 1.dp, color = Color.Red, shape = RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(onClick = { requestQueue.add(requestImage()) },
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp))
                    {
                        Text(text = "Button 1")
                    }
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

    private fun requestImage(): ImageRequest {

        val sUrl = "https://cdn.pixabay.com/photo/2015/07/14/18/14/school-845196_960_720.png"

        val ir = ImageRequest(
            sUrl,
            { response ->
                imageUrl = sUrl // 이미지 로드 완료 후 imageUrl을 업데이트
            },
            0,
            0,
            ImageView.ScaleType.CENTER,
            null,
            { error ->
                Log.e(TAG, "Error: ${error.message}")
            }
        )

        ir.retryPolicy = DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        ir.setShouldCache(false)
        return ir
    }
}
