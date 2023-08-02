package com.daeseong.qrgooglezxing_test

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.qrgooglezxing_test.ui.theme.QRgooglezxing_testTheme
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import java.util.*

class QR1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Test1() {

    var qrText by remember { mutableStateOf("0123456789-qr:코드읽기") }
    var qrBitmap by remember { mutableStateOf<Bitmap?>(null) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp))
    {
        OutlinedTextField(
            value = qrText,
            onValueChange = { qrText = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    generateQRCodeBitmap(qrText)?.let {
                        qrBitmap = it
                    }
                }
            ),

            //border
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.DarkGray, unfocusedBorderColor = Color.LightGray, disabledBorderColor = Color.LightGray)
        )

        Divider(modifier = Modifier
            .padding(start = 10.dp)
            .padding(end = 10.dp), color = Color.Gray)

        Button(
            onClick = {
                generateQRCodeBitmap(qrText)?.let {
                    qrBitmap = it
                }
            },
            modifier = Modifier.fillMaxWidth())
        {
            Text("qr생성")
        }

        Spacer(modifier = Modifier.height(10.dp))
        
        Column( modifier = Modifier.fillMaxWidth().height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Box(modifier = Modifier
                .size(200.dp)
                .border(1.dp, Color.Black)
                .padding(10.dp),
                contentAlignment = Alignment.Center)
            {
                if (qrBitmap != null) {
                    val imageBitmap = qrBitmap?.asImageBitmap()
                    if (imageBitmap != null) {
                        Image(
                            bitmap = imageBitmap,
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
private fun generateQRCodeBitmap(content: String): Bitmap? {
    return try {
        val hints: MutableMap<EncodeHintType, Any> = EnumMap(EncodeHintType::class.java)
        hints[EncodeHintType.CHARACTER_SET] = "UTF-8"
        val bitMatrix: BitMatrix = MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300, hints)

        val width = bitMatrix.width
        val height = bitMatrix.height
        val pixels = IntArray(width * height)

        for (y in 0 until height) {
            val offset = y * width
            for (x in 0 until width) {
                pixels[offset + x] = if (bitMatrix[x, y]) 0xFF000000.toInt() else 0xFFFFFFFF.toInt()
            }
        }

        Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).apply {
            setPixels(pixels, 0, width, 0, 0, width, height)
        }
    } catch (e: WriterException) {
        e.printStackTrace()
        null
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    QRgooglezxing_testTheme {
        Test1()
    }
}