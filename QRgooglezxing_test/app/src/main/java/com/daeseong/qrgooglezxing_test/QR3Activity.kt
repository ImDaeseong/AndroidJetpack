package com.daeseong.qrgooglezxing_test

import android.graphics.Bitmap
import android.graphics.Color
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daeseong.qrgooglezxing_test.ui.theme.QRgooglezxing_testTheme
import com.google.zxing.BarcodeFormat
import com.google.zxing.Writer
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

class QR3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3()
        }
    }
}

@Composable
fun Test3() {

    var qrText by remember { mutableStateOf("0123456789-qr:코드읽기") }
    var qrBitmap by remember { mutableStateOf<Bitmap?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp))
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
                    generateQRCode(qrText)?.let {
                        qrBitmap = it
                    }
                }
            ),

            //border
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = androidx.compose.ui.graphics.Color.DarkGray, unfocusedBorderColor = androidx.compose.ui.graphics.Color.LightGray, disabledBorderColor = androidx.compose.ui.graphics.Color.LightGray)
        )

        Divider(modifier = Modifier.padding(start = 10.dp).padding(end = 10.dp), color = androidx.compose.ui.graphics.Color.Gray)

        Button(
            onClick = {
                generateQRCode(qrText)?.let {
                    qrBitmap = it
                }
            },modifier = Modifier.fillMaxWidth())
        {
            Text("qr생성")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column( modifier = Modifier.fillMaxWidth().height(200.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Box(modifier = Modifier.size(200.dp).border(1.dp, androidx.compose.ui.graphics.Color.Black).padding(10.dp), contentAlignment = Alignment.Center)
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

private fun generateQRCode(data: String): Bitmap? {
    return try {
        val writer: Writer = QRCodeWriter()
        val bitMatrix: BitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bmp.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        bmp
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    QRgooglezxing_testTheme {
        Test3()
    }
}