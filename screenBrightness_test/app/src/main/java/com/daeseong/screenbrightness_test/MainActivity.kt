package com.daeseong.screenbrightness_test

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daeseong.screenbrightness_test.ui.theme.ScreenBrightness_testTheme

class MainActivity : ComponentActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private val permissionSingleLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->

        if (isGranted) {
            Log.e(TAG, "권한 있음")
        } else {
            Log.e(TAG, "권한 거부")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentBrightness = getScreenBrightness(this)
        //Log.e(TAG, "현재 화면 밝기: $currentBrightness")

        //권한 체크
        checkPermission()

        setContent {
            slider_test(currentBrightness)
        }
    }

    private fun checkPermission() {

        if ( !Settings.System.canWrite(this) ) {
            this.startActivity(
                Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
                    .setData(Uri.parse("package:" + this.packageName))
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }

        /*
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE ) == PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "권한 있음")
        } else {
            permissionSingleLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        */
    }
}

private fun getScreenBrightness(context: Context): Float {

    val contentResolver = context.contentResolver

    return try {
        val screenBrightnessValue = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS)
        screenBrightnessValue / 255f // 0.0부터 1.0까지의 범위로 변환
    } catch (ex: Exception) {
        println(ex.message.toString())
        1.0f // 기본값으로 최대 밝기를 반환
    }
}

private fun setScreenBrightness(context: Context, brightness: Float) {

    val contentResolver = context.contentResolver

    try {

        val screenBrightnessValue = (brightness * 255).toInt()
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, screenBrightnessValue)

    } catch (ex: Exception) {
        println(ex.message.toString())
    }
}

@Composable
fun slider_test(currentBrightness: Float) {

    val context = LocalContext.current
    //var brightnessValue by remember { mutableStateOf(1f) }
    var brightnessValue by remember { mutableStateOf(currentBrightness) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        Slider(
            value = brightnessValue,
            onValueChange = { newValue ->
                brightnessValue = newValue
                setScreenBrightness(context, newValue)
            },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            colors = SliderDefaults.colors(thumbColor = MaterialTheme.colors.secondary, activeTrackColor = MaterialTheme.colors.secondary)
        )

        Text(
            text = "밝기: ${(brightnessValue * 100).toInt()}%",
            style = LocalTextStyle.current.copy(color = Color(0xFFFF9900), fontSize = 20.sp),
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScreenBrightness_testTheme {
        slider_test(1f)
    }
}
